/*
 * Copyright 2011 International Health Terminology Standards Development Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ihtsdo.ttk.api.blueprint;

//~--- non-JDK imports --------------------------------------------------------
import org.ihtsdo.ttk.api.ComponentBI;
import org.ihtsdo.ttk.api.ComponentChronicleBI;
import org.ihtsdo.ttk.api.ComponentVersionBI;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologyBuilderBI;
import org.ihtsdo.ttk.api.Ts;
import org.ihtsdo.ttk.api.concept.ConceptVersionBI;
import org.ihtsdo.ttk.api.coordinate.ViewCoordinate;
import org.ihtsdo.ttk.api.metadata.binding.SnomedMetadataRf2;
import org.ihtsdo.ttk.api.refex.RefexVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class CreateOrAmendBlueprint contains methods for creating a terminology generic blueprint. This
 * blueprint can be constructed into a type of
 * <code>ComonentChronicleBI</code>. This is the preferred method for updating or creating new components or
 * concepts.
 *
 * @see TerminologyBuilderBI
 * @see ComponentChronicleBI
 */
public abstract class CreateOrAmendBlueprint implements PropertyChangeListener {

    protected EnumMap<ComponentProperty, Object> properties =
            new EnumMap<>(ComponentProperty.class);
    /**
     * Field description
     */
    private static UUID currentStatusUuid = null;
    /**
     * Field description
     */
    private static UUID retiredStatusUuid = null;
    /**
     * Field description
     */
    private List<RefexCAB> annotations = new ArrayList<>();
    /**
     * Field description
     */
    private static AtomicLong propigationId = new AtomicLong();
    
   private Object lastPropigationId = Long.MIN_VALUE;

    /**
     * Field description
     */
    protected PropertyChangeSupport pcs = new PropertyChangeSupport(this) {
        @Override
        public void firePropertyChange(PropertyChangeEvent event) {
            event.setPropagationId(propigationId.incrementAndGet());
            super.firePropertyChange(event);
        }
    };
    /**
     * Map to hold additional IDs.
     */
    private HashMap<Object, Integer> idMap = new HashMap<>();
    /**
     * Field description
     */
    private ComponentVersionBI cv;
    /**
     * Field description
     */
    private ViewCoordinate vc;
    /**
     * Field description
     */
    protected IdDirective idDirective;
    /**
     * Field description
     */
    protected RefexDirective refexDirective;
    protected ComponentChronicleBI<?> referencedComponent;

    public ComponentChronicleBI<?> getReferencedComponent() {
        return referencedComponent;
    }

    public void setReferencedComponent(ComponentChronicleBI<?> referencedComponent) {
        this.referencedComponent = referencedComponent;
    }

    /**
     * Instantiates a new create or amend blueprint.
     *
     * @param componentUuid the uuid of the component specified by this blueprint
     * @param componentVersion the component version to create this blueprint from
     * @param viewCoordinate the view coordinate specifying which versions are active and inactive
     * @param idDirective
     * @param refexDirective
     * @throws IOException signals that an I/O exception has occurred
     * @throws InvalidCAB if the any of the values in blueprint to make are invalid
     * @throws ContradictionException if more than one version is returned for the view coordinate
     */
    public CreateOrAmendBlueprint(UUID componentUuid, ComponentVersionBI componentVersion,
            ViewCoordinate viewCoordinate, IdDirective idDirective,
            RefexDirective refexDirective)
            throws IOException, InvalidCAB, ContradictionException {
        if (currentStatusUuid == null || retiredStatusUuid == null) {
            currentStatusUuid = SnomedMetadataRf2.ACTIVE_VALUE_RF2.getUuids()[0];
            retiredStatusUuid = SnomedMetadataRf2.INACTIVE_VALUE_RF2.getUuids()[0];
        }
        setStatusUuid(currentStatusUuid);
        setComponentUuidNoRecompute(componentUuid);

        if (idDirective == IdDirective.PRESERVE) {
            setComponentUuidNoRecompute(componentVersion.getPrimUuid());
        } else if (idDirective == IdDirective.GENERATE_RANDOM) {
            setComponentUuidNoRecompute(UUID.randomUUID());
        } else if ((cv instanceof ConceptVersionBI)
                && (idDirective == IdDirective.GENERATE_RANDOM_CONCEPT_REST_HASH)) {
            setComponentUuidNoRecompute(UUID.randomUUID());
        } else if ((cv instanceof ConceptVersionBI)
                && (idDirective == IdDirective.PRESERVE_CONCEPT_REST_HASH)) {
            setComponentUuidNoRecompute(componentVersion.getPrimUuid());
        }

        this.idDirective = idDirective;
        this.refexDirective = refexDirective;
        this.cv = componentVersion;
        this.vc = viewCoordinate;
        getAnnotationBlueprintsFromOriginal();
        pcs.addPropertyChangeListener(this);
    }

    /**
     * Adds an annotation blueprint to be associated with this component blueprint.
     *
     * @param annotationBlueprint the annotation blueprint to associate with this component blueprint
     */
    public void addAnnotationBlueprint(RefexCAB annotationBlueprint) {
        annotations.add(annotationBlueprint);
    }

    /**
     * Adds an additional
     * <code>UUID</code> ID to the component specified by this component blueprint. This is a UUID in addition
     * to the primordial uuid associated with this concept. Use setComponentUuid to set the primordial uuid.
     *
     * @param extraUuid the uuid identifier to add
     * @param authorityNid the authority associated with the identifier
     * @see CreateOrAmendBlueprint#setComponentUuid(java.util.UUID)
     */
    public void addExtraUuid(UUID extraUuid, int authorityNid) {
        idMap.put(extraUuid, authorityNid);
    }

    /**
     * Adds an additional
     * <code>long</code> ID to the component specified by this component blueprint. Any SCT IDs to add to this
     * concept should be added using this method.
     *
     * @param longId the long identifier to add
     * @param authorityNid the authority associated with the identifier
     */
    public void addLongId(Long longId, int authorityNid) {
        idMap.put(longId, authorityNid);
    }

    /**
     * Adds the specified property change listener.
     *
     * @param propertyChangeListener the property change listener
     */
    public synchronized void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        pcs.addPropertyChangeListener(propertyChangeListener);
    }

    /**
     * Adds the specified property change listener.
     *
     * @param string the string describing the property name
     * @param propertyChangeListener the property change listener
     */
    public synchronized void addPropertyChangeListener(String string,
            PropertyChangeListener propertyChangeListener) {
        pcs.addPropertyChangeListener(string, propertyChangeListener);
    }

    /**
     * Adds an additional
     * <code>String</code> ID to the component specified by this component blueprint.
     *
     * @param stringId the string identifier to add
     * @param authorityNid the authority associated with the identifier
     */
    public void addStringId(String stringId, int authorityNid) {
        idMap.put(stringId, authorityNid);
    }

    /**
     * Listens for a property change event in any of the component blueprint classes and recomputes the
     * blueprints' computed uuid if a dependent component has changed.
     *
     * @param propertyChangeEvent the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!propertyChangeEvent.getPropagationId().equals(lastPropigationId)) {
            try {
                lastPropigationId = propertyChangeEvent.getPropagationId();
                recomputeUuid();
            } catch (NoSuchAlgorithmException | InvalidCAB | ContradictionException | IOException ex) {
                Logger.getLogger(CreateOrAmendBlueprint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is implemented by the other component blueprint classes. This allows the components to
     * recompute their uuids if a dependent component changes.
     *
     * @throws NoSuchAlgorithmException indicates a no such algorithm exception has occurred
     * @throws UnsupportedEncodingException indicates an unsupported encoding exception has occurred
     * @throws IOException signals that an I/O exception has occurred
     * @throws InvalidCAB if the any of the values in blueprint to make are invalid
     * @throws ContradictionException if more than one version is found for a give position or view coordinate
     */
    public abstract void recomputeUuid()
            throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException, InvalidCAB,
            ContradictionException;

    /**
     * Removes the specified property change listener.
     *
     * @param propertyChangeListener the property change listener
     */
    public synchronized void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        pcs.removePropertyChangeListener(propertyChangeListener);
    }

    /**
     * Removes the specified property change listener.
     *
     * @param string the string describing the property name
     * @param propertyChangeListener the property change listener
     */
    public synchronized void removePropertyChangeListener(String string,
            PropertyChangeListener propertyChangeListener) {
        pcs.removePropertyChangeListener(string, propertyChangeListener);
    }

    /**
     * Replace the annotation blueprints associated with this blueprint with the given list of
     * <code>annoationBlueprints</code>.
     *
     * @param annotationBlueprints the annotation blueprints to associate with this component blueprint
     */
    public void replaceAnnotationBlueprints(List<RefexCAB> annotationBlueprints) {
        this.annotations = annotationBlueprints;
    }

    /**
     * Returns list of annotation blueprints associated with this component blueprint.
     *
     * @return a list of annotation blueprints associated with this component
     * @throws IOException signals that an I/O exception has occurred
     * @throws InvalidCAB if the any of the values in blueprint to make are invalid
     * @throws ContradictionException if more then one version is found for a particular view coordinate
     */
    public List<RefexCAB> getAnnotationBlueprints() throws IOException, InvalidCAB, ContradictionException {
        return annotations;
    }

    /**
     * Returns list of annotation blueprints associated with this component blueprint. Gets a list from the
     * original component if null.
     *
     * @return a list of annotation blueprints associated with this component
     * @throws IOException signals that an I/O exception has occurred
     * @throws InvalidCAB if the any of the values in blueprint to make are invalid
     * @throws ContradictionException if more then one version is found for a particular view coordinate
     */
    private List<RefexCAB> getAnnotationBlueprintsFromOriginal()
            throws IOException, InvalidCAB, ContradictionException {
        if (annotations.isEmpty() && (cv != null)) {
            if (refexDirective == RefexDirective.INCLUDE) {
                if (cv.getRefexesActive(vc) != null) {
                    Collection<? extends RefexVersionBI<?>> originalRefexes = cv.getRefexesActive(vc);

                    if (!originalRefexes.isEmpty()) {
                        IdDirective refexIdDirective = idDirective;

                        switch (idDirective) {
                            case GENERATE_RANDOM:
                            case GENERATE_HASH:
                            case GENERATE_RANDOM_CONCEPT_REST_HASH:
                            case PRESERVE_CONCEPT_REST_HASH:
                                idDirective = IdDirective.GENERATE_HASH;

                                break;

                            case GENERATE_REFEX_CONTENT_HASH:
                                idDirective = IdDirective.GENERATE_REFEX_CONTENT_HASH;

                                break;

                            case PRESERVE:
                                idDirective = IdDirective.PRESERVE;

                                break;
                        }

                        for (RefexVersionBI refex : originalRefexes) {
                            RefexCAB refexCab = refex.makeBlueprint(vc, refexIdDirective, refexDirective);

                            refexCab.setReferencedComponentUuid(getComponentUuid());
                            refexCab.recomputeUuid();
                            annotations.add(refexCab);
                        }
                    }
                }
            }
        }

        return annotations;
    }

    /**
     * Gets the nid of the component specified by this blueprint.
     *
     * @return the nid of the component specified by this blueprint.
     * @throws IOException signals that an I/O exception has occurred
     */
    public int getComponentNid() throws IOException {
        return getInt(ComponentProperty.COMPONENT_ID);
    }

    /**
     * Method description
     *
     *
     * @param componentUuid
     * @param cv
     * @param idDirective
     *
     * @return
     */
    protected static UUID getComponentUUID(UUID componentUuid, ComponentVersionBI cv,
            IdDirective idDirective) {
        if (componentUuid != null) {
            return componentUuid;
        }

        switch (idDirective) {
            case GENERATE_RANDOM:
                return UUID.randomUUID();

            case PRESERVE:
                if (cv != null) {
                    return cv.getPrimUuid();
                }
        }

        return null;
    }

    /**
     * Gets the uuid of the component specified by this blueprint.
     *
     * @return the uuid of the component specified by this blueprint
     */
    public UUID getComponentUuid() {
        return getUuid(ComponentProperty.COMPONENT_ID);
    }

    /**
     * Returns a map of IDs as
     * <code>Objects</code> and their associated authority nids. The supported IDs are currently: long,
     * string, and uuid.
     *
     * @return a map of IDs as <code>Objects</code> and their associated authority nids
     */
    public HashMap<Object, Integer> getIdMap() {
        return idMap;
    }

    /**
     * Gets a string representing the primordial uuid for the component specified by the
     * <code>componentNid</code>. This is uuid associated with the first version of the component.
     *
     * @param componentNid the nid associated with the component in question
     * @return a string representing the primordial uuid of the component in question
     * @throws IOException signals that an I/O exception has occurred
     * @throws InvalidCAB if the any of the values in blueprint to make are invalid
     */
    protected String getPrimoridalUuidString(int componentNid) throws IOException, InvalidCAB {
        ComponentBI component = Ts.get().getComponent(componentNid);

        if (component != null) {
            return component.getPrimUuid().toString();
        }

        List<UUID> uuids = Ts.get().getUuidsForNid(componentNid);

        if (uuids.size() == 1) {
            return uuids.get(0).toString();
        }

        throw new InvalidCAB("Can't find primordialUuid for: " + component);
    }

    /**
     * Gets a string representing the primordial uuid for the component specified by the
     * <code>uuid/code>. This is uuid associated with the first version of the component.
     *
     * @param uuid the uuid of the component in question
     * @return a string representing the primordial uuid of the component in question
     * @throws IOException signals that an I/O exception has occurred
     * @throws InvalidCAB if the any of the values in blueprint to make are invalid
     */
    protected String getPrimoridalUuidString(UUID uuid) throws IOException, InvalidCAB {
        if (Ts.get() == null) {
            return uuid.toString();
        }
        if (Ts.get().hasUuid(uuid)) {
            ComponentChronicleBI<?> component = Ts.get().getComponent(uuid);

            if (component == null) {
                return uuid.toString();
            }

            return Ts.get().getComponent(uuid).getPrimUuid().toString();
        }

        return uuid.toString();
    }

    /**
     * Gets the nid of the status associated with this component blueprint.
     *
     * @return the nid of the status associated with this component blueprint
     * @throws IOException signals that an I/O exception has occurred
     */
    public int getStatusNid() throws IOException {
        return getInt(ComponentProperty.STATUS_ID);
    }

    /**
     * Gets the uuid of the status associated with this component blueprint.
     *
     * @return the uuid of the status associated with this component blueprint
     */
    public UUID getStatusUuid() {
        return getUuid(ComponentProperty.STATUS_ID);
    }

    /**
     * Sets the uuid of the component specified by this blueprint.
     *
     * @param componentUuid the uuid of the component specified by this blueprint
     */
    public void setComponentUuid(UUID componentUuid) {
        UUID oldUuid = (UUID) properties.get(ComponentProperty.COMPONENT_ID);
        properties.put(ComponentProperty.COMPONENT_ID, componentUuid);
        pcs.firePropertyChange("componentUuid", oldUuid, componentUuid);
    }

    /**
     * Sets the component uuid. Does not fire a property change event for the changed uuid. No dependent
     * component uuids will be recomputed. This is useful when setting the component uuid to a pre-determined
     * uuid, and purposefully not use a re-computable uuid.
     *
     * @param componentUuid the new component uuid no recompute
     */
    public final void setComponentUuidNoRecompute(UUID componentUuid) {
        properties.put(ComponentProperty.COMPONENT_ID, componentUuid);
    }

    /**
     * Sets this component blueprint's status to active.
     */
    public void setCurrent() {
        properties.put(ComponentProperty.STATUS_ID, currentStatusUuid);
    }

    /**
     * Sets this component blueprint's status to retired.
     */
    public void setRetired() {
        properties.put(ComponentProperty.STATUS_ID, retiredStatusUuid);
    }

    /**
     * Sets the uuid of the status associated with this component blueprint.
     *
     * @param statusUuid the uuid of the status associated with this component blueprint
     */
    public final void setStatusUuid(UUID statusUuid) {
        properties.put(ComponentProperty.STATUS_ID, statusUuid);
    }

    /**
     * Gets an integer representation of the value associated with the given refex property
     * <code>key</code>.
     *
     * @param key the refex property key
     * @return an integer representation of the value associated with the specified refex property
     */
    public int getInt(ComponentProperty key) {
        Object obj = properties.get(key);
        if (obj instanceof UUID) {
            try {
                return Ts.get().getNidForUuids((UUID) obj);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return (Integer) obj;
    }

    /**
     * Gets an UUID representation of the value associated with the given refex property
     * <code>key</code>.
     *
     * @param key the refex property key
     * @return an integer representation of the value associated with the specified refex property
     */
    public UUID getUuid(ComponentProperty key) {
        Object obj = properties.get(key);
        if (obj == null) {
            return null;
        }
        if (obj instanceof UUID) {
            return (UUID) obj;
        }
        try {
            return Ts.get().getUuidPrimordialForNid((Integer) obj);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

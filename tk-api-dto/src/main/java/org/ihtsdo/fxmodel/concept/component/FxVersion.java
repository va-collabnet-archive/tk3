package org.ihtsdo.fxmodel.concept.component;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.fxmodel.FxTime;
import org.ihtsdo.fxmodel.concept.component.attribute.FxConceptAttributesVersion;
import org.ihtsdo.fxmodel.concept.component.description.FxDescriptionVersion;
import org.ihtsdo.fxmodel.concept.component.identifier.FxIdentifier;
import org.ihtsdo.fxmodel.concept.component.media.FxMediaVersion;
import org.ihtsdo.fxmodel.concept.component.refex.type_boolean.FxRefexBooleanVersion;
import org.ihtsdo.fxmodel.concept.component.refex.type_comp.FxRefexCompVersion;
import org.ihtsdo.fxmodel.concept.component.refex.type_int.FxRefexIntVersion;
import org.ihtsdo.fxmodel.concept.component.refex.type_long.FxRefexLongVersion;
import org.ihtsdo.fxmodel.concept.component.refex.type_member.FxRefexMembershipVersion;
import org.ihtsdo.fxmodel.concept.component.refex.type_string.FxRefexStringVersion;
import org.ihtsdo.fxmodel.concept.component.relationship.FxRelationshipVersion;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ComponentBI;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.ContradictionException;
import org.ihtsdo.tk.api.TerminologySnapshotDI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.id.IdBI;

@XmlSeeAlso( {
   FxConceptAttributesVersion.class, FxDescriptionVersion.class, FxIdentifier.class,
   FxRelationshipVersion.class, FxMediaVersion.class, FxRefexCompVersion.class, FxDescriptionVersion.class,
   FxRefexLongVersion.class, FxRefexMembershipVersion.class, FxRefexBooleanVersion.class,
   FxRefexStringVersion.class, FxRefexIntVersion.class
})
public abstract class FxVersion implements Serializable {
   private static final long serialVersionUID    = 1;
   public static UUID        unspecifiedUserUuid = UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c");

   //~--- fields --------------------------------------------------------------

   private FxComponentReference                       authorReference;
   private SimpleObjectProperty<FxComponentReference> authorReferenceProperty;
   private FxTime                                     fxTime;
   private SimpleObjectProperty<FxTime>               fxTimeProperty;
   private FxComponentReference                       moduleReference;
   private SimpleObjectProperty<FxComponentReference> moduleReferenceProperty;
   private FxComponentReference                       pathReference;
   private SimpleObjectProperty<FxComponentReference> pathReferenceProperty;
   private FxComponentReference                       statusReference;
   private SimpleObjectProperty<FxComponentReference> statusReferenceProperty;

   //~--- constructors --------------------------------------------------------

   public FxVersion() {
      super();
   }

   public FxVersion(TerminologySnapshotDI ss, ComponentVersionBI another)
           throws IOException, ContradictionException {
      super();
      statusReference = new FxComponentReference(ss.getConceptForNid(another.getStatusNid()));
      fxTime          = new FxTime(another.getTime());
      authorReference = new FxComponentReference(ss.getConceptForNid(another.getAuthorNid()));
      moduleReference = new FxComponentReference(ss.getConceptForNid(another.getModuleNid()));
      pathReference   = new FxComponentReference(ss.getConceptForNid(another.getPathNid()));
   }

   public FxVersion(TerminologySnapshotDI ss, IdBI id) throws IOException, ContradictionException {
      super();
      statusReference = new FxComponentReference(ss.getConceptVersion(id.getStatusNid()));
      fxTime          = new FxTime(id.getTime());
      authorReference = new FxComponentReference(ss.getConceptVersion(id.getAuthorNid()));
      moduleReference = new FxComponentReference(ss.getConceptVersion(id.getPathNid()));
      pathReference   = new FxComponentReference(ss.getConceptVersion(id.getModuleNid()));
   }

   //~--- methods -------------------------------------------------------------

   public SimpleObjectProperty<FxComponentReference> authorReferenceProperty() {
      if (authorReferenceProperty == null) {
         authorReferenceProperty = new SimpleObjectProperty<>(this, "authorReference", authorReference);
      }

      return authorReferenceProperty;
   }

   public SimpleObjectProperty<FxTime> fxTimeProperty() {
      if (fxTimeProperty == null) {
         fxTimeProperty = new SimpleObjectProperty<>(this, "time", fxTime);
      }

      return fxTimeProperty;
   }

   public static CharSequence informAboutUuid(UUID uuid) {
      if (uuid == null) {
         return "null";
      }

      if (Ts.get() == null) {
         return uuid.toString();
      }

      StringBuilder sb = new StringBuilder();

      if (Ts.get().hasUuid(uuid)) {
         try {
            int nid  = Ts.get().getNidForUuids(uuid);
            int cNid = Ts.get().getConceptNidForNid(nid);

            if (cNid == nid) {
               ConceptChronicleBI cc = Ts.get().getConcept(cNid);

               sb.append("'");
               sb.append(cc.toUserString());
               sb.append("' ");
               sb.append(cNid);
               sb.append(" ");
            } else {
               ComponentBI component = Ts.get().getComponent(nid);

               sb.append("comp: '");

               if (component != null) {
                  sb.append(component.toUserString());
               } else {
                  sb.append("null");
               }

               sb.append("' ");
               sb.append(nid);
               sb.append(" ");
            }
         } catch (IOException ex) {
            Logger.getLogger(FxVersion.class.getName()).log(Level.SEVERE, null, ex);
         }
      }

      sb.append(uuid.toString());

      return sb;
   }

   public SimpleObjectProperty<FxComponentReference> moduleReferenceProperty() {
      if (moduleReferenceProperty == null) {
         moduleReferenceProperty = new SimpleObjectProperty<>(this, "moduleReference", moduleReference);
      }

      return moduleReferenceProperty;
   }

   public SimpleObjectProperty<FxComponentReference> pathReferenceProperty() {
      if (pathReferenceProperty == null) {
         pathReferenceProperty = new SimpleObjectProperty<>(this, "pathReference", pathReference);
      }

      return pathReferenceProperty;
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_VersionExternal#getPathReference()
    */
   public SimpleObjectProperty<FxComponentReference> statusReferenceProperty() {
      if (statusReferenceProperty == null) {
         statusReferenceProperty = new SimpleObjectProperty<>(this, "status", statusReference);
      }

      return statusReferenceProperty;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" s:");
      buff.append(getStatusReference());
      buff.append(" t: ");
      buff.append(getFxTime());
      buff.append(" a:");
      buff.append(getAuthorReference());
      buff.append(" m:");
      buff.append(getModuleReference());
      buff.append(" p:");
      buff.append(getPathReference());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getAuthorReference() {
      return (authorReferenceProperty == null)
             ? authorReference
             : authorReferenceProperty.get();
   }

   public FxTime getFxTime() {
      return (fxTimeProperty == null)
             ? fxTime
             : fxTimeProperty.get();
   }

   public FxComponentReference getModuleReference() {
      return (moduleReferenceProperty == null)
             ? moduleReference
             : moduleReferenceProperty.get();
   }

   public FxComponentReference getPathReference() {
      return (pathReferenceProperty == null)
             ? pathReference
             : pathReferenceProperty.get();
   }

   public FxComponentReference getStatusReference() {
      return (statusReferenceProperty == null)
             ? statusReference
             : statusReferenceProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setAuthorReference(FxComponentReference authorReference) {
      if (authorReferenceProperty == null) {
         this.authorReference = authorReference;
      } else {
         authorReferenceProperty.set(authorReference);
      }
   }

   public void setFxTime(FxTime fxTime) {
      if (fxTimeProperty == null) {
         this.fxTime = fxTime;
      } else {
         fxTimeProperty.set(fxTime);
      }
   }

   public void setModuleReference(FxComponentReference moduleReference) {
      if (moduleReferenceProperty == null) {
         this.moduleReference = moduleReference;
      } else {
         moduleReferenceProperty.set(moduleReference);
      }
   }

   public void setPathReference(FxComponentReference pathReference) {
      if (pathReferenceProperty == null) {
         this.pathReference = pathReference;
      } else {
         pathReferenceProperty.set(pathReference);
      }
   }

   public void setStatusReference(FxComponentReference statusReference) {
      if (statusReferenceProperty == null) {
         this.statusReference = statusReference;
      } else {
         statusReferenceProperty.set(statusReference);
      }
   }
}

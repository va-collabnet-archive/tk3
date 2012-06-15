package org.ihtsdo.fxmodel.concept.component;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.fxmodel.FxComponentRef;
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

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.Serializable;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlSeeAlso;

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

   private final SimpleObjectProperty<FxComponentRef> statusReferenceProperty =
      new SimpleObjectProperty<>(this, "status");
   private final SimpleObjectProperty<FxComponentRef> pathReferenceProperty =
      new SimpleObjectProperty<>(this, "path");
   private final SimpleObjectProperty<FxComponentRef> moduleReferenceProperty =
      new SimpleObjectProperty<>(this, "module");
   private final SimpleObjectProperty<FxTime>         fxTimeProperty          = new SimpleObjectProperty<>(this, "time");
   private final SimpleObjectProperty<FxComponentRef> authorReferenceProperty =
      new SimpleObjectProperty<>(this, "author");

   //~--- constructors --------------------------------------------------------

   public FxVersion() {
      super();
   }

   public FxVersion(TerminologySnapshotDI ss, ComponentVersionBI another)
           throws IOException, ContradictionException {
      super();
      statusReferenceProperty.set(new FxComponentRef(ss.getConceptForNid(another.getStatusNid())));
      fxTimeProperty.set(new FxTime(another.getTime()));
      authorReferenceProperty.set(new FxComponentRef(ss.getConceptForNid(another.getAuthorNid())));
      moduleReferenceProperty.set(new FxComponentRef(ss.getConceptForNid(another.getModuleNid())));
      pathReferenceProperty.set(new FxComponentRef(ss.getConceptForNid(another.getPathNid())));
   }

   public FxVersion(TerminologySnapshotDI ss, IdBI id) throws IOException, ContradictionException {
      super();
      statusReferenceProperty.set(new FxComponentRef(ss.getConceptVersion(id.getStatusNid())));
      fxTimeProperty.set(new FxTime(id.getTime()));
      authorReferenceProperty.set(new FxComponentRef(ss.getConceptVersion(id.getAuthorNid())));
      moduleReferenceProperty.set(new FxComponentRef(ss.getConceptVersion(id.getPathNid())));
      pathReferenceProperty.set(new FxComponentRef(ss.getConceptVersion(id.getModuleNid())));
   }

   //~--- methods -------------------------------------------------------------

   public SimpleObjectProperty<FxComponentRef> authorReferenceProperty() {
      return authorReferenceProperty;
   }

   public SimpleObjectProperty<FxTime> fxTimeProperty() {
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

   public SimpleObjectProperty<FxComponentRef> pathReferenceProperty() {
      return pathReferenceProperty;
   }

   public SimpleObjectProperty<FxComponentRef> statusReferenceProperty() {
      return statusReferenceProperty;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" s:");
      buff.append(statusReferenceProperty.get());
      buff.append(" t: ");
      buff.append(fxTimeProperty.get());
      buff.append(" a:");
      buff.append(authorReferenceProperty.get());
      buff.append(" m:");
      buff.append(moduleReferenceProperty.get());
      buff.append(" p:");
      buff.append(pathReferenceProperty.get());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentRef getAuthorReference() {
      return authorReferenceProperty.get();
   }

   public FxTime getFxTime() {
      return fxTimeProperty.get();
   }

   public FxComponentRef getModuleReference() {
      return moduleReferenceProperty.get();
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_VersionExternal#getPathReference()
    */
   public FxComponentRef getPathReference() {
      return pathReferenceProperty.get();
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_VersionExternal#getStatusReference()
    */
   public FxComponentRef getStatusReference() {
      return statusReferenceProperty.get();
   }

   //~--- set methods ---------------------------------------------------------

   public void setAuthorReference(FxComponentRef authorReference) {
      this.authorReferenceProperty.set(authorReference);
   }

   public void setFxTime(FxTime fxTime) {
      fxTimeProperty.set(fxTime);
   }

   public void setModuleReference(FxComponentRef moduleReference) {
      this.moduleReferenceProperty.set(moduleReference);
   }

   public void setPathReference(FxComponentRef pathReference) {
      this.pathReferenceProperty.set(pathReference);
   }

   public void setStatusReference(FxComponentRef statusReference) {
      this.statusReferenceProperty.set(statusReference);
   }
}

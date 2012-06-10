package org.ihtsdo.fxmodel.concept.component;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.ihtsdo.fxmodel.FxComponentReference;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.ComponentBI;
import org.ihtsdo.tk.api.ComponentVersionBI;
import org.ihtsdo.tk.api.concept.ConceptChronicleBI;
import org.ihtsdo.tk.api.id.IdBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ihtsdo.fxmodel.FxTime;

public abstract class FxVersion {
   private static final long serialVersionUID    = 1;
   public static UUID        unspecifiedUserUuid = UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c");

   //~--- fields --------------------------------------------------------------

   public final SimpleObjectProperty<FxComponentReference> statusReferenceProperty =
      new SimpleObjectProperty<>(this, "status", null);
   public final FxTime                         fxTime          = new FxTime();
   public final SimpleObjectProperty<FxComponentReference> pathReferenceProperty =
      new SimpleObjectProperty<>(this, "path", null);
   public final SimpleObjectProperty<FxComponentReference> moduleReferenceProperty =
      new SimpleObjectProperty<>(this, "module", null);
   public final SimpleObjectProperty<FxComponentReference> authorReferenceProperty =
      new SimpleObjectProperty<>(this, "author", null);

   //~--- constructors --------------------------------------------------------

   public FxVersion() {
      super();
   }

   public FxVersion(ComponentVersionBI another) throws IOException {
      super();
      statusReferenceProperty.set(new FxComponentReference(null, another.getStatusNid(), "status"));
      fxTime.setTime(another.getTime());
      authorReferenceProperty.set(new FxComponentReference(null, another.getAuthorNid(), "author"));
      moduleReferenceProperty.set(new FxComponentReference(null, another.getModuleNid(), "module"));
      pathReferenceProperty.set(new FxComponentReference(null, another.getPathNid(), "path"));
   }

   public FxVersion(IdBI id) throws IOException {
      super();
      statusReferenceProperty.set(new FxComponentReference(null, id.getStatusNid(), "status"));
      fxTime.setTime(id.getTime());
      authorReferenceProperty.set(new FxComponentReference(null, id.getAuthorNid(), "author"));
      moduleReferenceProperty.set(new FxComponentReference(null, id.getPathNid(), "module"));
      pathReferenceProperty.set(new FxComponentReference(null, id.getModuleNid(), "path"));
   }

   //~--- methods -------------------------------------------------------------

   public SimpleObjectProperty<FxComponentReference> authorReferenceProperty() {
      return authorReferenceProperty;
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

   public SimpleObjectProperty<FxComponentReference> pathReferenceProperty() {
      return pathReferenceProperty;
   }

   public SimpleObjectProperty<FxComponentReference> statusReferenceProperty() {
      return statusReferenceProperty;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(" s:");
      buff.append(statusReferenceProperty);
      buff.append(" a:");
      buff.append(authorReferenceProperty);
      buff.append(" p:");
      buff.append(pathReferenceProperty);
      buff.append(" t: ");
      buff.append(fxTime.getTimeText());
      buff.append(" ");
      buff.append(fxTime.getTime());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxComponentReference getAuthorReference() {
      return authorReferenceProperty.get();
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_VersionExternal#getPathReference()
    */
   public FxComponentReference getPathReference() {
      return pathReferenceProperty.get();
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_VersionExternal#getStatusReference()
    */
   public FxComponentReference getStatusReference() {
      return statusReferenceProperty.get();
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_VersionExternal#getTime()
    */
   public long getTime() {
      return fxTime.getTime();
   }

   //~--- set methods ---------------------------------------------------------

   public void setAuthorReference(FxComponentReference authorReference) {
      this.authorReferenceProperty.set(authorReference);
   }

   public void setPathReference(FxComponentReference pathReference) {
      this.pathReferenceProperty.set(pathReference);
   }

   public void setStatusReference(FxComponentReference statusReference) {
      this.statusReferenceProperty.set(statusReference);
   }

   public void setTime(long time) {
      fxTime.setTime(time);
   }
}

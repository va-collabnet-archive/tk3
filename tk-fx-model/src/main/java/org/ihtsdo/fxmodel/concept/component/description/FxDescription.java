package org.ihtsdo.fxmodel.concept.component.description;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.ihtsdo.fxmodel.concept.component.FxComponent;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.TerminologyStoreDI;
import org.ihtsdo.tk.api.description.DescriptionChronicleBI;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;
import org.ihtsdo.tk.api.ext.I_DescribeExternally;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;
import org.ihtsdo.fxmodel.concept.FxConcept;


public class FxDescription extends FxComponent<FxDescriptionRevision> implements I_DescribeExternally {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public StringProperty langProperty = new SimpleStringProperty();
   public StringProperty textProperty = new SimpleStringProperty();
   public FxConcept      concept;
   public boolean        initialCaseSignificant;
   public UUID           typeUuid;

   //~--- constructors --------------------------------------------------------

   public FxDescription() {
      super();
   }

   public FxDescription(FxConcept concept, DescriptionChronicleBI desc) throws IOException {
      super(desc.getPrimordialVersion());

      Collection<? extends DescriptionVersionBI> versions  = desc.getVersions();
      Iterator<? extends DescriptionVersionBI>   itr       = versions.iterator();
      TerminologyStoreDI                         ts        = Ts.get();
      int                                        partCount = versions.size();
      DescriptionVersionBI                       part      = itr.next();

      this.concept            = concept;
      initialCaseSignificant = part.isInitialCaseSignificant();
      langProperty.set(part.getLang());
      textProperty.set(part.getText());
      typeUuid   = ts.getUuidPrimordialForNid(part.getTypeNid());
      pathUuid   = ts.getUuidPrimordialForNid(part.getPathNid());
      statusUuid = ts.getUuidPrimordialForNid(part.getStatusNid());
      time       = part.getTime();

      if (partCount > 1) {
         revisions = new ArrayList<>(partCount - 1);

         while (itr.hasNext()) {
            DescriptionVersionBI dv = itr.next();

            revisions.add(new FxDescriptionRevision(dv));
         }
      }
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt> if and only if the argument
    * is not <tt>null</tt>, is a <tt>EDescription</tt> object, and contains the same values, field by field,
    * as this <tt>EDescription</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same; <code>false</code> otherwise.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxDescription.class.isAssignableFrom(obj.getClass())) {
         FxDescription another = (FxDescription) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
         // Compare concept
         if (!this.concept.equals(another.concept)) {
            return false;
         }

         // Compare initialCaseSignificant
         if (this.initialCaseSignificant != another.initialCaseSignificant) {
            return false;
         }

         // Compare langProperty
         if (!this.langProperty.equals(another.langProperty)) {
            return false;
         }

         // Compare textProperty
         if (!this.textProperty.equals(another.textProperty)) {
            return false;
         }

         // Compare typeUuid
         if (!this.typeUuid.equals(another.typeUuid)) {
            return false;
         }

         // Compare their parents
         return super.equals(obj);
      }

      return false;
   }

   /**
    * Returns a string representation of the object.
    */
   @Override
   public String toString() {
      StringBuilder buff = new StringBuilder();

      buff.append(this.getClass().getSimpleName()).append(": ");
      buff.append("'").append(this.textProperty).append("'");
      buff.append(" ics:");
      buff.append(this.initialCaseSignificant);
      buff.append(" lang:");
      buff.append("'").append(this.langProperty).append("'");
      buff.append(" type:");
      buff.append(informAboutUuid(this.typeUuid));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   public FxConcept getConcept() {
      return concept;
   }

   @Override
   public String getLang() {
      return langProperty.get();
   }

   public StringProperty getLangProperty() {
      return langProperty;
   }

   @Override
   public List<FxDescriptionRevision> getRevisionList() {
      return revisions;
   }

   @Override
   public String getText() {
      return textProperty.get();
   }

   public StringProperty getTextProperty() {
      return textProperty;
   }

   @Override
   public UUID getTypeUuid() {
      return typeUuid;
   }

   @Override
   public boolean isInitialCaseSignificant() {
      return initialCaseSignificant;
   }

   //~--- set methods ---------------------------------------------------------

   public void setInitialCaseSignificant(boolean initialCaseSignificant) {
      this.initialCaseSignificant = initialCaseSignificant;
   }

   public void setLang(String lang) {
      this.langProperty.set(lang);
   }

   public void setText(String text) {
      this.textProperty.set(text);
   }

   public void setTypeUuid(UUID typeUuid) {
      this.typeUuid = typeUuid;
   }
}

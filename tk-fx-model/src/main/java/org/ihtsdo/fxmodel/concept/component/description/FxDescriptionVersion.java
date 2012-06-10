package org.ihtsdo.fxmodel.concept.component.description;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.SimpleStringProperty;

import org.ihtsdo.fxmodel.concept.component.FxVersion;
import org.ihtsdo.tk.Ts;
import org.ihtsdo.tk.api.description.DescriptionVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.UUID;

public class FxDescriptionVersion extends FxVersion {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public boolean              initialCaseSignificant;
   public SimpleStringProperty langProperty = new SimpleStringProperty();
   public SimpleStringProperty textProperty = new SimpleStringProperty();
   public UUID                 typeUuid;

   //~--- constructors --------------------------------------------------------

   public FxDescriptionVersion() {
      super();
   }

   public FxDescriptionVersion(DescriptionVersionBI another) throws IOException {
      super(another);
      this.initialCaseSignificant = another.isInitialCaseSignificant();
      this.langProperty.set(another.getLang());
      this.textProperty.set(another.getText());
      this.typeUuid = Ts.get().getUuidPrimordialForNid(another.getTypeNid());
   }

   //~--- methods -------------------------------------------------------------

   /**
    * Compares this object to the specified object. The result is <tt>true</tt>
    * if and only if the argument is not <tt>null</tt>, is a
    * <tt>EDescriptionVersion</tt> object, and contains the same values, field by field,
    * as this <tt>EDescriptionVersion</tt>.
    *
    * @param obj the object to compare with.
    * @return <code>true</code> if the objects are the same;
    *         <code>false</code> otherwise.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }

      if (FxDescriptionVersion.class.isAssignableFrom(obj.getClass())) {
         FxDescriptionVersion another = (FxDescriptionVersion) obj;

         // =========================================================
         // Compare properties of 'this' class to the 'another' class
         // =========================================================
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
      buff.append(" ics:");
      buff.append(this.initialCaseSignificant);
      buff.append(" lang:");
      buff.append("'").append(this.langProperty).append("'");
      buff.append(" text:");
      buff.append("'").append(this.textProperty).append("'");
      buff.append(" type:");
      buff.append(informAboutUuid(this.typeUuid));
      buff.append(" ");
      buff.append(super.toString());

      return buff.toString();
   }

   //~--- get methods ---------------------------------------------------------

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_DescribeExternally#getLang()
    */
   public String getLang() {
      return langProperty.get();
   }

   public SimpleStringProperty getLangProperty() {
      return langProperty;
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_DescribeExternally#getText()
    */
   public String getText() {
      return textProperty.get();
   }

   public SimpleStringProperty getTextProperty() {
      return textProperty;
   }

   public UUID getTypeUuid() {
      return typeUuid;
   }

   /*
    * (non-Javadoc)
    *
    * @see org.ihtsdo.etypes.I_DescribeExternally#isInitialCaseSignificant()
    */
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

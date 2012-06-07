package org.ihtsdo.fxmodel.concept.component.media;

//~--- non-JDK imports --------------------------------------------------------

import javafx.collections.FXCollections;

import org.ihtsdo.fxmodel.concept.FxConcept;
import org.ihtsdo.fxmodel.concept.component.FxComponentChronicle;
import org.ihtsdo.tk.api.media.MediaChronicleBI;
import org.ihtsdo.tk.api.media.MediaVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.*;

public class FxMediaChronicle extends FxComponentChronicle<FxMediaVersion> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public byte[] dataBytes;
   public String format;

   //~--- constructors --------------------------------------------------------

   public FxMediaChronicle() {
      super();
   }

   public FxMediaChronicle(FxConcept concept, MediaChronicleBI another) throws IOException {
      super(concept, another.getPrimordialVersion());
      this.versions =
         FXCollections.observableArrayList(new ArrayList<FxMediaVersion>(another.getVersions().size()));

      for (MediaVersionBI v : another.getVersions()) {
         this.versions.add(new FxMediaVersion(v));
      }

      this.dataBytes = another.getPrimordialVersion().getMedia();
      this.format    = another.getPrimordialVersion().getFormat();
   }

   //~--- get methods ---------------------------------------------------------

   public byte[] getDataBytes() {
      return dataBytes;
   }

   public String getFormat() {
      return format;
   }
}

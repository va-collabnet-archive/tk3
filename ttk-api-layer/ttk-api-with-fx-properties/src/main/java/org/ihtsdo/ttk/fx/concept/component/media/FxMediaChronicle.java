package org.ihtsdo.ttk.fx.concept.component.media;

//~--- non-JDK imports --------------------------------------------------------


import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.concept.component.FxComponentChronicle;
import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.api.TerminologySnapshotDI;
import org.ihtsdo.ttk.api.media.MediaChronicleBI;
import org.ihtsdo.ttk.api.media.MediaVersionBI;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class FxMediaChronicle extends FxComponentChronicle<FxMediaVersion, MediaVersionBI> {
   public static final long serialVersionUID = 1;

   //~--- fields --------------------------------------------------------------

   public byte[] dataBytes;
   public String format;

   //~--- constructors --------------------------------------------------------

   public FxMediaChronicle() {
      super();
   }

   public FxMediaChronicle(TerminologySnapshotDI ss, FxConcept concept, MediaChronicleBI another)
           throws IOException, ContradictionException {
      super(ss, concept, another.getPrimordialVersion());

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

    @Override
    protected FxMediaVersion makeVersion(TerminologySnapshotDI ss, MediaVersionBI version) throws IOException, ContradictionException {
        return new FxMediaVersion(this, ss, version);
    }
}
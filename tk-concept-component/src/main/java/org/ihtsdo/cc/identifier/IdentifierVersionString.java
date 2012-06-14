package org.ihtsdo.cc.identifier;

//~--- non-JDK imports --------------------------------------------------------
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import java.io.IOException;


import org.ihtsdo.cc.component.ConceptComponent.IDENTIFIER_PART_TYPES;
import org.ihtsdo.tk.api.id.StringIdBI;
import org.ihtsdo.tk.dto.concept.component.identifier.TkIdentifierString;

public class IdentifierVersionString extends IdentifierVersion implements StringIdBI {

    private String stringDenotation;

    //~--- constructors --------------------------------------------------------
    public IdentifierVersionString() {
        super();
    }

    public IdentifierVersionString(TkIdentifierString idv) throws IOException {
        super(idv);
        stringDenotation = idv.getDenotation();
    }

    public IdentifierVersionString(TupleInput input) {
        super(input);
        stringDenotation = input.readString();
    }

    public IdentifierVersionString(IdentifierVersionString another, int statusNid, long time,int authorNid,
           int moduleNid, int pathNid) {
        super(statusNid, time, authorNid, moduleNid, pathNid, another.authorityNid);
        stringDenotation = (String) another.getDenotation();
    }

    public IdentifierVersionString(int statusNid, long time,int authorNid,
           int moduleNid, int pathNid, String denotation,
            int authorityNid) {
        super(statusNid, time, authorNid, moduleNid, pathNid, authorityNid);
        stringDenotation = denotation;
    }

    //~--- methods -------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (IdentifierVersionString.class.isAssignableFrom(obj.getClass())) {
            IdentifierVersionString another = (IdentifierVersionString) obj;

            return this.getStampNid() == another.getStampNid();
        }

        return false;
    }

    @Override
    public final boolean readyToWriteIdentifier() {
        assert stringDenotation != null : toString();

        return true;
    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append(this.getClass().getSimpleName()).append(": ");
        buf.append("denotation:" + "'").append(this.stringDenotation).append("'");
        buf.append(" ");
        buf.append(super.toString());

        return buf.toString();
    }

    @Override
    protected void writeSourceIdToBdb(TupleOutput output) {
        output.writeString(stringDenotation);
    }

    //~--- get methods ---------------------------------------------------------
    @Override
    public String getDenotation() {
        return stringDenotation;
    }

    @Override
    public IDENTIFIER_PART_TYPES getType() {
        return IDENTIFIER_PART_TYPES.STRING;
    }
    //~--- set methods ---------------------------------------------------------
}

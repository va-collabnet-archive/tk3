package org.ihtsdo.tk.api.constraint;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.ihtsdo.tk.spec.ConceptSpec;

public class RelConstraintIncoming extends RelConstraint {
    private static final long serialVersionUID = 1L;

    private static final int dataVersion = 1;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(dataVersion);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        int objDataVersion = in.readInt();
        if (objDataVersion == dataVersion) {
        } else {
            throw new IOException("Can't handle dataversion: " + objDataVersion);
        }
    }

	public RelConstraintIncoming(ConceptSpec originSpec,
			ConceptSpec relTypeSpec, ConceptSpec destinationSpec) {
		super(originSpec, relTypeSpec, destinationSpec);
	}
}

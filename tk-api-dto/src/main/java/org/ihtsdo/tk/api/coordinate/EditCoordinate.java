package org.ihtsdo.tk.api.coordinate;

import org.ihtsdo.tk.api.NidSet;
import org.ihtsdo.tk.api.NidSetBI;


public class EditCoordinate {
	private int authorNid;
	private NidSetBI editPaths;
	
	public EditCoordinate(int authorNid, NidSetBI editPaths) {
		super();
		assert editPaths != null;
		assert authorNid != Integer.MIN_VALUE;
		this.authorNid = authorNid;
		this.editPaths = editPaths;
	}
	
	public EditCoordinate(int authorNid, int... editPathNids) {
		super();
		assert editPathNids != null;
		assert authorNid != Integer.MIN_VALUE;
		this.authorNid = authorNid;
		this.editPaths = new NidSet(editPathNids);
	}

	public int getAuthorNid() {
		return authorNid;
	}

	public NidSetBI getEditPaths() {
		return editPaths;
	}
   
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("authorNid: ").append(authorNid);
      sb.append("editPaths: ").append(editPaths);           
      return sb.toString();
   }

}

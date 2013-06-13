package org.ihtsdo.ttk.services.action.drools;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.ihtsdo.ttk.services.action.ActionBI;
import org.ihtsdo.ttk.services.action.ActionContextBI;

public class DroolsActionContext {

	protected ActionContextBI actionContext;
	protected ObservableList<ActionBI> contextualActions = FXCollections.observableList(new ArrayList<ActionBI>());

	public DroolsActionContext(ActionContextBI actionContext) {
		super();
		this.actionContext = actionContext;
	}

	public ActionContextBI getActionContext() {
		return actionContext;
	}

}
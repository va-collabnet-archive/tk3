package org.ihtsdo.ttk.services.action;

import javafx.scene.Node;


public abstract class AbstractTtkAction implements ActionBI {
	private String label;
	private String description;
	private ExecutionCriterion executionCriterion = ExecutionCriterion.USER_SELECTION;
	private ThreadForAction threadForAction = ThreadForAction.BACKGROUND_THREAD;
	private ExecutionState executionState = ExecutionState.READY;
	
	private Node graphic16x16;
	private Node graphic24x24;
	private Node graphic32x32;
	private Node graphic128x128;
	private Node graphic512x512;
	
	public AbstractTtkAction(String label, String description) {
		super();
		this.label = label;
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExecutionCriterion getExecutionCriterion() {
		return executionCriterion;
	}

	public void setExecutionCriterion(ExecutionCriterion executionCriterion) {
		this.executionCriterion = executionCriterion;
	}

	public ThreadForAction getThreadForAction() {
		return threadForAction;
	}

	public void setThreadForAction(ThreadForAction threadForAction) {
		this.threadForAction = threadForAction;
	}

	public ExecutionState getExecutionState() {
		return executionState;
	}

	public void setExecutionState(ExecutionState executionState) {
		this.executionState = executionState;
	}

	public Node getGraphic16x16() {
		return graphic16x16;
	}

	public void setGraphic16x16(Node graphic16x16) {
		this.graphic16x16 = graphic16x16;
	}

	public Node getGraphic24x24() {
		return graphic24x24;
	}

	public void setGraphic24x24(Node graphic24x24) {
		this.graphic24x24 = graphic24x24;
	}

	public Node getGraphic32x32() {
		return graphic32x32;
	}

	public void setGraphic32x32(Node graphic32x32) {
		this.graphic32x32 = graphic32x32;
	}

	public Node getGraphic128x128() {
		return graphic128x128;
	}

	public void setGraphic128x128(Node graphic128x128) {
		this.graphic128x128 = graphic128x128;
	}

	public Node getGraphic512x512() {
		return graphic512x512;
	}

	public void setGraphic512x512(Node graphic512x512) {
		this.graphic512x512 = graphic512x512;
	}

}

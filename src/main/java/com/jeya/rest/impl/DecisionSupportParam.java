package com.jeya.rest.impl;

public enum DecisionSupportParam {
	/*
	 * These enum values are query params for decision support
	 */
	SCREENING_REQUEST("screeningRequest"), CHECK_ALL_DRUGS("checkAllDrugs"), MINIMUM_CONDITION_ALERT_SEVERITY(
			"minimumConditionAlertSeverity"), MINIMUM_INTERACTION_ALERT_SEVERITY("minimumInteractionAlertSeverity");

	private String value;

	private DecisionSupportParam(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

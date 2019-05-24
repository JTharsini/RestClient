package com.jeya.rest.api;

public class OMedDecisionSupportPatient {
	public ScreeningRequest screeningRequest;

	/**
	 * If this value is true, current and prospective drugs will be checked. If
	 * false, only prospective drug array will be checked.
	 */
	public boolean compareCurrentAndProspectiveDrugs;

	/**
	 * These values are configurable through client settings
	 */
	public String minimumConditionAlertSeverity;

	public String minimumInteractionAlertSeverity;
}

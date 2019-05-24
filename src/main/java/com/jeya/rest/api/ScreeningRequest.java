package com.jeya.rest.api;

public class ScreeningRequest {
	public short[] screeningModules;

	public PatientInformation patientInformation;

	public OMedCondition[] conditions;

	public OMedAllergenInfo[] allergens;

	public OMedWarningSearchCriteria[] currentDrugs;

	public OMedWarningSearchCriteria[] prospectiveDrugs;
}
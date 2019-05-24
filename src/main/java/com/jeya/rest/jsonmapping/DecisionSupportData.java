package com.jeya.rest.jsonmapping;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DecisionSupportData {
	@SerializedName("drugDoublings")
	public List<DrugDoubling> drugDoublings;

	@SerializedName("drugEquivalences")
	public List<DrugEquivalence> drugEquivalences;

	@SerializedName("drugInteractions")
	public List<DrugInteraction> drugInteractions;

	@SerializedName("drugSensitivities")
	public List<DrugSensitivity> drugSensitivities;

	@SerializedName("duplicateTherapies")
	public List<DuplicateTherapy> duplicateTherapies;

	@SerializedName("patientChecks")
	public List<PatientChecks> patientChecks;

	@SerializedName("screeningErrors")
	public List<ScreeningError> screeningErrors;
}
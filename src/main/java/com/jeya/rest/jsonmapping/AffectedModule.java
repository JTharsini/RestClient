package com.jeya.rest.jsonmapping;

import com.google.gson.annotations.SerializedName;

public class AffectedModule {
	@SerializedName("drugSensitivities")
	private boolean drugSensitivitiesAffected;

	@SerializedName("drugInteractions")
	private boolean drugInteractionsAffected;

	@SerializedName("patientCheck")
	private boolean patientCheckAffected;

	@SerializedName("doseRangeCheck")
	private boolean doseRangeCheckAffected;

	@SerializedName("drugEquivalence")
	private boolean drugEquivalenceAffected;

	@SerializedName("duplicateTherapy")
	private boolean duplicateTherapyAffected;

	@SerializedName("drugDoubling")
	private boolean drugDoublingAffected;

	@SerializedName("pharmacologicalEquivalence")
	private boolean pharmacologicalEquivalenceAffected;

	public boolean isDrugSensitivitiesAffected() {
		return drugSensitivitiesAffected;
	}

	public void setDrugSensitivitiesAffected(boolean drugSensitivitiesAffected) {
		this.drugSensitivitiesAffected = drugSensitivitiesAffected;
	}

	public boolean isDrugInteractionsAffected() {
		return drugInteractionsAffected;
	}

	public void setDrugInteractionsAffected(boolean drugInteractionsAffected) {
		this.drugInteractionsAffected = drugInteractionsAffected;
	}

	public boolean isPatientCheckAffected() {
		return patientCheckAffected;
	}

	public void setPatientCheckAffected(boolean patientCheckAffected) {
		this.patientCheckAffected = patientCheckAffected;
	}

	public boolean isDoseRangeCheckAffected() {
		return doseRangeCheckAffected;
	}

	public void setDoseRangeCheckAffected(boolean doseRangeCheckAffected) {
		this.doseRangeCheckAffected = doseRangeCheckAffected;
	}

	public boolean isDrugEquivalenceAffected() {
		return drugEquivalenceAffected;
	}

	public void setDrugEquivalenceAffected(boolean drugEquivalenceAffected) {
		this.drugEquivalenceAffected = drugEquivalenceAffected;
	}

	public boolean isDuplicateTherapyAffected() {
		return duplicateTherapyAffected;
	}

	public void setDuplicateTherapyAffected(boolean duplicateTherapyAffected) {
		this.duplicateTherapyAffected = duplicateTherapyAffected;
	}

	public boolean isDrugDoublingAffected() {
		return drugDoublingAffected;
	}

	public void setDrugDoublingAffected(boolean drugDoublingAffected) {
		this.drugDoublingAffected = drugDoublingAffected;
	}

	public boolean isPharmacologicalEquivalenceAffected() {
		return pharmacologicalEquivalenceAffected;
	}

	public void setPharmacologicalEquivalenceAffected(boolean pharmacologicalEquivalenceAffected) {
		this.pharmacologicalEquivalenceAffected = pharmacologicalEquivalenceAffected;
	}
}
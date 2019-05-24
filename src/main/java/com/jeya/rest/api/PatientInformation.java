package com.jeya.rest.api;

import com.google.gson.annotations.SerializedName;

public class PatientInformation {
	@SerializedName("age")
	private int patientAgeInDays;

	private String gender;

	private boolean conditionListComplete;

	public PatientInformation() {

	}

	public PatientInformation(int patientAgeInDays, String gender, boolean conditionListComplete) {
		this.patientAgeInDays = patientAgeInDays;
		this.gender = gender;
		this.conditionListComplete = conditionListComplete;
	}

	public int getPatientAgeInDays() {
		return patientAgeInDays;
	}

	public void setPatientAgeInDays(int patientAgeInDays) {
		this.patientAgeInDays = patientAgeInDays;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isConditionListComplete() {
		return conditionListComplete;
	}

	public void setConditionListComplete(boolean conditionListComplete) {
		this.conditionListComplete = conditionListComplete;
	}
}
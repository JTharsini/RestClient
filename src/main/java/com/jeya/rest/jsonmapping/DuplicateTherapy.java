package com.jeya.rest.jsonmapping;

public class DuplicateTherapy {
	public String primaryDrugId;

	public String alertMessage;

	public String secondaryMessage;

	public String duplicateType;

	public String duplicateDrugId;

	public DuplicateTherapy() {
	}

	public DuplicateTherapy(String primaryDrugId, String duplicateDrugId) {
		this.primaryDrugId = primaryDrugId;
		this.duplicateDrugId = duplicateDrugId;
	}
}

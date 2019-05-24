package com.jeya.rest.jsonmapping;

import com.google.gson.annotations.SerializedName;

public class DrugDoubling {
	@SerializedName("primaryDrug.singleId")
	public String primaryDrugId;

	public String alertMessage;

	public String secondaryMessage;

	public String duplicateType;

	public String duplicateDrugId;
}
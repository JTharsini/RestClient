package com.jeya.rest.api;

import com.google.gson.annotations.SerializedName;

public class OMedWarningSearchCriteria {
	@SerializedName("name")
	public String drugName;

	@SerializedName("terminology")
	public String terminology;

	@SerializedName("conceptType")
	public String conceptType;

	@SerializedName("id")
	public String drugId;

	public OMedWarningSearchCriteria() {

	}

	public OMedWarningSearchCriteria(String drugId, String drugName, String terminology, String conceptType) {
		this.drugId = drugId;
		this.drugName = drugName;
		this.terminology = terminology;
		this.conceptType = conceptType;
	}
}

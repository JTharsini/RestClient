package com.jeya.rest.api;

import com.google.gson.annotations.SerializedName;

public class OMedAllergenInfo {
	@SerializedName("name")
	public String name;

	@SerializedName("terminology")
	public String terminology;

	@SerializedName("conceptType")
	public String concept;

	@SerializedName("id")
	public String allergenId;

	public OMedAllergenInfo() {
	}

	public OMedAllergenInfo(String allergenId, String name, String concept, String terminology) {
		super();
		this.allergenId = allergenId;
		this.name = name;
		this.concept = concept;
		this.terminology = terminology;
	}
}

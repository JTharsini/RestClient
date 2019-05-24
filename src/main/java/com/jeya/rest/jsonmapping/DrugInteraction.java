package com.jeya.rest.jsonmapping;

public class DrugInteraction {
	public String drugId;

	public String secondaryDrugId;

	public String drugName;

	public String classification;

	public String description;

	public DrugInteraction() {
	}

	public DrugInteraction(String drugId, String secondaryDrugId, String drugName, String classification,
			String description) {
		this.drugId = drugId;
		this.secondaryDrugId = secondaryDrugId;
		this.drugName = drugName;
		this.classification = classification;
		this.description = description;
	}
}
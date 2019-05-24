package com.jeya.rest.api;

public class DrugSearchResult {
	public String sourceId;

	public String drugName;

	public DrugSearchResult() {
	}

	public DrugSearchResult(String drugName, String sourceId) {
		super();
		this.sourceId = sourceId;
		this.drugName = drugName;
	}
}

package com.jeya.rest.jsonmapping;

import com.google.gson.annotations.SerializedName;

public class DescriptionType {
	@SerializedName("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
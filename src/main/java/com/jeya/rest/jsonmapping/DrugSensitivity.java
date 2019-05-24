package com.jeya.rest.jsonmapping;

import com.google.gson.annotations.SerializedName;
import com.jeya.rest.api.OMedAllergenInfo;

public class DrugSensitivity {
	@SerializedName("fullAlertMessage")
	public String fullAlertMessage;

	@SerializedName("drugIngredientDescription")
	public String drugIngredientDescription;

	// @SerializedName("matchType.name")
	public String sensitivityType;

	public OMedAllergenInfo allergenData;
}
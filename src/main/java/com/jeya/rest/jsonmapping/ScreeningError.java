package com.jeya.rest.jsonmapping;

import com.google.gson.annotations.SerializedName;

/**
 * @author JJeyatharsini Json mapping class to hold screening errors
 */
public class ScreeningError {
	@SerializedName("errorType")
	private ErrorType errorType;

	@SerializedName("errorSeverity")
	private ErrorSeverity errorSeverity;

	@SerializedName("description")
	private String description;

	@SerializedName("descriptionType")
	private DescriptionType descriptionType;

	@SerializedName("affectedModules")
	private AffectedModule affectedModules;

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public ErrorSeverity getErrorSeverity() {
		return errorSeverity;
	}

	public void setErrorSeverity(ErrorSeverity errorSeverity) {
		this.errorSeverity = errorSeverity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DescriptionType getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(DescriptionType descriptionType) {
		this.descriptionType = descriptionType;
	}

	public AffectedModule getAffectedModules() {
		return affectedModules;
	}

	public void setAffectedModules(AffectedModule affectedModules) {
		this.affectedModules = affectedModules;
	}
}
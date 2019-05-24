package com.jeya.rest.api;

/**
 * @author JJeyatharsini It exposes constants for omed decision support
 */
public interface OMedDecisionSupportConstants {
	int SCREENING_MODULE_ALL = 0;

	int SCREENING_MODULE_DRUG_SENSITIVITY = 1;

	int SCREENING_MODULE_DRUG_INTERACTION = 2;

	int SCREENING_MODULE_PATIENT_CHECK = 4;

	int SCREENING_MODULE_DRUG_EQUIVALENCE = 16;

	int SCREENING_MODULE_DUPLICATE_THERAPY = 32;

	int SCREENING_MODULE_DRUG_DOUBLING = 64;

	int SCREENING_MODULE_PHARMACOLOGICAL_EQUIVALENCE = 128;

	String CONTRA_INDICATION = "Contraindication";

	String PRECAUTION = "Precaution";

	String HIGH_RISK = "HighRisk";

	String SIGNIFICANT_RISK = "SignificantRisk";

	String MODERATE_RISK = "ModerateRisk";

	String LOW_RISK = "LowRisk";

	String SNOMED_CODE_FOR_PREGNANCY = "77386006";

	String SNOMED_CODE_FOR_BREAST_FEEDING = "225604004";
}
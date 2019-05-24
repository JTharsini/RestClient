package com.jeya.rest.dataproviders;

import java.util.ArrayList;
import java.util.List;

import com.jeya.rest.api.DrugData;
import com.jeya.rest.api.DrugSearchResult;
import com.jeya.rest.api.OMedAllergenInfo;
import com.jeya.rest.api.OMedCondition;
import com.jeya.rest.api.OMedDecisionSupportConstants;
import com.jeya.rest.api.OMedDecisionSupportPatient;
import com.jeya.rest.api.OMedWarningSearchCriteria;
import com.jeya.rest.api.PatientInformation;
import com.jeya.rest.api.ScreeningRequest;

public final class FDBDrugDataProvider {
	public static OMedDecisionSupportPatient getDecisionSupportPatient(DrugSearchResult[] searchResults) {
		OMedDecisionSupportPatient oMedDecisionSupportPatient = new OMedDecisionSupportPatient();
		oMedDecisionSupportPatient.screeningRequest = getScreeningRequest(searchResults);
		oMedDecisionSupportPatient.compareCurrentAndProspectiveDrugs = false;
		oMedDecisionSupportPatient.minimumConditionAlertSeverity = OMedDecisionSupportConstants.PRECAUTION;// this is
																											// the
																											// minimum
																											// value
		oMedDecisionSupportPatient.minimumInteractionAlertSeverity = OMedDecisionSupportConstants.LOW_RISK;

		return oMedDecisionSupportPatient;
	}

	private static ScreeningRequest getScreeningRequest(DrugSearchResult[] searchResults) {
		ScreeningRequest screeningRequest = new ScreeningRequest();
		screeningRequest.screeningModules = new short[] { OMedDecisionSupportConstants.SCREENING_MODULE_ALL };
		screeningRequest.patientInformation = getPatientInformation();
		screeningRequest.allergens = getAllergenInformation();
		screeningRequest.conditions = getConditions();
		screeningRequest.currentDrugs = getCurrentDrugs();
		screeningRequest.prospectiveDrugs = getWarningSearchCriterias(searchResults);
		return screeningRequest;
	}

	private static PatientInformation getPatientInformation() {
		return new PatientInformation(9849, "Female", false);
	}

	private static OMedCondition[] getConditions() {
		List<OMedCondition> conditions = new ArrayList<>();
		OMedCondition omedPregnancyCondition = new OMedCondition("Preg*", "SNOMEDCT",
				OMedDecisionSupportConstants.SNOMED_CODE_FOR_PREGNANCY);
		OMedCondition omedBreastFeedingCondition = new OMedCondition("Breast*", "SNOMEDCT",
				OMedDecisionSupportConstants.SNOMED_CODE_FOR_BREAST_FEEDING);
		conditions.add(omedBreastFeedingCondition);
		conditions.add(omedPregnancyCondition);
		return conditions.toArray(new OMedCondition[0]);
	}

	private static OMedAllergenInfo[] getAllergenInformation() {
		return new OMedAllergenInfo[] { new OMedAllergenInfo("68887009", "Methotrexate", "Substance", "SNOMEDCT") };
	}

	private static OMedWarningSearchCriteria[] getCurrentDrugs() {
		List<DrugData> allDrugDataList = new ArrayList<>();
		allDrugDataList
				.add(new DrugData("diclofenac sodium - Rectal", "900101028"/* "methotrexate - Oral", "900082007" */));
		return getWarningSearchCriterias(allDrugDataList);
	}

	private static OMedWarningSearchCriteria[] getWarningSearchCriterias(List<DrugData> allDrugDataList) {
		OMedWarningSearchCriteria[] oMedWarningSearchCriterias = new OMedWarningSearchCriteria[allDrugDataList.size()];
		for (int i = 0; i < allDrugDataList.size(); i++) {
			oMedWarningSearchCriterias[i] = getWarningSearchCriteria(allDrugDataList.get(i));
		}
		return oMedWarningSearchCriterias;
	}

	private static OMedWarningSearchCriteria getWarningSearchCriteria(DrugData drugData) {
		return new OMedWarningSearchCriteria(drugData.pluginDistributedDrugId, drugData.name, "MDDF", "OrderableMed");
	}

	private static OMedWarningSearchCriteria[] getWarningSearchCriterias(DrugSearchResult[] searchResults) {
		OMedWarningSearchCriteria[] oMedWarningSearchCriterias = new OMedWarningSearchCriteria[searchResults.length];
		for (int i = 0; i < searchResults.length; i++) {
			oMedWarningSearchCriterias[i] = getWarningSearchCriteria(searchResults[i]);
		}
		return oMedWarningSearchCriterias;
	}

	private static OMedWarningSearchCriteria getWarningSearchCriteria(DrugSearchResult drugSearchResult) {
		return new OMedWarningSearchCriteria(drugSearchResult.sourceId, drugSearchResult.drugName, "MDDF",
				"OrderableMed");
	}
}
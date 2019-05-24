package com.jeya.rest.impl;

import com.jeya.rest.api.DrugSearchResult;
import com.jeya.rest.dataproviders.FDBDrugDataProvider;

public final class FDBDrugDataGETProvider {
	public static void getDecisionSupportInformationByGet(DrugSearchResult[] searchResults) {
		DecisionSupportURLGETBuilder.getInstance()
				.getDecisionSupportInfo(FDBDrugDataProvider.getDecisionSupportPatient(searchResults));
	}
}
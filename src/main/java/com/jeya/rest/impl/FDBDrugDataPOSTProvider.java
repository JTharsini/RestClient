package com.jeya.rest.impl;

import com.jeya.rest.api.DrugSearchResult;
import com.jeya.rest.dataproviders.FDBDrugDataProvider;

public final class FDBDrugDataPOSTProvider {
	public static void getDecisionSupportInformation(DrugSearchResult[] searchResults) {
		DecisionSupportURLPOSTBuilder.getInstance()
				.getDecisionSupportInfo(FDBDrugDataProvider.getDecisionSupportPatient(searchResults));
	}
}
package com.jeya.rest;

import com.jeya.rest.api.DrugSearchResult;
import com.jeya.rest.impl.FDBDrugDataGETProvider;
import com.jeya.rest.impl.FDBDrugDataPOSTProvider;

public class RestClient {
	public static void main(String[] args) {
		DrugSearchResult[] searchResults = new DrugSearchResult[] {
				/*new DrugSearchResult("diclofenac sodium - gastro-resistant tablet - Oral", "900086746"),
				new DrugSearchResult("diclofenac sodium - Intramuscular", "900080129"),

				new DrugSearchResult("diclofenac sodium - modified release capsule - Oral", "900086747"),
				new DrugSearchResult("diclofenac sodium - modified release tablet - Oral", "900086748"),
				new DrugSearchResult("diclofenac sodium - oral liquid", "900116697"),
				new DrugSearchResult("methotrexate - Oral", "900082007")
				/*, new DrugSearchResult("diclofenac sodium - Subcutaneous", "900117703"),*/
				new DrugSearchResult("diclofenac sodium - Rectal", "900101028")};
		//FDBDrugDataGETProvider.getDecisionSupportInformationByGet(searchResults);
		FDBDrugDataPOSTProvider.getDecisionSupportInformation(searchResults);
	}
}
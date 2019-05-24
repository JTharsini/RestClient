package com.jeya.rest.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.EnumMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jeya.rest.api.OMedDecisionSupportPatient;
import com.jeya.rest.api.ScreeningRequest;
import com.jeya.rest.jsonmapping.DecisionSupportData;

public class DecisionSupportURLGETBuilder {
	private static final String AND_SIGN = "&";

	private static final String EQUAL_SIGN = "=";

	private static final String QUERY_PARAM_START_SIGN = "?";
	private static final String SLASH_SIGN = "/";

	public static final DecisionSupportURLGETBuilder getInstance() {
		return DecisionSupportURLBuilderCreator.INSTANCE;
	}

	private <T> T deserializeServiceResponse(InputStream inputStream, Class<T> t) {
		if (inputStream == null) {
			return null;
		}
		T result = null;
		Reader reader = new InputStreamReader(inputStream);
		Gson gson = new GsonBuilder().create();
		result = gson.fromJson(reader, t);
		return result;
	}

	public static URL getDecisionSupportURL(OMedDecisionSupportPatient decisionSupportPatient)
			throws MalformedURLException, UnsupportedEncodingException {
		String queryParam = DecisionSupportURLGETBuilder.getInstance()
				.getDecisionSupportQueryParam(decisionSupportPatient);
		String url = new StringBuilder(getBaseUrl()).append("Screening").append(SLASH_SIGN).append("reports")
				.append(QUERY_PARAM_START_SIGN).append(queryParam).toString();
		System.out.println(url);
		return new URL(url);
	}

	public String getDecisionSupportQueryParam(OMedDecisionSupportPatient decisionSupportPatient)
			throws UnsupportedEncodingException {
		Map<DecisionSupportParam, String> paramMap = getParamMap(decisionSupportPatient);
		StringBuilder paramBuilder = new StringBuilder();
		if (!paramMap.isEmpty()) {
			appendScreeningRequest(paramBuilder, paramMap);
			appendBooleanValue(paramBuilder, paramMap, DecisionSupportParam.CHECK_ALL_DRUGS);
			appendBooleanValue(paramBuilder, paramMap, DecisionSupportParam.MINIMUM_CONDITION_ALERT_SEVERITY);
			appendBooleanValue(paramBuilder, paramMap, DecisionSupportParam.MINIMUM_INTERACTION_ALERT_SEVERITY);
		}
		return paramBuilder.toString();
	}

	private static String getBaseUrl() {
		return "http://localhost/FDBApp_R/api/";
	}

	private void appendScreeningRequest(StringBuilder paramBuilder, Map<DecisionSupportParam, String> paramMap) {
		if (paramMap.containsKey(DecisionSupportParam.SCREENING_REQUEST)) {
			paramBuilder.append(DecisionSupportParam.SCREENING_REQUEST.getValue()).append(EQUAL_SIGN)
					.append(paramMap.get(DecisionSupportParam.SCREENING_REQUEST));
		}
	}

	private void appendBooleanValue(StringBuilder paramBuilder, Map<DecisionSupportParam, String> paramMap,
			DecisionSupportParam param) {
		if (paramMap.containsKey(param)) {
			if (paramBuilder.length() > 0) {
				paramBuilder.append(AND_SIGN);
			}
			paramBuilder.append(param.getValue()).append(EQUAL_SIGN).append(paramMap.get(param));
		}
	}

	private Map<DecisionSupportParam, String> getParamMap(OMedDecisionSupportPatient decisionSupportPatient)
			throws UnsupportedEncodingException {
		Map<DecisionSupportParam, String> map = new EnumMap<>(DecisionSupportParam.class);
		addScreeningRequestParamToMap(map, getScreeningRequest(decisionSupportPatient.screeningRequest));
		map.put(DecisionSupportParam.CHECK_ALL_DRUGS,
				String.valueOf(decisionSupportPatient.compareCurrentAndProspectiveDrugs));
		map.put(DecisionSupportParam.MINIMUM_CONDITION_ALERT_SEVERITY,
				decisionSupportPatient.minimumConditionAlertSeverity);
		map.put(DecisionSupportParam.MINIMUM_INTERACTION_ALERT_SEVERITY,
				decisionSupportPatient.minimumInteractionAlertSeverity);
		return map;
	}

	private DecisionSupportURLGETBuilder() {
	}

	private static class DecisionSupportURLBuilderCreator {
		private static final DecisionSupportURLGETBuilder INSTANCE = new DecisionSupportURLGETBuilder();
	}

	private String getScreeningRequest(ScreeningRequest screeningRequest) throws UnsupportedEncodingException {
		Gson gson = new Gson();
		return URLEncoder.encode(gson.toJson(screeningRequest), "UTF-8");
	}

	private void addScreeningRequestParamToMap(Map<DecisionSupportParam, String> map, String screeningRequestParam) {
		if (screeningRequestParam != null) {
			map.put(DecisionSupportParam.SCREENING_REQUEST, screeningRequestParam);
		}
	}

	private InputStream getResponseStreamFrom(URL url) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.connect();

			int statusCode = conn.getResponseCode();
			if (statusCode != 200) {
				System.out.println("Got error: " + statusCode);
			}
			return conn.getInputStream();
		} catch (IOException e) {
			System.out.println("Got error: " + e);
		}
		return null;
	}

	public void getDecisionSupportInfo(OMedDecisionSupportPatient decisionSupportPatient) {
		try {
			URL url = getDecisionSupportURL(decisionSupportPatient);
			DecisionSupportData de = deserializeServiceResponse(getResponseStreamFrom(url), DecisionSupportData.class);
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
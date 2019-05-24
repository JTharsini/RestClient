package com.jeya.rest.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jeya.rest.api.OMedDecisionSupportPatient;
import com.jeya.rest.api.ScreeningRequest;
import com.jeya.rest.jsonmapping.DecisionSupportData;

public class DecisionSupportURLPOSTBuilder {
	private static final String AND_SIGN = "&";

	private static final String EQUAL_SIGN = "=";

	private static final String QUERY_PARAM_START_SIGN = "?";
	private static final String SLASH_SIGN = "/";

	public static final DecisionSupportURLPOSTBuilder getInstance() {
		return DecisionSupportURLBuilderCreator.INSTANCE;
	}

	public void getDecisionSupportInfo(OMedDecisionSupportPatient decisionSupportPatient) {
		try {
			URL url = getDecisionSupportURL(decisionSupportPatient);
			String screeningRequest = getScreeningRequest(decisionSupportPatient.screeningRequest);
			System.out.println(screeningRequest);
			DecisionSupportData de = deserializeServiceResponse(getResponseStream(url, screeningRequest),
					DecisionSupportData.class);
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
		String queryParam = DecisionSupportURLPOSTBuilder.getInstance()
				.getDecisionSupportQueryParam(decisionSupportPatient);
		String url = new StringBuilder(getBaseUrl()).append("Screening").append(SLASH_SIGN).append("reports")
				.append(QUERY_PARAM_START_SIGN).append(queryParam).toString();
		System.out.println(url);
		return new URL(url);
	}

	private static String getBaseUrl() {
		return "http://localhost/FDBApp_R/api/";
	}

	public String getDecisionSupportQueryParam(OMedDecisionSupportPatient decisionSupportPatient)
			throws UnsupportedEncodingException {
		Map<DecisionSupportParam, String> paramMap = getParamMap(decisionSupportPatient);
		StringBuilder paramBuilder = new StringBuilder();
		if (!paramMap.isEmpty()) {
			appendBooleanValue(paramBuilder, paramMap, DecisionSupportParam.CHECK_ALL_DRUGS);
			appendBooleanValue(paramBuilder, paramMap, DecisionSupportParam.MINIMUM_CONDITION_ALERT_SEVERITY);
			appendBooleanValue(paramBuilder, paramMap, DecisionSupportParam.MINIMUM_INTERACTION_ALERT_SEVERITY);
		}
		return paramBuilder.toString();
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

	private Map<DecisionSupportParam, String> getParamMap(OMedDecisionSupportPatient decisionSupportPatient) {
		Map<DecisionSupportParam, String> map = new EnumMap<>(DecisionSupportParam.class);
		map.put(DecisionSupportParam.CHECK_ALL_DRUGS,
				String.valueOf(decisionSupportPatient.compareCurrentAndProspectiveDrugs));
		map.put(DecisionSupportParam.MINIMUM_CONDITION_ALERT_SEVERITY,
				decisionSupportPatient.minimumConditionAlertSeverity);
		map.put(DecisionSupportParam.MINIMUM_INTERACTION_ALERT_SEVERITY,
				decisionSupportPatient.minimumInteractionAlertSeverity);
		return map;
	}

	private DecisionSupportURLPOSTBuilder() {
	}

	private static class DecisionSupportURLBuilderCreator {
		private static final DecisionSupportURLPOSTBuilder INSTANCE = new DecisionSupportURLPOSTBuilder();
	}

	private String getScreeningRequest(ScreeningRequest screeningRequest) {
		Gson gson = new Gson();
		return "{\"screeningRequest\": " + gson.toJson(screeningRequest) + "}";
	}

	private InputStream getResponseStream(URL url, String screeningRequest) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("charset", "UTF-8");
			conn.setRequestProperty("Content-Length", Integer.toString(screeningRequest.length()));
			conn.getOutputStream().write(screeningRequest.getBytes("UTF-8"));
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
}
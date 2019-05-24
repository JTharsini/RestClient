package com.jeya.rest.api;

public class DrugData implements java.io.Serializable {
	public java.lang.String name;

	public String pluginDistributedDrugId;

	public DrugData() {
	}

	public DrugData(String name, String pluginDistributedDrugId) {
		this.name = name;
		this.pluginDistributedDrugId = pluginDistributedDrugId;
	}
}

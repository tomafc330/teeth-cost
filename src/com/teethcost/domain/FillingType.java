package com.teethcost.domain;

public enum FillingType {

	AMALGAM("silver"),
	RESIN("resin");
	
	private String name;

	FillingType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

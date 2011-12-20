package com.teethcost.domain;

import java.io.Serializable;


public class WizardFields implements Serializable {

	private int teethNumber;
	
	private FillingType fillingType;

	private String surface;
	
	public WizardFields() {
	}

	public int getTeethNumber() {
		return teethNumber;
	}

	public void setTeethNumber(int teethNumber) {
		this.teethNumber = teethNumber;
	}

	public FillingType getFillingType() {
		return fillingType;
	}

	public void setFillingType(FillingType fillingType) {
		this.fillingType = fillingType;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}
	
	
}

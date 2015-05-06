package com.callision.ui;

public enum LocationEnum {
	GA("Atlanta, GA"),
	IL("Chicago, IL"),
	AK("Barrow, AK"),
	FL("Orlando, FL"),
	TX("Houston, TX");

	private String type;

	private LocationEnum(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}

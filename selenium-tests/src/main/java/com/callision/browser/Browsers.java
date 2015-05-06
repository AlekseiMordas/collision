package com.callision.browser;

public enum Browsers {
	FF("FF");

	private String type;

	private Browsers(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

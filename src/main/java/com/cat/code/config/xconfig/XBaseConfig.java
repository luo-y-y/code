package com.cat.code.config.xconfig;

public class XBaseConfig {

	public static final String PTY_NAME = "name";

	public static final String PTY_LABEL = "label";

	public static final String PTY_VALUE = "value";

	private String name;

	private String label;

	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

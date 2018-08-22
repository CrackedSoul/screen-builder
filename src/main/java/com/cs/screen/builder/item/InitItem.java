package com.cs.screen.builder.item;

public class InitItem {
	private String name;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public InitItem(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public InitItem() {
		super();
	}
}

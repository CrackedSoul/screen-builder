package com.cs.screen.builder.item;

public class SelectOption {
	private  String  label;
    private  String  value;
    
	public SelectOption() {
		super();
	}
	public SelectOption(String label, String value) {
		super();
		this.label = label;
		this.value = value;
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

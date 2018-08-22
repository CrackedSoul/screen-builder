package com.cs.screen.builder.item;

public class Button {
	private String button;
	private Boolean enable;
	private String click;
	
	public Button(String button, Boolean enable, String click) {
		super();
		this.button = button;
		this.enable = enable;
		this.click = click;
	}
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
}

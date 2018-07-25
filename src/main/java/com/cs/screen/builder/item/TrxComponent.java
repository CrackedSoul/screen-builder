package com.cs.screen.builder.item;

public class TrxComponent implements Component{
	 private FormItem content;
	 private String name;
	 private String component;
	 private String eventType;

	public FormItem getContent() {
		return content;
	}
	public void setContent(FormItem content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}

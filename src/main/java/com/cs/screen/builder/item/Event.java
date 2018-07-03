package com.cs.screen.builder.item;

public class Event {
	private String eventType;
    private String funcName;
    private String methodBody;
    
	public Event() {
		super();
	}
	public Event(String eventType, String funcName, String methodBody) {
		super();
		this.eventType = eventType;
		this.funcName = funcName;
		this.methodBody = methodBody;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getFuncName() {
		return funcName;
	}
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	public String getMethodBody() {
		return methodBody;
	}
	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}
    
}

package com.cs.screen.builder.item;

import java.util.List;

public abstract class FieldItem implements Item {
	private String type;
    private String desc;
    private String name;
    private List<Event> events;
    private List<String> checks;
    private boolean required;
    private String showIf;
    
	public FieldItem() {
		super();
		updaterequired();
	}
	public FieldItem(String type, String desc, String name, List<Event> events, List<String> checks) {
		super();
		this.type = type;
		this.desc = desc;
		this.name = name;
		this.events = events;
		this.checks = checks;
		updaterequired();
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<String> getChecks() {
		return checks;
	}
	public void setChecks(List<String> checks) {
		this.checks = checks;
		updaterequired();
	}
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String getShowIf() {
		return showIf;
	}
	public void setShowIf(String showIf) {
		this.showIf = showIf;
	}
	public void updaterequired() {
		if (this.checks==null) {
			this.required=false;
			return;
		}
		for(String check:checks) {
			if ("required".equals(check)) {
				this.required=true;
				return;
			}
		}
	}
}

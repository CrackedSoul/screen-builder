package com.cs.screen.builder.item;

import java.util.List;

public abstract class FieldItem implements Item {
	private String type;
    private String desc;
    private String name;
    private List<Event> events;
    private List<String> ckecks;
    private boolean required;
    
	public FieldItem() {
		super();
		updaterequired();
	}
	public FieldItem(String type, String desc, String name, List<Event> events, List<String> ckecks) {
		super();
		this.type = type;
		this.desc = desc;
		this.name = name;
		this.events = events;
		this.ckecks = ckecks;
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
	public List<String> getCkecks() {
		return ckecks;
	}
	public void setCkecks(List<String> ckecks) {
		this.ckecks = ckecks;
		updaterequired();
	}
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	private void updaterequired() {
		if (this.ckecks==null) {
			this.required=false;
			return;
		}
		for(String check:ckecks) {
			if ("required".equals(check)) {
				this.required=true;
				return;
			}
		}
	}
}

package com.cs.screen.builder.item;

import java.util.List;

public class GroupItem implements Item {
	private List<Item> items;
    private String desc;
    private String id;
    private String showIf;
    
	public GroupItem() {
		super();
	}
	public GroupItem(List<Item> items, String desc, String id) {
		super();
		this.items = items;
		this.desc = desc;
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShowIf() {
		return showIf;
	}
	public void setShowIf(String showIf) {
		this.showIf = showIf;
	}
    
}

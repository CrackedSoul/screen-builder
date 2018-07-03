package com.cs.screen.builder.item;

import java.util.List;

public class TrxComponment {
	 private String group;
	 private String name;
	 private FormItem form;
	 private List<String> breadCrumbs;
	 
	public TrxComponment() {
		super();
	}
	
	public TrxComponment(String group, String name, FormItem form) {
		super();
		this.group = group;
		this.name = name;
		this.form = form;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FormItem getForm() {
		return form;
	}
	public void setForm(FormItem form) {
		this.form = form;
	}
	public List<String> getBreadCrumb() {
		return breadCrumbs;
	}
	public void setBreadCrumb(List<String> breadCrumbs) {
		this.breadCrumbs = breadCrumbs;
	}
}

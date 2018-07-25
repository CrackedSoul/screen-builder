package com.cs.screen.builder.item;

import java.util.LinkedList;
import java.util.List;

public class FormItem implements Item {
	private List<Item> form;
	private List<String> breadCrumbs;

	public FormItem() {
		super();
		this.form=new LinkedList<Item>();
	}

	public FormItem(List<Item> items) {
		super();
		this.form = items;
	}

	public List<Item> getForm() {
		return form;
	}

	public void setForm(List<Item> form) {
		this.form = form;
	}

	public List<String> getBreadCrumbs() {
		return breadCrumbs;
	}

	public void setBreadCrumbs(List<String> breadCrumbs) {
		this.breadCrumbs = breadCrumbs;
	}
}

package com.cs.screen.builder.item;

import java.util.LinkedList;
import java.util.List;

public class FormItem implements Item {
	private List<Item> items;

	public FormItem() {
		super();
		this.items=new LinkedList<Item>();
	}

	public FormItem(List<Item> items) {
		super();
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}

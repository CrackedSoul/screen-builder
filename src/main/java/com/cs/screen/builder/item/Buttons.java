package com.cs.screen.builder.item;

import java.util.LinkedList;
import java.util.List;

public class Buttons implements Item{
	private List<Button> buttons;

	public Buttons() {
		super();
		this.buttons = new LinkedList<Button>();
	}

	public List<Button> getLinks() {
		return buttons;
	}
	
	
	public void setLinks(List<Button> buttons) {
		this.buttons = buttons;
	}

	public void add(Button buttons) {
		this.buttons.add(buttons);
	}
	public void add(String button,Boolean enable,String click) {
		this.buttons.add(new Button(button,enable,click));
	}
}

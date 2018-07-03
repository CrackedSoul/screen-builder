package com.cs.screen.builder.item;

import java.util.List;

import com.cs.screen.builder.consts.Consts;

public class InputFieldItem extends FieldItem {
	
	private String defVal;
	
	public InputFieldItem() {
		super();
		this.setType(Consts.Type_TextInput);
	}
	public InputFieldItem(String desc, String name) {
		this( desc, name, null);
	}

	public InputFieldItem(String desc, String name, List<String> ckecks) {
		this( desc, name, null, ckecks);
	}
	public InputFieldItem(String desc, String name,  List<String> ckecks,String defVal) {
		this(desc, name, null, ckecks,defVal);
	}
	public InputFieldItem(String desc, String name, List<Event> events, List<String> ckecks) {
		this(desc, name, null, ckecks,null);
	}
	public InputFieldItem(String desc, String name, List<Event> events, List<String> ckecks,String defVal) {
		super(Consts.Type_TextInput,desc,name,events,ckecks);
		this.defVal = defVal;
	}

	public String getDefVal() {
		return defVal;
	}

	public void setDefVal(String defVal) {
		this.defVal = defVal;
	}
	
}

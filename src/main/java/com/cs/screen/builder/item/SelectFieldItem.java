package com.cs.screen.builder.item;

import java.util.List;

import com.cs.screen.builder.consts.Consts;

public class SelectFieldItem extends FieldItem{
	 private List<SelectOption> options;
	 private List<SelectOption> defVal;
	 private String optionsName; 

	public SelectFieldItem() {
		super();
		this.setType(Consts.Type_Select);
	}
	public SelectFieldItem( String desc, String name, List<String> ckecks, String optionsName) {
		this( desc, name, null, ckecks,null,null,optionsName);
	}
	
	public SelectFieldItem( String desc, String name, List<String> ckecks,
			 String optionsName,List<SelectOption> defVal) {
		this( desc, name, null, ckecks,null,defVal,optionsName);
	}

	public SelectFieldItem( String desc, String name,  List<String> ckecks,
			List<SelectOption> options,  String optionsName) {
		this( desc, name, null, ckecks,options,null,optionsName);
	}
	
	
	public SelectFieldItem( String desc, String name, List<Event> events, List<String> ckecks,
			 String optionsName,List<SelectOption> defVal) {
		this( desc, name, events, ckecks,null,defVal,optionsName);
	}

	public SelectFieldItem( String desc, String name, List<Event> events,List<String> ckecks,
			List<SelectOption> options,  String optionsName) {
		this( desc, name, events, ckecks,options,null,optionsName);
	}

	public SelectFieldItem( String desc, String name, List<Event> events, List<String> ckecks,
			List<SelectOption> options, List<SelectOption> defVal, String optionsName) {
		super(Consts.Type_Select, desc, name, events, ckecks);
		this.options = options;
		this.defVal = defVal;
		this.optionsName = optionsName;
	}

	public List<SelectOption> getOptions() {
		return options;
	}

	public void setOptions(List<SelectOption> options) {
		this.options = options;
	}

	public List<SelectOption> getDefVal() {
		return defVal;
	}

	public void setDefVal(List<SelectOption> defVal) {
		this.defVal = defVal;
	}

	public String getOptionsName() {
		return optionsName;
	}

	public void setOptionsName(String optionsName) {
		this.optionsName = optionsName;
	}

}

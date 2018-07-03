package com.cs.screen.builder.item;

import java.util.List;

import com.cs.screen.builder.consts.Consts;

public class NumFieldItem extends FieldItem{
	 private Double defVal;

	public NumFieldItem() {
		super();
		this.setType(Consts.Type_NumInput);
	}	
	public NumFieldItem(String desc, String name,List<String> ckecks) {
		this(desc,name,null,ckecks);
	}
	public NumFieldItem(String desc, String name, List<String> ckecks,Double defVal) {
		this(desc,name,null,ckecks,defVal);
	}
	public NumFieldItem(String desc, String name, List<Event> events,List<String> ckecks) {
		this(desc,name,events,ckecks,null);
	}

	public NumFieldItem(String desc, String name, List<Event> events, List<String> ckecks,Double defVal) {
		super(Consts.Type_NumInput,desc,name,events,ckecks);
		this.defVal = defVal;
	}

	public Double getDefVal() {
		return defVal;
	}

	public void setDefVal(Double defVal) {
		this.defVal = defVal;
	}
	 
}

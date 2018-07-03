package com.cs.screen.builder.item;

import java.util.Date;
import java.util.List;

import com.cs.screen.builder.consts.Consts;

public class DatePickerFieldItem extends FieldItem{
	private Date defVal;
	

	public DatePickerFieldItem() {
		super();
		this.setType(Consts.Type_DatePicker);
	}
	
	public DatePickerFieldItem( String desc, String name,  List<String> ckecks) {
		this(desc, name, null, ckecks);
	}
	
	public DatePickerFieldItem( String desc, String name,  List<String> ckecks, Date defVal) {
		this(desc, name, null, ckecks,defVal);
	}

	public DatePickerFieldItem( String desc, String name, List<Event> events, List<String> ckecks) {
		this(desc, name, events, ckecks,null);
	}

	public DatePickerFieldItem(String desc, String name, List<Event> events, List<String> ckecks, Date defVal) {
		super(Consts.Type_DatePicker, desc, name, events, ckecks);
		this.defVal = defVal;
	}

	public Date getDefVal() {
		return defVal;
	}

	public void setDefVal(Date defVal) {
		this.defVal = defVal;
	}

}

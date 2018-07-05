package com.cs.screen.builder.ts;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.consts.Consts;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.SelectFieldItem;

public class FieldInitBuilder extends STGroupBuilder {
	public FieldInitBuilder(STGroup stGroup) {
		super(stGroup);
	}
	public  String genFieldInit(FieldItem field) {
		String rtn="";
		switch(field.getType()) {
		 case Consts.Type_TextInput:
			 rtn=genInputField(field);
			 break;
		 case Consts.Type_NumInput:
			 rtn=genNumField(field);
			 break;
		 case Consts.Type_DatePicker:
			 rtn=genDatePickerField(field);
			 break;
		 case Consts.Type_Select:
			 rtn=genSelectField(field);
			 break;
		}
		return rtn;		
	}
	private  String genSelectField(FieldItem field) {
		if (((SelectFieldItem) field).getOptionsName() != null) {
			ST st = getStGroup().getInstanceOf("varSelectInit");
			st.add("fieldItem", field);
			return st.render();
		}else {
			return null;
		}
	}

	private  String genDatePickerField(FieldItem field) {
		// TODO Auto-generated method stub
		return null;
	}

	private  String genNumField(FieldItem field) {
		// TODO Auto-generated method stub
		return null;
	}

	private  String genInputField(FieldItem field) {
		// TODO Auto-generated method stub
		return null;
	}
}

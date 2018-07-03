package com.cs.screen.builder.ts;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.ScreenBuilder;
import com.cs.screen.builder.consts.Consts;
import com.cs.screen.builder.item.FieldItem;

public class FieldDeclaBuilder extends ScreenBuilder{

	public static String genFieldDecla(FieldItem field) {
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

	private static String genSelectField(FieldItem field) {
		 ST st = getTs().getInstanceOf("varSelectDecal");
	     st.add("fieldItem", field);
	     return st.render();
	}

	private static String genDatePickerField(FieldItem field) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String genNumField(FieldItem field) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String genInputField(FieldItem field) {
		// TODO Auto-generated method stub
		return null;
	}
}

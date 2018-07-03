package com.cs.screen.builder;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.consts.Consts;
import com.cs.screen.builder.item.FieldItem;

public class FieldBuilder extends ScreenBuilder{
	public static String genField(FieldItem field) {
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
		 ST st = getHtml().getInstanceOf("formSelect");
	     st.add("fielditem", field);
	     return st.render();
	}

	private static String genDatePickerField(FieldItem field) {
		ST st = getHtml().getInstanceOf("formDate");
	     st.add("fielditem", field);
	     return st.render();
	}

	private static String genNumField(FieldItem field) {
		ST st = getHtml().getInstanceOf("formInputNum");
	     st.add("fielditem", field);
	     return st.render();
	}

	private static String genInputField(FieldItem field) {
		ST st = getHtml().getInstanceOf("formInput");
	     st.add("fielditem", field);
	     return st.render();
	}
}

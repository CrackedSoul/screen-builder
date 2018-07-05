package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.consts.Consts;
import com.cs.screen.builder.item.FieldItem;

public class FieldBuilder extends STGroupBuilder{
	public FieldBuilder(STGroup stGroup) {
		super(stGroup);
	}

	public  String genField(FieldItem field) {
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
		 ST st = getStGroup().getInstanceOf("formSelect");
	     st.add("fielditem", field);
	     return st.render();
	}

	private  String genDatePickerField(FieldItem field) {
		ST st = getStGroup().getInstanceOf("formDate");
	     st.add("fielditem", field);
	     return st.render();
	}

	private  String genNumField(FieldItem field) {
		ST st = getStGroup().getInstanceOf("formInputNum");
	     st.add("fielditem", field);
	     return st.render();
	}

	private  String genInputField(FieldItem field) {
		ST st = getStGroup().getInstanceOf("formInput");
	     st.add("fielditem", field);
	     return st.render();
	}
}

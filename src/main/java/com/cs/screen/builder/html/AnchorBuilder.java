package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.item.FormItem;

public class AnchorBuilder extends STGroupBuilder{
	public AnchorBuilder(STGroup stGroup) {
		super(stGroup);
		// TODO Auto-generated constructor stub
	}

	public  String genAnchor(FormItem form) {
		 ST st = getStGroup().getInstanceOf("anchor");
	     st.add("form", form);    
	     return st.render();
	}
}

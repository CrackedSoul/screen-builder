package com.cs.screen.builder;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.FormItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;

public class FormBuilder  extends ScreenBuilder{
	public static String genForm(FormItem form) {
		List<String> items=new LinkedList<>();
		for(Item item:form.getItems()) {
			if(item instanceof GroupItem)
				items.add(GroupBuilder.genFroup((GroupItem)item));
			else if(item instanceof FieldItem)
				items.add(FieldBuilder.genField((FieldItem)item));
		}
		 ST st = getTs().getInstanceOf("form");
	     st.add("form", form);
	     st.add("items", items);
	     return st.render();
	}
	
}

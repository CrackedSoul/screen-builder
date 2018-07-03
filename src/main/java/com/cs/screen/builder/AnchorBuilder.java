package com.cs.screen.builder;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.item.FormItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;

public class AnchorBuilder extends ScreenBuilder{
	public static String genAnchor(FormItem form) {
		List<String> items=new LinkedList<>();
		for(Item item:form.getItems()) {
			if(item instanceof GroupItem)
				items.add(GroupBuilder.genFroup((GroupItem)item));			
		}
		 ST st = getHtml().getInstanceOf("anchor");
	     st.add("form", form);    
	     return st.render();
	}
}

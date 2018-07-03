package com.cs.screen.builder.html;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.ScreenBuilder;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;

public class GroupBuilder  extends ScreenBuilder{
	public static String genGroup(GroupItem group) {
		List<String> items=new LinkedList<>();
		for(Item item:group.getItems()) {
			if(item instanceof GroupItem)
				items.add(genGroup((GroupItem)item));
			else if(item instanceof FieldItem)
				items.add(FieldBuilder.genField((FieldItem)item));
		}
		 ST st = getHtml().getInstanceOf("formGroup");
	     st.add("groupItem", group);
	     st.add("items", items);
	     return st.render();
	}
}

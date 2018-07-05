package com.cs.screen.builder.html;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;

public class GroupBuilder  extends STGroupBuilder{
	public GroupBuilder(STGroup stGroup) {
		super(stGroup);
		this.fieldBuilder=new FieldBuilder(stGroup);
	}
	private FieldBuilder fieldBuilder;
	public  String genGroup(GroupItem group) {
		List<String> items=new LinkedList<>();
		for(Item item:group.getItems()) {
			if(item instanceof GroupItem)
				items.add(genGroup((GroupItem)item));
			else if(item instanceof FieldItem)
				items.add(fieldBuilder.genField((FieldItem)item));
		}
		 ST st = getStGroup().getInstanceOf("formGroup");
	     st.add("groupItem", group);
	     st.add("items", items);
	     return st.render();
	}
	public FieldBuilder getFieldBuilder() {
		return fieldBuilder;
	}
	public void setFieldBuilder(FieldBuilder fieldBuilder) {
		this.fieldBuilder = fieldBuilder;
	}
	
}

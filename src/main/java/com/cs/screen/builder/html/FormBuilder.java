package com.cs.screen.builder.html;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.FormItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;

public class FormBuilder  extends STGroupBuilder{
	private GroupBuilder groupBuilder;
	private FieldBuilder fieldBuilder;
	public String genForm(FormItem form) {
		List<String> items=new LinkedList<>();
		for(Item item:form.getForm()) {
			if(item instanceof GroupItem)
				items.add(groupBuilder.genGroup((GroupItem)item));
			else if(item instanceof FieldItem)
				items.add(fieldBuilder.genField((FieldItem)item));
		}
		 ST st = getStGroup().getInstanceOf("form");
	     st.add("form", form);
	     st.add("items", items);
	     return st.render();
	}
	public GroupBuilder getGroupBuilder() {
		return groupBuilder;
	}
	public void setGroupBuilder(GroupBuilder groupBuilder) {
		this.groupBuilder = groupBuilder;
	}
	public FieldBuilder getFieldBuilder() {
		return fieldBuilder;
	}
	public void setFieldBuilder(FieldBuilder fieldBuilder) {
		this.fieldBuilder = fieldBuilder;
	}
	public FormBuilder(STGroup stGroup) {
		super(stGroup);
		fieldBuilder=new FieldBuilder(stGroup);
		groupBuilder=new GroupBuilder(stGroup);
	}	
}

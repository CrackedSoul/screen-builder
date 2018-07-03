package com.cs.screen.builder.ts;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.ScreenBuilder;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;
import com.cs.screen.builder.item.TrxComponment;

public class TrxCompTsBuilder extends ScreenBuilder{
	public static String genTrxCompTs(TrxComponment trxComp) {		
		 ST st = getTs().getInstanceOf("trxComponent");
		 st.add("trxComp", trxComp);
		 addData(st,trxComp);
	     return st.render();
	}
	private static void addData(ST st,TrxComponment trxComp) {
		List<String> varDecal=new LinkedList<>();
		List<String> varInit=new LinkedList<>();
		List<String> function=new LinkedList<>();
		for(Item item:trxComp.getForm().getItems()) {
			if(item instanceof GroupItem)
				genGroup((GroupItem)item,varDecal,varInit,function);
			else if(item instanceof FieldItem)
				genField((FieldItem)item,varDecal,varInit,function);
		}				
		st.add("varDecla",varDecal); 
	    st.add("varInit", varInit);    
	    st.add("function", function);   
	}

	private static void genField(FieldItem fieldItem, List<String> varDecal, List<String> varInit, List<String> function) {
		varDecal.add(FieldDeclaBuilder.genFieldDecla(fieldItem));
		varInit.add(FieldInitBuilder.genFieldInit(fieldItem));
		function.add(EventFuncBuilder.genField(fieldItem));
		
	}
	private static void genGroup(GroupItem groupItem, List<String> varDecal, List<String> varInit, List<String> function) {
		for(Item item:groupItem.getItems()) {
			if(item instanceof GroupItem)
				genGroup((GroupItem)item,varDecal,varInit,function);
			else if(item instanceof FieldItem)
				genField((FieldItem)item,varDecal,varInit,function);
		}	
	}	
}

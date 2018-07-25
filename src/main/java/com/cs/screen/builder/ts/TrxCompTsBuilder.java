package com.cs.screen.builder.ts;

import java.util.LinkedList;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.CompTsBuilder;
import com.cs.screen.builder.item.Component;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.Item;
import com.cs.screen.builder.item.TrxComponent;

public class TrxCompTsBuilder extends CompTsBuilder {
	private FieldDeclaBuilder fieldDecla;
	private FieldInitBuilder fieldInit;
	private EventFuncBuilder eventFunc;

	public String genTrxCompTs(TrxComponent trxComp) {
		ST st = getStGroup().getInstanceOf("trxComponent");
		st.add("trxComp", trxComp);
		addData(st, trxComp);
		return st.render();
	}

	private void addData(ST st, TrxComponent trxComp) {
		List<String> varDecal = new LinkedList<>();
		List<String> varInit = new LinkedList<>();
		List<String> function = new LinkedList<>();
		for (Item item : trxComp.getContent().getForm()) {
			if (item instanceof GroupItem)
				genGroup((GroupItem) item, varDecal, varInit, function);
			else if (item instanceof FieldItem)
				genField((FieldItem) item, varDecal, varInit, function);
		}
		st.add("varDecla", varDecal);
		st.add("varInit", varInit);
		st.add("function", function);
	}

	private void genField(FieldItem fieldItem, List<String> varDecal, List<String> varInit, List<String> function) {
		varDecal.add(fieldDecla.genFieldDecla(fieldItem));
		varInit.add(fieldInit.genFieldInit(fieldItem));
		function.add(eventFunc.genField(fieldItem));

	}

	private void genGroup(GroupItem groupItem, List<String> varDecal, List<String> varInit, List<String> function) {
		for (Item item : groupItem.getItems()) {
			if (item instanceof GroupItem)
				genGroup((GroupItem) item, varDecal, varInit, function);
			else if (item instanceof FieldItem)
				genField((FieldItem) item, varDecal, varInit, function);
		}
	}

	@Override
	public String gengratorPart(Component comp) {
		return genTrxCompTs((TrxComponent) comp);
	}

	public TrxCompTsBuilder(STGroup stGroup) {
		super(stGroup);
		fieldDecla = new FieldDeclaBuilder(stGroup);
		fieldInit = new FieldInitBuilder(stGroup);
		eventFunc = new EventFuncBuilder(stGroup);
	}

	@Override
	public String gengratorPart(String name, Component comp) {
		return genTrxCompTs(name, (TrxComponent) comp);
	}

	public String genTrxCompTs(String name, TrxComponent trxComp) {
		ST st = getStGroup().getInstanceOf("trxComponent");
		st.add("trxComp", trxComp);
		addData(st, trxComp);
		st.add("name", name.toLowerCase());
		st.add("compName", name.replace("-", ""));
		return st.render();
	}
}

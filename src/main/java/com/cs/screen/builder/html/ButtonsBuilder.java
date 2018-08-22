package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.item.TrxComponent;

public class ButtonsBuilder extends STGroupBuilder {

	public ButtonsBuilder(STGroup stGroup) {
		super(stGroup);
	}

	public  String genButton(TrxComponent trxComp) {		
		ST st = getStGroup().getInstanceOf("buttons");
	     st.add("buttons", trxComp.getContent().getButtons());
	     return st.render();
	}
}

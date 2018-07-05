package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.STGroupBuilder;
import com.cs.screen.builder.item.TrxComponment;

public class BreadCrumbBuilder extends STGroupBuilder{
	public BreadCrumbBuilder(STGroup stGroup) {
		super(stGroup);
	}

	public  String genBreadCrumb(TrxComponment trxComp) {		
		 ST st = getStGroup().getInstanceOf("breadCrumbs");
	     st.add("breadCrumbs", trxComp.getBreadCrumb());
	     return st.render();
	}
}

package com.cs.screen.builder;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.item.TrxComponment;

public class BreadCrumbBuilder extends ScreenBuilder{
	public static String genBreadCrumb(TrxComponment trxComp) {		
		 ST st = getHtml().getInstanceOf("breadCrumbs");
	     st.add("breadCrumbs", trxComp.getBreadCrumb());
	     return st.render();
	}
}

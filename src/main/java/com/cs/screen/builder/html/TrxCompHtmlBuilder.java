package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;

import com.cs.screen.builder.ScreenBuilder;
import com.cs.screen.builder.item.TrxComponment;

public class TrxCompHtmlBuilder extends ScreenBuilder{
	public static String genTrxCompHtml(TrxComponment trxComp) {		
		 String breadCrumb=BreadCrumbBuilder.genBreadCrumb(trxComp);
		 String form=FormBuilder.genForm(trxComp.getForm());
		 String anchor=AnchorBuilder.genAnchor(trxComp.getForm());
		 ST st = getHtml().getInstanceOf("trxComp");
	     st.add("breadCrumb", breadCrumb); 
	     st.add("form", form);    
	     st.add("anchor", anchor);    
	     return st.render();
	}

}
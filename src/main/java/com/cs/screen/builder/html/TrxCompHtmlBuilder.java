package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.CompHtmlBuilder;
import com.cs.screen.builder.item.Componment;
import com.cs.screen.builder.item.TrxComponment;

public class TrxCompHtmlBuilder extends CompHtmlBuilder{
	private BreadCrumbBuilder breadCrumbBuilder;
	private FormBuilder formBuilder;
	private AnchorBuilder anchorBuilder;
	public  String genTrxCompHtml(TrxComponment trxComp) {		
		 String breadCrumb=breadCrumbBuilder.genBreadCrumb(trxComp);
		 String form=formBuilder.genForm(trxComp.getForm());
		 String anchor=anchorBuilder.genAnchor(trxComp.getForm());
		 ST st = getStGroup().getInstanceOf("trxComp");
	     st.add("breadCrumb", breadCrumb); 
	     st.add("form", form);    
	     st.add("anchor", anchor);    
	     return st.render();
	}
	@Override
	public String gengratorPart(Componment comp) {
		return genTrxCompHtml((TrxComponment) comp);
	}	
	public TrxCompHtmlBuilder(STGroup stGroup) {
		super(stGroup);
		breadCrumbBuilder=new BreadCrumbBuilder(stGroup);
		formBuilder=new FormBuilder(stGroup);
		anchorBuilder=new AnchorBuilder(stGroup);
	}
}

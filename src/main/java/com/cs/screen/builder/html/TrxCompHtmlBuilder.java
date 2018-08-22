package com.cs.screen.builder.html;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.CompHtmlBuilder;
import com.cs.screen.builder.item.Component;
import com.cs.screen.builder.item.TrxComponent;

public class TrxCompHtmlBuilder extends CompHtmlBuilder{
	private BreadCrumbBuilder breadCrumbBuilder;
	private ButtonsBuilder buttonsBuilder;
	private FormBuilder formBuilder;
	private AnchorBuilder anchorBuilder;
	public  String genTrxCompHtml(TrxComponent trxComp) {		
		 String breadCrumb=breadCrumbBuilder.genBreadCrumb(trxComp);
		 String buttons=buttonsBuilder.genButton(trxComp);
		 String form=formBuilder.genForm(trxComp.getContent());
		 String anchor=anchorBuilder.genAnchor(trxComp.getContent());
		 ST st = getStGroup().getInstanceOf("trxComp");
	     st.add("breadCrumb", breadCrumb); 
	     st.add("form", form);    
	     st.add("buttons", buttons);    
	     st.add("anchor", anchor);    
	     return st.render();
	}
	@Override
	public String gengratorPart(Component comp) {
		return genTrxCompHtml((TrxComponent) comp);
	}	
	public TrxCompHtmlBuilder(STGroup stGroup) {
		super(stGroup);
		breadCrumbBuilder=new BreadCrumbBuilder(stGroup);
		formBuilder=new FormBuilder(stGroup);
		anchorBuilder=new AnchorBuilder(stGroup);
		buttonsBuilder=new ButtonsBuilder(stGroup);
	}
}

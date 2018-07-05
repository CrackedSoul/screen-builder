package com.cs.screen.builder;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import com.cs.screen.builder.html.TrxCompHtmlBuilder;
import com.cs.screen.builder.ts.TrxCompTsBuilder;

public class CompBuilderFactory {
	public static ComponentBuilder getCompBuilder(String compName) {
		return  genTrxCompBuilder();
	}
	private static ComponentBuilder genTrxCompBuilder() {
		ComponentBuilder builder=new ComponentBuilder();
		builder.setPath("E:\\tmp\\domain");
		STGroup htmlst=new STGroupFile("trxCompTemp-html.stg",'$','$');
		TrxCompHtmlBuilder html=new TrxCompHtmlBuilder(htmlst);
		builder.setHtml(html);
		STGroup tsst = new STGroupFile("trxCompTemp-ts.stg",'$','$');
		TrxCompTsBuilder ts=new  TrxCompTsBuilder(tsst);
		builder.setTs(ts);
		return builder;
	}
	
}

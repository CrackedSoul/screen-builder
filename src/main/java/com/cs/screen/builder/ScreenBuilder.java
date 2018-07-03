package com.cs.screen.builder;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public abstract class ScreenBuilder {
	private static STGroup html = new STGroupFile("trxCompTemp-html.stg",'$','$');
	private static STGroup ts = new STGroupFile("trxCompTemp-ts.stg",'$','$');

	public static STGroup getHtml() {
		return html;
	}

	public static STGroup getTs() {
		return ts;
	}
	
}

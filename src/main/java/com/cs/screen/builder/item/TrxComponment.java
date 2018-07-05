package com.cs.screen.builder.item;

import java.util.List;

public class TrxComponment implements Componment{
	 private FormItem form;
	 private List<String> breadCrumbs;

	public FormItem getForm() {
		return form;
	}
	public void setForm(FormItem form) {
		this.form = form;
	}
	public List<String> getBreadCrumb() {
		return breadCrumbs;
	}
	public void setBreadCrumb(List<String> breadCrumbs) {
		this.breadCrumbs = breadCrumbs;
	}
}

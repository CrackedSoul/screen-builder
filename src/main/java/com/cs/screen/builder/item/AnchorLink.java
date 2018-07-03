package com.cs.screen.builder.item;

public class AnchorLink {
	private String href;
	private String title;
	
	public AnchorLink( String title,String href) {
		super();
		this.title = title;
		this.href = href;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

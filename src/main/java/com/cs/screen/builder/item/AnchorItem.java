package com.cs.screen.builder.item;

import java.util.LinkedList;
import java.util.List;

public class AnchorItem implements Item {
	private List<AnchorLink> links;

	public AnchorItem() {
		super();
		this.links = new LinkedList<AnchorLink>();
	}

	public List<AnchorLink> getLinks() {
		return links;
	}
	
	
	public void setLinks(List<AnchorLink> links) {
		this.links = links;
	}

	public void add(AnchorLink link) {
		this.links.add(link);
	}
	public void add(String title,String href) {
		this.links.add(new AnchorLink(title,href));
	}
}

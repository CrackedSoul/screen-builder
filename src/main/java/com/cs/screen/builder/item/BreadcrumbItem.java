package com.cs.screen.builder.item;

import java.util.LinkedList;
import java.util.List;

public class BreadcrumbItem implements Item {
	private List<String> paths;
	

	public BreadcrumbItem() {
		super();
		this.paths=new LinkedList<>();
	}
	public List<String> getPaths() {
		return paths;
	}
	
    public void setPaths(List<String> paths) {
		this.paths = paths;
	}
	public void addPath(String path) {
    	this.paths.add(path);
    }
}

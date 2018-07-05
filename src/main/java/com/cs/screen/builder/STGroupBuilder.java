package com.cs.screen.builder;

import org.stringtemplate.v4.STGroup;

public abstract class STGroupBuilder {
	private STGroup stGroup;

	public STGroupBuilder(STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public STGroup getStGroup() {
		return stGroup;
	}

	public void setStGroup(STGroup stGroup) {
		this.stGroup = stGroup;
	}

}

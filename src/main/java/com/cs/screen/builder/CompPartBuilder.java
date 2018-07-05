package com.cs.screen.builder;

import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.item.Componment;

public  abstract class CompPartBuilder extends STGroupBuilder {
	
	public CompPartBuilder(STGroup stGroup) {
		super(stGroup);
	}

	public abstract String gengratorPart(Componment comp); 
}

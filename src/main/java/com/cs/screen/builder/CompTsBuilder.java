package com.cs.screen.builder;

import org.stringtemplate.v4.STGroup;

import com.cs.screen.builder.item.Componment;

public abstract class CompTsBuilder extends CompPartBuilder{

	public CompTsBuilder(STGroup stGroup) {
		super(stGroup);
	}	
	public abstract String gengratorPart(String name,Componment comp);

}

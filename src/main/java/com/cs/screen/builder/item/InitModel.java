package com.cs.screen.builder.item;

import java.util.List;

public class InitModel implements Item {
	private List<InitItem> constant;
	private List<InitItem> sysunit;
	private List<InitItem> sysuser;
	public List<InitItem> getConstant() {
		return constant;
	}
	public void setConstant(List<InitItem> constant) {
		this.constant = constant;
	}
	public List<InitItem> getSysunit() {
		return sysunit;
	}
	public void setSysunit(List<InitItem> sysunit) {
		this.sysunit = sysunit;
	}
	public List<InitItem> getSysuser() {
		return sysuser;
	}
	public void setSysuser(List<InitItem> sysuser) {
		this.sysuser = sysuser;
	}
	public InitModel(List<InitItem> constant, List<InitItem> sysunit, List<InitItem> sysuser) {
		super();
		this.constant = constant;
		this.sysunit = sysunit;
		this.sysuser = sysuser;
	}
	public InitModel() {
		super();
	}	
}

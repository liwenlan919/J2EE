package com.snsProject.vo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TCgal entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Friends implements java.io.Serializable {
	
	private int id;
	private String uid;
	private Members members;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	
      
}
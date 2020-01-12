package com.snsProject.vo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TCgal entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Liuyuan implements java.io.Serializable {
	
	private int id;
	private String content;
	private String uid;
	private String rid;
	private String addtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	

}
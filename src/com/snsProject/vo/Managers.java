package com.snsProject.vo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TCgal entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Managers implements java.io.Serializable {
	
	private int m_id;
	private String m_name;
	private String m_pwd;
	private int m_state;
	private Date m_time;
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public int getM_state() {
		return m_state;
	}
	public void setM_state(int m_state) {
		this.m_state = m_state;
	}
	public Date getM_time() {
		return m_time;
	}
	public void setM_time(Date m_time) {
		this.m_time = m_time;
	}

}
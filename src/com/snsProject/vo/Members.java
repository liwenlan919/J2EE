package com.snsProject.vo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TCgal entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Members implements java.io.Serializable {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String sex;
	private String birthday;
	private String hometown;
	private String university;
	private String middle;
	private String chuzhong;
	private String xiaoxue;
	private String hobby;
	private String QQ;
	private String phone;
	private String picurl;
	private int hits;
	private Set Friends;// set 一个集合对应多个朋友，那些朋友就可以放到这个集合里
	
	
	
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Set getFriends() {
		return Friends;
	}
	public void setFriends(Set friends) {
		Friends = friends;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMiddle() {
		return middle;
	}
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	public String getChuzhong() {
		return chuzhong;
	}
	public void setChuzhong(String chuzhong) {
		this.chuzhong = chuzhong;
	}
	public String getXiaoxue() {
		return xiaoxue;
	}
	public void setXiaoxue(String xiaoxue) {
		this.xiaoxue = xiaoxue;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	

}
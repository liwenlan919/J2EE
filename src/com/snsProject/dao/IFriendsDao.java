package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Friends;



public interface IFriendsDao {
	
	public void add(Friends t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public PageInfo myqueryPage(PageInfo page,String uid);
	public PageInfo fidqueryPage(PageInfo page,int uid);
	public Friends merge(Friends t);
	public void shenhe(int t);
	
	//public Diary getDiary(Diary Diary);
	public List findByExample(Friends instance);
	public List findByProperty(String propertyName, Object value);
	public Friends findByPropertyOfObject(String propertyName, Object value);
}

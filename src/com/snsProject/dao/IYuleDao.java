package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Yule;



public interface IYuleDao {
	
	public void add(Yule t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public PageInfo myqueryPage(PageInfo page,String uid);
	public Yule merge(Yule t);
	//public void update(Diary t);
	//public Diary getDiary(Diary Diary);
	public List findByExample(Yule instance);
	public List findByProperty(String propertyName, Object value);
	public Yule findByPropertyOfObject(String propertyName, Object value);
}

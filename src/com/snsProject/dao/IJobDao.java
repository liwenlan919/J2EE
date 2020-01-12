package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Job;



public interface IJobDao {
	
	public void add(Job t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public PageInfo myqueryPage(PageInfo page,String uid);
	public Job merge(Job t);
	//public void update(Diary t);
	//public Diary getDiary(Diary Diary);
	public List findByExample(Job instance);
	public List findByProperty(String propertyName, Object value);
	public Job findByPropertyOfObject(String propertyName, Object value);
}

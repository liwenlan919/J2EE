package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Diary;



public interface IDiaryDao {
	
	public void add(Diary t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public PageInfo myqueryPage(PageInfo page,String uid);
	public Diary merge(Diary t);
	//public void update(Diary t);
	//public Diary getDiary(Diary Diary);
	public List findByExample(Diary instance);
	public List findByProperty(String propertyName, Object value);
	public Diary findByPropertyOfObject(String propertyName, Object value);
	
}

package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Photos;



public interface IPhotosDao {
	
	public void add(Photos t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public PageInfo myqueryPage(PageInfo page,String uid);
	public Photos merge(Photos t);
	//public void update(Diary t);
	//public Diary getDiary(Diary Diary);
	public List findByExample(Photos instance);
	public List findByProperty(String propertyName, Object value);
	public Photos findByPropertyOfObject(String propertyName, Object value);
}

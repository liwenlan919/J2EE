package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Liuyuan;



public interface ILiuyuanDao {
	
	public void add(Liuyuan t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public PageInfo myqueryPage(PageInfo page,String uid);
	public Liuyuan merge(Liuyuan t);
	//public void update(Diary t);
	//public Diary getDiary(Diary Diary);
	public List findByExample(Liuyuan instance);
	public List findByProperty(String propertyName, Object value);

}

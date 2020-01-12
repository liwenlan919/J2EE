package com.snsProject.dao;

import java.util.List;
import java.util.Map;

import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Managers;



public interface IManagersDao {
	
	public void add(Managers t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public Managers merge(Managers t);
	public void update(Managers t);
	public Managers getManagers(Managers managers);//
	public List findByExample(Managers instance);
	public List findByProperty(String propertyName, Object value);
	public void update_pwd(Managers ma);
}

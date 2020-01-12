package com.snsProject.dao;

import java.util.List;
import java.util.Map;


import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Members;


/**
 * 用户信息管理类
 * @author Administrator
 *
 */
public interface IMembersDao {
	
	public void add(Members t);
	public void delete(int t_id);
	public PageInfo queryPage(PageInfo page);
	public Members merge(Members t);
	public void update(Members t);
	public void updatehits(int t);
	public Members getManagers(Members managers);//
	public List findByExample(Members instance);
	public List findByProperty(String propertyName, Object value);
	public void update_pwd(Members ma);
	public Members findByPropertyOfObject(String propertyName, Object value);
}

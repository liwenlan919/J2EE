package com.snsProject.struts.action;

import java.util.List;

import com.snsProject.dao.IFriendsDao;
import com.snsProject.dao.impl.FriendsDAOImpl;
import com.snsProject.utils.BeanFactory;
import com.snsProject.utils.MyTools;
import com.snsProject.vo.Friends;
import com.snsProject.vo.Members;



public class FriendsAction extends SuperAction{
	
	private IFriendsDao mDao;
	private Friends mvo;
	    	
	

	
	public IFriendsDao getmDao() {
		return mDao;
	}
	public void setmDao(IFriendsDao mDao) {
		this.mDao = mDao;
	}
	public Friends getMvo() {
		return mvo;
	}
	public void setMvo(Friends mvo) {
		this.mvo = mvo;
	}
	public String mlist_admin() throws Exception {
		this.dynkey = "mlist";
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		Members m = (Members) request_.getSession().getAttribute("user");
		pi = mDao.fidqueryPage(pi,m.getId());
		return "admin";
	}
	public String list_admin() throws Exception {
		this.dynkey = "list";
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		Members m = (Members) request_.getSession().getAttribute("user");
		pi = mDao.myqueryPage(pi,m.getUsername());
		return "admin";
	}
	
	public String delete_admin() throws Exception {
		this.dynkey = "mlist_admin";
		if(par.get("id") != null && !par.get("id").equals("")){
			mDao.delete(Integer.parseInt(par.get("id")));
		}
		return "action";
	}

	public String shenhe_admin() throws Exception {
		this.dynkey = "list_admin";
		if(par.get("id") != null && !par.get("id").equals("")){
			mDao.shenhe(Integer.parseInt(par.get("id")));
		}
		return "action";
	}

	public String toadd_admin() throws Exception {
		this.dynkey = "list";
		return "admin";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add_admin() throws Exception{
		this.dynkey = "list_admin";
	
			
		  Members m = (Members) request_.getSession().getAttribute("user");	
			mvo.setUid(m.getUsername());
			mvo.setFlag(0);
			mDao.add(mvo);
		     return "action";
	
	}
	
	public String toupdate_admin() throws Exception{
		this.dynkey = "update";
		return "admin";
	}
	
	public String update_admin() throws Exception{
		this.dynkey = "pwd";
		if(request_.getSession().getAttribute("ADMIN") == null){
			this.dynkey = "login";
			return "admin";
		}
		
		
				
		//mDao.update_pwd(ma);
		request_.setAttribute("message", "修改成功!");
		return "admin";
	}
	

	
	
}

package com.snsProject.struts.action;

import com.snsProject.dao.ILiuyuanDao;
import com.snsProject.utils.MyTools;
import com.snsProject.vo.Liuyuan;
import com.snsProject.vo.Members;

/**
 * 留言信息管理类
 * @author Administrator
 *
 */
public class LiuyuanAction extends SuperAction{
	
	private ILiuyuanDao mDao;
	private Liuyuan mvo;
	    	
	
	public ILiuyuanDao getmDao() {
		return mDao;
	}

	public void setmDao(ILiuyuanDao mDao) {
		this.mDao = mDao;
	}

	public Liuyuan getMvo() {
		return mvo;
	}

	public void setMvo(Liuyuan mvo) {
		this.mvo = mvo;
	}
	public String mlist_admin() throws Exception {
		this.dynkey = "mlist";
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		pi = mDao.queryPage(pi);
		return "admins";
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
	
	
	public String list_admin2() throws Exception {
		this.dynkey = "list2";
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		request_.setAttribute("uid", mvo.getUid());
		pi = mDao.myqueryPage(pi,mvo.getUid());
		return "admin";
	}
	public String delete_admin() throws Exception {
		this.dynkey = "list_admin";
		if(par.get("id") != null && !par.get("id").equals("")){
			mDao.delete(Integer.parseInt(par.get("id")));
		}
		return "action";
	}
	
	public String mdelete_admin() throws Exception {
		this.dynkey = "mlist_admin";
		if(par.get("id") != null && !par.get("id").equals("")){
			mDao.delete(Integer.parseInt(par.get("id")));
		}
		return "action";
	}
	
	
	public String toadd_admin() throws Exception {
		this.dynkey = "add";
		return "admin";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add_admin() throws Exception{
		this.dynkey = "list_admin";
		if(judgeToken()){
			removeToken();
		  Members m = (Members) request_.getSession().getAttribute("user");	
			mvo.setUid(m.getUsername());
			mvo.setAddtime(MyTools.getSimpleDate());
			mDao.add(mvo);
		     return "action";
		}else{
			this.dynkey = "list_admin";
			return "action";
		}
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

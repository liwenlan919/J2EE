package com.snsProject.struts.action;

import java.util.List;

import com.snsProject.dao.IDiaryDao;
import com.snsProject.dao.impl.DiaryDAOImpl;
import com.snsProject.utils.BeanFactory;
import com.snsProject.utils.MyTools;
import com.snsProject.vo.Diary;
import com.snsProject.vo.Members;
public class DiaryAction extends SuperAction{
	
	private IDiaryDao mDao;
	private Diary mvo;
	    

	public IDiaryDao getmDao() {
		return mDao;
	}

	public void setmDao(IDiaryDao mDao) {
		this.mDao = mDao;
	}

	public Diary getMvo() {
		return mvo;
	}

	public void setMvo(Diary mvo) {
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
	public String _detail() throws Exception {
		this.dynkey = "detail";
		this.resObj =mDao.findByPropertyOfObject("id",mvo.getId());
		return "admin";
	}
	
	public String _detail2() throws Exception {
		this.dynkey = "detail2";
		this.resObj =mDao.findByPropertyOfObject("id",mvo.getId());
		return "admin";
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
		this.dynkey = "toadd_admin";
		if(judgeToken()){
			removeToken();
			Diary ma = new Diary();
			Members m = (Members) request_.getSession().getAttribute("user");	
			mvo.setUid(m.getUsername());
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

package com.snsProject.struts.action;

import java.util.List;

import com.snsProject.dao.IManagersDao;
import com.snsProject.dao.impl.ManagersDAOImpl;
import com.snsProject.utils.BeanFactory;
import com.snsProject.utils.MyTools;
import com.snsProject.vo.Managers;

public class ManagersAction extends SuperAction{
	
	private IManagersDao mDao;
	private Managers mvo;
	public IManagersDao getMDao() {
		return mDao;
	}

	public void setMDao(IManagersDao dao) {
		mDao = dao;
	}
	
	public IManagersDao getmDao() {
		return mDao;
	}

	public void setmDao(IManagersDao mDao) {
		this.mDao = mDao;
	}

	public Managers getMvo() {
		return mvo;
	}

	public void setMvo(Managers mvo) {
		this.mvo = mvo;
	}

	public String list_admin() throws Exception {
		this.dynkey = "list";
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		pi = mDao.queryPage(pi);
		return "admin";
	}
	
	public String delete_admin() throws Exception {
		this.dynkey = "list_admin";
		if(par.get("m_id") != null && !par.get("m_id").equals("")){
			mDao.delete(Integer.parseInt(par.get("m_id")));
		}
		return "action";
	}
	//获取页面的登录名和密码，
	public String login_admin() throws Exception {
		this.dynkey = "index";
		Managers ma = mDao.getManagers(mvo);
		if(ma != null ){
			session_.setAttribute("ADMIN", ma);
			return "admin";
		}else{
			request_.setAttribute("message", "用户名或密码错误!");
			return "login";
		}
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
			Managers ma = new Managers();
			if(par.get("m_name") != null && !par.get("m_name").equals("")){
				ma.setM_name(par.get("m_name"));
				List lst = mDao.findByProperty("m_name", par.get("m_name"));
				if(lst != null && lst.size() > 0){
					request_.setAttribute("message", "用户名已存在!");
					return "action";
				}
			}else{
				request_.setAttribute("message", "用户名不能为空!");
				return "action";
			}
			if(par.get("m_pwd") != null && !par.get("m_pwd").equals("")){
				ma.setM_pwd(MyTools.md5(par.get("m_pwd")));
			}else{
				request_.setAttribute("message", "用户密码不能为空!");
				return "action";
			}
			mDao.add(ma);
			this.dynkey = "list_admin";
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
		Managers ma = (Managers) request_.getSession().getAttribute("ADMIN");
		
		if(par.get("m_pwd") != null && !par.get("m_pwd").equals("")){
			ma.setM_pwd(MyTools.md5(par.get("m_pwd")));
		}else{
			request_.setAttribute("message", "密码不能为空!");
			return "admin";
		}
		if(par.get("m_rpwd") == null || par.get("m_rpwd").equals("")){
			request_.setAttribute("message", "确认密码不能为空!");
			return "admin";
		}
		if(!par.get("m_pwd").equals(par.get("m_rpwd"))){
			request_.setAttribute("message", "两次密码不一致!");
			return "admin";
		}
		
		mDao.update_pwd(ma);
		request_.setAttribute("message", "修改成功!");
		return "admin";
	}
	
	public String update_state() throws Exception{
		this.dynkey = "list_admin";
		if(request_.getSession().getAttribute("ADMIN") == null){
			this.dynkey = "login";
			return "admin";
		}
		Managers ma = new Managers();
		if(par.get("m_id") != null && !par.get("m_id").equals("")){
			ma.setM_id(Integer.parseInt(par.get("m_id")));
		}else{
			return "action";
		}
		ma.setM_state(Integer.parseInt(par.get("m_state")));
		mDao.update(ma);
		return "action";
	}
	
	public String check_name() throws Exception {
		response_.setContentType("text/html;charset=gbk");
		response_.setHeader("Charset","gbk");
		try {
			if(par.get("m_name") != null && !par.get("m_name").equals("")){
				List lst = mDao.findByProperty("m_name", par.get("m_name"));
				
				if(lst != null && lst.size() > 0){
					response_.getWriter().print("false");
				}else{
					response_.getWriter().print("true");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

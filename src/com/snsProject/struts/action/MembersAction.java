package com.snsProject.struts.action;

import java.io.File;
import java.util.List;
import com.snsProject.dao.IMembersDao;
import com.snsProject.utils.MyTools;
import com.snsProject.vo.Members;
import com.snsProject.utils.FilesVo;
import java.util.Calendar;
import java.util.Date;

/**
 * 会员相关信息操作类
 * @author Administrator
 *
 */
public class MembersAction extends SuperAction{
	
	private IMembersDao mDao;
	private Members mvo;
	private FilesVo fvo;
		
		public FilesVo getFvo() {
			return fvo;
		}

		public void setFvo(FilesVo fvo) {
			this.fvo = fvo;
		}


	public IMembersDao getmDao() {
		return mDao;
	}

	public void setmDao(IMembersDao mDao) {
		this.mDao = mDao;
	}

	
	public Members getMvo() {
		return mvo;
	}

	public void setMvo(Members mvo) {
		this.mvo = mvo;
	}

	public String list_admin() throws Exception {
		this.dynkey = "list";//dynkey 框架自带的一个变量。。
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		pi = mDao.queryPage(pi);
		return "admins";
	}
	public String mlist_admin() throws Exception {
		this.dynkey = "list";
		pi.setPagecount(10);//设置页数。。换页。。pi也是struts框架自带的一个全局变量
		pi.setMap(par);//pi里map的属性 给它一个值。。这个值就是par。。
		getClearNullParMap();//清空par par就是哈希map
		pi = mDao.queryPage(pi);
		return "admin";
	}
	public String delete_admin() throws Exception {
		int id = mvo.getId();
		this.dynkey = "list_admin";
		if(par.get("id") != null && !par.get("id").equals("")){
		}
		mDao.delete(mvo.getId());
		return "action";
	}
	
	
	
	public String login_admin() throws Exception {
		this.dynkey = "myinfo";
		Members m = new Members();
		if(par.get("username") != null && !par.get("username").equals("")){
			m.setUsername(par.get("username"));
		}else{
			request_.setAttribute("message", "用户名不能为空!");
			return "index";
		}
		if(par.get("password") != null && !par.get("password").equals("")){
			m.setPassword(par.get("password"));
		}else{
			request_.setAttribute("message", "密码不能为空!");
			return "index";
		}
		Members ma = mDao.getManagers(m);//ma 就是执行查询的结果，结果不等于空，
		if(ma != null ){
			session_.setAttribute("user", ma);
			this.dynkey = "mlist_admin";//已经登录成功用mlist——admin来获取
		return "action";//登陆成功
		
		}else{
			request_.setAttribute("message", "用户名或密码错误!");
			return "index";
		}
	}
	
	public String _show() throws Exception {
		this.dynkey = "show";
		this.resObj =mDao.findByPropertyOfObject("id",mvo.getId());
		mDao.updatehits(mvo.getId());
		return "admin";
	}
	
	/**
	 * 根据会员名查询该会员
	 * @return
	 * @throws Exception
	 */
	public String _showUser() throws Exception {
		this.dynkey = "show";
		this.resObj =mDao.findByPropertyOfObject("username",mvo.getUsername());
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
			Members ma = new Members();
			if(mvo.getUsername()!= null && !mvo.getUsername().equals("")){
				ma.setUsername(mvo.getUsername());
				List lst = mDao.findByProperty("username", mvo.getUsername());
				if(lst != null && lst.size() > 0){
					request_.setAttribute("message", "用户名已存在!");
					return "action";
				}
			}else{
				request_.setAttribute("message", "用户名不能为空!");
				return "action";
			}
		
			mDao.add(mvo);
			this.dynkey = "index";
			return "index";
		}else{
			this.dynkey = "list_admin";
			return "action";
		}
	}
	
	public String toupdate_admin() throws Exception{
		this.dynkey = "myinfo";
		Members ma = (Members) request_.getSession().getAttribute("user");
		this.resObj =mDao.findByPropertyOfObject("id",ma.getId());
		return "admin";
	}
	
	public String update_admin() throws Exception{
		this.dynkey = "toupdate_admin";
		if (fvo != null && fvo.getMyFile() != null) { // 没有上传文件
			if (fvo.getMyFile().length() > 1024 * 1024 * 1000) { // 文件大小限于20M
				request_.setAttribute("message", "文件不能超过100M！");
				return "action";
			}
			String spath="upload/";
			File f = new File(request_.getRealPath("/upload"));
			if(!f.isDirectory()){	//文件夹不存在
				f.mkdir();// 创建文件夹
			}
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			File yearmonthFile = new File(request_.getRealPath("/upload")+"/"
					+ year+month);// 文件
			if (!yearmonthFile.isDirectory()) {// 判断该文件夹是否存在，如果不存在则创建
				yearmonthFile.mkdir();// 创建文件夹
			}
			spath = yearmonthFile.getPath();
			
			int pos = fvo.getMyFileFileName().lastIndexOf(".");
			String cls = fvo.getMyFileFileName().substring(pos).toLowerCase();
			if (cls == null || cls.equals("")) { // 上传类型不能为空
				return null;
			}
			
			String filepath=new Date().getTime() + cls;
			fvo.setImageFileName(spath+"\\"+filepath);
			File imageFile = new File(fvo.getImageFileName());
			if(MyTools.copy(fvo.getMyFile(), imageFile)){	//上传成功
				mvo.setPicurl("upload/" + year+""+month+"/"+filepath);
			}else{
			     mvo.setPicurl(mvo.getPicurl());
				return "action";
			}
		}	
		mDao.update(mvo);
		request_.setAttribute("message", "修改成功!");
		request_.getSession().setAttribute("user", mvo);
		return "action";
	}
	

	
}

package com.snsProject.struts.action;

import java.util.List;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import com.snsProject.dao.IMembersDao;
import com.snsProject.dao.IPhotosDao;
import com.snsProject.dao.impl.PhotosDAOImpl;
import com.snsProject.utils.BeanFactory;
import com.snsProject.utils.MyTools;
import com.snsProject.vo.Photos;
import com.snsProject.vo.Members;
import com.snsProject.utils.FilesVo;
import com.snsProject.utils.MyTools;
public class PhotosAction extends SuperAction{
	
	private IPhotosDao mDao;
	private Photos mvo;
	    
	 private FilesVo fvo;
		
		public FilesVo getFvo() {
			return fvo;
		}

		public void setFvo(FilesVo fvo) {
			this.fvo = fvo;
		}

	

	public IPhotosDao getmDao() {
		return mDao;
	}

	public void setmDao(IPhotosDao mDao) {
		this.mDao = mDao;
	}

	public Photos getMvo() {
		return mvo;
	}

	public void setMvo(Photos mvo) {
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
	
	public String _play() throws Exception {
		this.dynkey = "play";
		this.resObj =mDao.findByPropertyOfObject("id",mvo.getId());
		return "admin";
	}
	
	public String _play2() throws Exception {
		this.dynkey = "play2";
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
			Photos ma = new Photos();
			Members m = (Members) request_.getSession().getAttribute("user");	
			mvo.setUid(m.getUsername());
			
			if (fvo != null && fvo.getMyFile() != null) { // 没有上传文件
				if (fvo.getMyFile().length() > 1024 * 1024 * 1000) { // 文件大小限于20M
					request_.setAttribute("message", "文件不能超过100M！");
					this.dynkey = "toadd_admin";
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
					mvo.setUrl("upload/" + year+""+month+"/"+filepath);
				}else{
					request_.setAttribute("message", "上传视频不能为空！");
					this.dynkey = "toadd_admin";
					return "action";
				}
			}	
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

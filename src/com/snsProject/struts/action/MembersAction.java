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
 * ��Ա�����Ϣ������
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
		this.dynkey = "list";//dynkey ����Դ���һ����������
		pi.setPagecount(10);
		pi.setMap(par);
		getClearNullParMap();
		pi = mDao.queryPage(pi);
		return "admins";
	}
	public String mlist_admin() throws Exception {
		this.dynkey = "list";
		pi.setPagecount(10);//����ҳ��������ҳ����piҲ��struts����Դ���һ��ȫ�ֱ���
		pi.setMap(par);//pi��map������ ����һ��ֵ�������ֵ����par����
		getClearNullParMap();//���par par���ǹ�ϣmap
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
			request_.setAttribute("message", "�û�������Ϊ��!");
			return "index";
		}
		if(par.get("password") != null && !par.get("password").equals("")){
			m.setPassword(par.get("password"));
		}else{
			request_.setAttribute("message", "���벻��Ϊ��!");
			return "index";
		}
		Members ma = mDao.getManagers(m);//ma ����ִ�в�ѯ�Ľ������������ڿգ�
		if(ma != null ){
			session_.setAttribute("user", ma);
			this.dynkey = "mlist_admin";//�Ѿ���¼�ɹ���mlist����admin����ȡ
		return "action";//��½�ɹ�
		
		}else{
			request_.setAttribute("message", "�û������������!");
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
	 * ���ݻ�Ա����ѯ�û�Ա
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
	 * ���
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
					request_.setAttribute("message", "�û����Ѵ���!");
					return "action";
				}
			}else{
				request_.setAttribute("message", "�û�������Ϊ��!");
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
		if (fvo != null && fvo.getMyFile() != null) { // û���ϴ��ļ�
			if (fvo.getMyFile().length() > 1024 * 1024 * 1000) { // �ļ���С����20M
				request_.setAttribute("message", "�ļ����ܳ���100M��");
				return "action";
			}
			String spath="upload/";
			File f = new File(request_.getRealPath("/upload"));
			if(!f.isDirectory()){	//�ļ��в�����
				f.mkdir();// �����ļ���
			}
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			File yearmonthFile = new File(request_.getRealPath("/upload")+"/"
					+ year+month);// �ļ�
			if (!yearmonthFile.isDirectory()) {// �жϸ��ļ����Ƿ���ڣ�����������򴴽�
				yearmonthFile.mkdir();// �����ļ���
			}
			spath = yearmonthFile.getPath();
			
			int pos = fvo.getMyFileFileName().lastIndexOf(".");
			String cls = fvo.getMyFileFileName().substring(pos).toLowerCase();
			if (cls == null || cls.equals("")) { // �ϴ����Ͳ���Ϊ��
				return null;
			}
			
			String filepath=new Date().getTime() + cls;
			fvo.setImageFileName(spath+"\\"+filepath);
			File imageFile = new File(fvo.getImageFileName());
			if(MyTools.copy(fvo.getMyFile(), imageFile)){	//�ϴ��ɹ�
				mvo.setPicurl("upload/" + year+""+month+"/"+filepath);
			}else{
			     mvo.setPicurl(mvo.getPicurl());
				return "action";
			}
		}	
		mDao.update(mvo);
		request_.setAttribute("message", "�޸ĳɹ�!");
		request_.getSession().setAttribute("user", mvo);
		return "action";
	}
	

	
}

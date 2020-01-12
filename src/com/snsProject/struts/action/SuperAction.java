package com.snsProject.struts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.snsProject.utils.PageInfo;
import com.opensymphony.xwork2.ActionSupport;

public abstract class SuperAction extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware ,ServletRequestAware, ServletResponseAware{
	//�ṩ�ķ�װ��request����
	protected final String  LogKey="uo";
	protected Map<String, Object> request;
	//�ṩ�ķ�װ��session����
	protected Map<String, Object> session;
	//�ṩ�ķ�װ��application����
	protected Map<String, Object> application;
	//�ṩ��ԭʼ��request����
	protected HttpServletRequest request_;
	//�ṩ��ԭʼ��session����
	protected HttpSession session_;
	//�ṩ��ԭʼ��application����
	protected ServletContext application_;
	//���ڷ���Map���ض���
	protected Map resMap;
	//���ڷ���List���ض���
	protected List resList;
	//���ڷ���Object���ض���
	protected Object resObj;
	//���ڷ���boolean���ض���
	protected boolean resBool;
	protected PageInfo pi = new PageInfo();
	//��̬ת��Ĺؼ��� Ҫ��Ϸ���ҳ��һ��ʹ��
	protected String dynkey="index";
	//��̬���ǰ̨��������һ����GET�ύ�Ķ���
	protected String Url="";
	//��̬���ǰ̨��������һ����GET�ύ�Ķ���

	protected Map<String,String> par = new HashMap<String,String>();

	protected HttpServletResponse response_;
	protected String page;
	
	public Map getResMap() {
		return resMap;
	}
	public List getResList() {
		return resList;
	}
	public boolean isResBool() {
		return resBool;
	}
	public SuperAction() {
		
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public Map<String, String> getPar() {
		return par;
	}
	public void setPar(Map<String, String> par) {
		this.par = par;
	}
	protected HttpServletRequest getRequest_() {
		return request_;
	}

	protected HttpSession getSession_() {
		return session_;
	}
	
	protected ServletContext getApplication_() {
		return application_;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request_ = request;
		this.session_ = this.request_.getSession();
		this.application_ = this.session_.getServletContext();
	}
	
	public void setServletResponse(HttpServletResponse response_) {
        this.response_= response_;
    }
	
	public HttpServletResponse getResponse_() {
		return response_;
	}
	/**
	 * ���IP��ַ
	 * @return
	 */
	protected  String getIpAddress() {
		String ip = request_.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request_.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request_.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request_.getRemoteAddr();
		}
		return ip;
	}
	public String getDynkey() {
		return dynkey;
	}
	public void setDynkey(String dynkey) {
		this.dynkey = dynkey;
	}

	public PageInfo getPi() {
		return pi;
	}
	public void setPi(PageInfo pi) {
		this.pi = pi;
	}
	public Object getResObj() {
		return resObj;
	}
	public boolean judgeToken() {
		String token=(String) session_.getAttribute("struts.token");
		if(token!=null&&token.equals(request_.getParameter("struts.token"))){
			return true;
		}else{
			return false;
		}
	}
	public void removeToken(){
		session_.removeAttribute("struts.token");
	}

	protected Map getClearNullParMap(){
		Set set=par.keySet();
		java.util.Iterator it=set.iterator();
		while(it.hasNext()){
			String temp=(String) it.next();
			
			if(par.get(temp)==null||par.get(temp).equals("")){
				
				par.put(temp, null);
			}
		}
		return par;
	}
	
	protected String getScript(String arg){
		String javaScriptHtml="<script type='text/javascript'> addPromptMessage('"+arg+"')</script>";
		return javaScriptHtml;
	}
	protected String pageUrl(Map m){
		Set set=m.keySet();
		java.util.Iterator it=set.iterator();
		while(it.hasNext()){
			String temp=(String) it.next();
			Url+="par."+temp+"="+m.get(temp)+"&";
		}
		if(Url.length()!=0){
			Url=Url.substring(0,Url.length()-1);
		}
		return Url;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	protected boolean TransformMap(Map P,String value, String name, String reg) {
		if (P != null) {
			// System.out.println(map.get(name));
			if (value != null && !value.equals("")) {
				if(reg!=null&&!reg.equals("")){
			        Pattern p = Pattern.compile(reg);   
			        Matcher m = p.matcher( value);   
			        boolean b = m.matches();   
			        if(b) {   
			            //System.out.println("��ʽ��ȷ");   
			            P.put(name,value);
			            return true;
			        } else {   
			            //System.out.println("��ʽ����ȷ");   
			            return false;
			        } 	
		        }else{
		        	 P.put(name,value);
		        	 return true;
		        }
				
			} else {
	
				return false;
			}
		} else {
			return false;
		}

	}
}

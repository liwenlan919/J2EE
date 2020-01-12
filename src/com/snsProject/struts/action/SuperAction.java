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
	//提供的封装的request对象
	protected final String  LogKey="uo";
	protected Map<String, Object> request;
	//提供的封装的session对象
	protected Map<String, Object> session;
	//提供的封装的application对象
	protected Map<String, Object> application;
	//提供的原始的request对象
	protected HttpServletRequest request_;
	//提供的原始的session对象
	protected HttpSession session_;
	//提供的原始的application对象
	protected ServletContext application_;
	//用于放入Map返回对象
	protected Map resMap;
	//用于放入List返回对象
	protected List resList;
	//用于放入Object返回对象
	protected Object resObj;
	//用于放入boolean返回对象
	protected boolean resBool;
	protected PageInfo pi = new PageInfo();
	//动态转向的关键字 要配合返回页面一起使用
	protected String dynkey="index";
	//动态获得前台参数对象一般是GET提交的对象
	protected String Url="";
	//动态获得前台参数对象一般是GET提交的对象

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
	 * 获得IP地址
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
			            //System.out.println("格式正确");   
			            P.put(name,value);
			            return true;
			        } else {   
			            //System.out.println("格式不正确");   
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

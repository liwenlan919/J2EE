package com.snsProject.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageInfo {
	
	private int sum;//总行数
	private int pagecount = 10;//每页几条数据
	private int page=1;//当前页
	private int sumpage=1;//总页数
	private int begin = 0;
	private int end = 0;
	
	private List list;//分页对象
	private Map<String,Integer> map =new HashMap();//
	private Object object;
	public int getBeginRow(){
		
		return (this.getPage()-1)*this.getPagecount();
	}
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
		if(pagecount>0){
			if(sum%pagecount==0){
				this.sumpage=sum/pagecount;
			}else{
				this.sumpage=(sum/pagecount)+1;
			}
		}
		begin = getBeginRow();
		end =  getPagecount();
		//if(page>=sumpage&&page!=1&&sum%pagecount!=0){
		//	top=sum%pagecount;
		//}
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
		//this.top=pagecount;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0){
			page = 1;
		}
		this.page = page;
	}
	public int getSumpage() {
		return sumpage;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

//	public int getTop() {
//		return top;
//	}
}

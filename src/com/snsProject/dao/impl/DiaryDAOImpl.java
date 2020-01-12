package com.snsProject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.snsProject.dao.IDiaryDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Diary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiaryDAOImpl extends SuperDao implements IDiaryDao{
	
	private static final Logger log = LoggerFactory.getLogger(DiaryDAOImpl.class);
	
	/**
	 * 添加日记
	 * @param managers
	 */
	public void add(Diary m) {
		log.debug("saving Diary instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * 删除日记
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting Diary instance");
		try {
			String queryString = "delete from Diary m where m.id = ?";
			Query query = getSession().createQuery(queryString);
			query.setInteger(0, mid);
			query.executeUpdate();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * 分页
	 * @param page
	 * @return
	 */
	public PageInfo queryPage(PageInfo page) {
		String count_hql = "select count(*) from  Diary" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Diary order by id desc" ;
			List list = new ArrayList();
			list = getObjectsByLimit(hql,page.getBeginRow(),page.getPagecount());
	 		page.setList(list);
		}
		return page;
	}


	/**
	 * 分页
	 * @param page
	 * @return
	 */
	public PageInfo myqueryPage(PageInfo page,String uid) {
		String count_hql = "select count(*) from  Diary d where d.uid='"+uid+"'" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Diary  d where d.uid='"+uid+"' order by id desc" ;
			List list = new ArrayList();
			list = getObjectsByLimit(hql,page.getBeginRow(),page.getPagecount());
	 		page.setList(list);
		}
		return page;
	}

	/**
	 * 
	 * @param detachedInstance
	 * @return
	 */
	public Diary merge(Diary m) {
		log.debug("merging Managers instance");
		try {
			Diary ms = (Diary) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}


	public List findByExample(Diary instance) {
		log.debug("finding Diary instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Diary instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Diary as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	

	public Diary findByPropertyOfObject(String propertyName, Object value) {
		log.debug("finding Diary instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Diary as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List list=queryObject.list();
			if(list!=null&&list.size()>0){
				return (Diary) list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public static DiaryDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (DiaryDAOImpl) ctx.getBean("DiaryDao");
	}

}

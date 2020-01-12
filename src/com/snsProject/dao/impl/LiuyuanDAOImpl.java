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

import com.snsProject.dao.ILiuyuanDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Liuyuan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiuyuanDAOImpl extends SuperDao implements ILiuyuanDao{
	
	private static final Logger log = LoggerFactory.getLogger(LiuyuanDAOImpl.class);
	
	/**
	 * ÃÌº”¡Ù—‘
	 * @param managers
	 */
	public void add(Liuyuan m) {
		log.debug("saving Liuyuan instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * …æ≥˝¡Ù—‘
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting Job instance");
		try {
			String queryString = "delete from Liuyuan m where m.id = ?";
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
	 * ∑÷“≥
	 * @param page
	 * @return
	 */
	public PageInfo queryPage(PageInfo page) {
		// TODO Auto-generated method stub
		String count_hql = "select count(*) from  Liuyuan" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Liuyuan order by id desc" ;
			List list = new ArrayList();
			list = getObjectsByLimit(hql,page.getBeginRow(),page.getPagecount());
	 		page.setList(list);
		}
		return page;
	}

	/**
	 * ∑÷“≥
	 * @param page
	 * @return
	 */
	public PageInfo myqueryPage(PageInfo page,String uid) {
		// TODO Auto-generated method stub
		String count_hql = "select count(*) from  Liuyuan  l where l.uid='"+uid+"'" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Liuyuan l where l.uid='"+uid+"' order by id desc" ;
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
	public Liuyuan merge(Liuyuan m) {
		log.debug("merging Liuyuan instance");
		try {
			Liuyuan ms = (Liuyuan) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}


	public List findByExample(Liuyuan instance) {
		log.debug("finding Liuyuan instance by example");
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
		log.debug("finding Liuyuan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Liuyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	

	
	public static LiuyuanDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (LiuyuanDAOImpl) ctx.getBean("LiuyuanDao");
	}

}

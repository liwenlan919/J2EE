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

import com.snsProject.dao.IMusicDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Members;
import com.snsProject.vo.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MusicDAOImpl extends SuperDao implements IMusicDao{
	
	private static final Logger log = LoggerFactory.getLogger(MusicDAOImpl.class);
	
	/**
	 * Ìí¼ÓÒôÀÖ
	 * @param managers
	 */
	public void add(Music m) {
		log.debug("saving Music instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * É¾³ýÒôÀÖ
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting Music instance");
		try {
			String queryString = "delete from Music m where m.id = ?";
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
	 * ·ÖÒ³
	 * @param page
	 * @return
	 */
	public PageInfo queryPage(PageInfo page) {
		// TODO Auto-generated method stub
		String count_hql = "select count(*) from  Music" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Music order by id desc" ;
			List list = new ArrayList();
			list = getObjectsByLimit(hql,page.getBeginRow(),page.getPagecount());
	 		page.setList(list);
		}
		return page;
	}

	/**
	 * ·ÖÒ³
	 * @param page
	 * @return
	 */
	public PageInfo myqueryPage(PageInfo page,String uid) {
		// TODO Auto-generated method stub
		String count_hql = "select count(*) from  Music m where m.uid='"+uid+"'" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Music m where m.uid='"+uid+"' order by id desc" ;
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
	public Music merge(Music m) {
		log.debug("merging Music instance");
		try {
			Music ms = (Music) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}


	public List findByExample(Music instance) {
		log.debug("finding Music instance by example");
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
		log.debug("finding Music instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Music as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Music findByPropertyOfObject(String propertyName, Object value) {
		log.debug("finding Music instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Music as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List list=queryObject.list();
			if(list!=null&&list.size()>0){
				return (Music) list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public static MusicDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (MusicDAOImpl) ctx.getBean("IMusicDao");
	}

}

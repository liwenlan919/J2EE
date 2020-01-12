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

import com.snsProject.dao.IPhotosDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Photos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhotosDAOImpl extends SuperDao implements IPhotosDao{
	
	private static final Logger log = LoggerFactory.getLogger(PhotosDAOImpl.class);
	
	/**
	 * Ìí¼ÓÕÕÆ¬
	 * @param managers
	 */
	public void add(Photos m) {
		log.debug("saving Photos instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * É¾³ýÕÕÆ¬
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting Photos instance");
		try {
			String queryString = "delete from Photos m where m.id = ?";
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
		String count_hql = "select count(*) from  Photos" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Photos order by id desc" ;
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
		String count_hql = "select count(*) from  Photos p where p.uid='"+uid+"'" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Photos  p where p.uid='"+uid+"' order by id desc" ;
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
	public Photos merge(Photos m) {
		log.debug("merging Photos instance");
		try {
			Photos ms = (Photos) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}


	public List findByExample(Photos instance) {
		log.debug("finding Photos instance by example");
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
		log.debug("finding Photos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Photos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	

	public Photos findByPropertyOfObject(String propertyName, Object value) {
		log.debug("finding Photos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Photos as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List list=queryObject.list();
			if(list!=null&&list.size()>0){
				return (Photos) list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public static PhotosDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (PhotosDAOImpl) ctx.getBean("IPhotosDao");
	}

}

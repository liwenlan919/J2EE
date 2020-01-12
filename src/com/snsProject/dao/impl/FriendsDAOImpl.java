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

import com.snsProject.dao.IFriendsDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Friends;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendsDAOImpl extends SuperDao implements IFriendsDao{
	
	private static final Logger log = LoggerFactory.getLogger(FriendsDAOImpl.class);
	
	/**
	 * Ìí¼ÓºÃÓÑ
	 * @param managers
	 */
	public void add(Friends m) {
		log.debug("saving Friends instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * É¾³ýºÃÓÑ
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting Friends instance");
		try {
			String queryString = "delete from Friends m where m.id = ?";
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
	 * ÉóºËºÃÓÑ
	 * @param user
	 */
	public void shenhe(int mid) {
		log.debug("update Friends instance");
		try {
			String queryString = "update  Friends m set m.flag=1 where m.id = ?";
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
		String count_hql = "select count(*) from  Friends" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Friends order by id desc" ;
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
		String count_hql = "select count(*) from  Friends j where j.flag=1 and j.uid='"+uid+"'" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Friends j where j.flag=1 and j.uid='"+uid+"' order by id desc" ;
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
	public PageInfo fidqueryPage(PageInfo page,int fid) {
		String count_hql = "select count(*) from  Friends j where j.flag=0 and  j.members.id="+fid+"" ;
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Friends j where j.flag=0 and j.members.id="+fid+" order by id desc" ;
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
	public Friends merge(Friends m) {
		log.debug("merging Job instance");
		try {
			Friends ms = (Friends) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}


	public List findByExample(Friends instance) {
		log.debug("finding Friends instance by example");
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
		log.debug("finding Friends instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Friends as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Friends findByPropertyOfObject(String propertyName, Object value) {
		log.debug("finding Friends instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Friends as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List list=queryObject.list();
			if(list!=null&&list.size()>0){
				return (Friends) list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public static FriendsDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (FriendsDAOImpl) ctx.getBean("FriendsDao");
	}

}

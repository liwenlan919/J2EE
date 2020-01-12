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

import com.snsProject.dao.IManagersDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Managers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagersDAOImpl extends SuperDao implements IManagersDao{
	
	private static final Logger log = LoggerFactory.getLogger(ManagersDAOImpl.class);
	
	/**
	 * 添加用户
	 * @param managers
	 */
	public void add(Managers m) {
		log.debug("saving Managers instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * 删除用户
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting managers instance");
		try {
			String queryString = "delete from Managers m where m.m_id = ?";
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
		// TODO Auto-generated method stub
		String count_hql = "select count(*) from  Managers" ;
		List count_list = this.getHibernateTemplate().find(count_hql);//h框架
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Managers order by m_id desc" ;
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
	public Managers merge(Managers m) {
		log.debug("merging Managers instance");
		try {
			Managers ms = (Managers) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void update(Managers m) {
		log.debug("update User instance");
		try {
			String queryString = "update Managers m set m_state = ? where m.m_id = ?";
			Query query = getSession().createQuery(queryString);
			query.setInteger(0, m.getM_state());
			query.setInteger(1, m.getM_id());
			query.executeUpdate();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void update_pwd(Managers m) {
		log.debug("update_pwd  User instance");
		try {
			String queryString = "update Managers m set m_pwd = ? where m.m_id = ?";
			Query query = getSession().createQuery(queryString);
			query.setString(0, m.getM_pwd());
			query.setInteger(1, m.getM_id());
			query.executeUpdate();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public List findByExample(Managers instance) {
		log.debug("finding Managers instance by example");
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
		log.debug("finding Managers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Managers as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Managers getManagers(Managers managers) {
		log.debug("finding Manager instance with property: ");
		try {
			String queryString = "from Managers  where m_name= ? and m_pwd = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, managers.getM_name());
			queryObject.setParameter(1, managers.getM_pwd());
			List list=queryObject.list();
			if(list!=null&&list.size()>0){
				return (Managers) list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	public static ManagersDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ManagersDAOImpl) ctx.getBean("ManagersDao");
	}

}

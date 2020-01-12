package com.snsProject.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import com.snsProject.dao.IMembersDao;
import com.snsProject.utils.PageInfo;
import com.snsProject.vo.Members;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MembersDAOImpl extends SuperDao implements IMembersDao{
	
	private static final Logger log = LoggerFactory.getLogger(MembersDAOImpl.class);
	
	/**
	 * 添加用户
	 * @param managers
	 */
	public void add(Members m) {
		log.debug("saving Members instance");
		try {
			getHibernateTemplate().save(m);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	public void update(Members m) {
		log.debug("update Members instance");
		try {
			getHibernateTemplate().update(m);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	/**
	 * 删除用户
	 * @param user
	 */
	public void delete(int mid) {
		log.debug("deleting Members instance");
		try {
			String queryString = "delete from Members m where m.id = ?";
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
	 * 删除用户
	 * @param user
	 */
	public void updatehits(int mid) {
		log.debug("update Members instance");
		try {
			String queryString = "update  Members m set m.hits=m.hits +1 where m.id = ?";
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
		String count_hql = "select count(*) from  Members u where 1 = 1 " ;
		
		if(page.getMap().get("keyword") != null){
			count_hql += " and "+page.getMap().get("cid")+" like '%"+page.getMap().get("keyword")+"%'";
		}
		List count_list = this.getHibernateTemplate().find(count_hql);
		if(count_list != null && count_list.size() != 0){
			page.setSum(Integer.parseInt(count_list.get(0).toString()));
			String hql = "from Members u where 1 =1  " ;
			if(page.getMap().get("keyword") != null){
				hql += " and "+page.getMap().get("cid")+" like '%"+page.getMap().get("keyword")+"%'";
			}
			hql += " order by u.hits desc";
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
	public Members merge(Members m) {
		log.debug("merging Managers instance");
		try {
			Members ms = (Members) getHibernateTemplate().merge(
					m);
			log.debug("merge successful");
			return ms;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}


	
	public void update_pwd(Members m) {
		log.debug("update_pwd  User instance");
		try {
			String queryString = "update Members m set password = ? where m.id = ?";
			Query query = getSession().createQuery(queryString);
			query.setString(0, m.getPassword());
			query.setInteger(1, m.getId());
			query.executeUpdate();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public List findByExample(Members instance) {
		log.debug("finding Members instance by example");
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
		log.debug("finding Members instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Members as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//
	public Members getManagers(Members managers) {
		log.debug("finding Members instance with property: ");
		try {
			String queryString = "from Members  where username= ? and password = ?";//
			Query queryObject = getSession().createQuery(queryString);//
			queryObject.setParameter(0, managers.getUsername());//赋值。。执行一个查询操作
			queryObject.setParameter(1, managers.getPassword());
			List list=queryObject.list();//执行查询
			if(list!=null&&list.size()>0){
				return (Members) list.get(0);//返回一个列表。。事实上不会出现这个。。数据库后台只会有一个数据，搜不到就返回为空。。就是登录失败
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public Members findByPropertyOfObject(String propertyName, Object value) {
		log.debug("finding Members instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Members as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List list=queryObject.list();
			if(list!=null&&list.size()>0){
				return (Members) list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public static MembersDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (MembersDAOImpl) ctx.getBean("MembersDao");
	}

}

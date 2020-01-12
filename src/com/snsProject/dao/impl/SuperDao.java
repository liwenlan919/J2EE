package com.snsProject.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SuperDao extends HibernateDaoSupport{
	
	public List getObjectsByLimit(final String hql, final int begin,
			final int items) {  
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createQuery(hql).setFirstResult(Math.abs(begin))
						.setMaxResults(items).list();
				return result;
			}
		});
	}
}

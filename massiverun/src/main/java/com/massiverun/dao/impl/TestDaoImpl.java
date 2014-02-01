package com.massiverun.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.massiverun.dao.TestDao;
import com.massiverun.pojo.Test;
import com.massiverun.pojo.TestRole;
import com.massiverun.user.pojo.User;

/**
 * 
 * @author Nilamber Kumar
 * Config Test Dao
 */
public class TestDaoImpl implements TestDao{

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void saveTest(Test test)
	{
		//TestRole testRole=new TestRole();
		//testRole.setDes("fshfgjhkg");
		//test.setTestRole(testRole);
		
		//sessionFactory.getCurrentSession().save(new User());
		//sessionFactory.getCurrentSession().save(test);
	}
}

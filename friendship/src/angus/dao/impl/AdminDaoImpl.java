package angus.dao.impl;

import angus.dao.AdminDao;
import angus.model.Admin;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao
{
	public Admin get(Integer id)
	{
		return (Admin)getHibernateTemplate().get(Admin.class, id);
	}

	public void save(Admin admin)
	{
		getHibernateTemplate().save(admin);
	}

	public void update(Admin admin)
	{
		getHibernateTemplate().update(admin);
	}

	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(Admin.class, new Integer(id)));
	}

	public void delete(Admin admin)
	{
		getHibernateTemplate().delete(admin);
	}

	public Integer findByNameAndPass(String name, String pass)
	{
		String[] args = {name, pass};
		
		List<?> result = getHibernateTemplate().find("from Admin as a where a.name = ? and a.pass = ?", args);
		if (result.size() == 1)
		{
			Admin ad = (Admin)result.get(0);
			return new Integer(ad.getId());
		}
		return null;
	}

}

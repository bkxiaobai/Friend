package angus.dao.impl;

import angus.dao.KindDao;
import angus.model.Kind;
import angus.model.Album;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import java.util.List;

public class KindDaoImpl extends HibernateDaoSupport implements KindDao
{	
	public Kind get(Integer id)
	{
		return (Kind)getHibernateTemplate().get(Kind.class, id);
	}

	public void save(Kind kind)
	{
		getHibernateTemplate().save(kind);
	}

	public void update(Kind kind)
	{
		getHibernateTemplate().update(kind);
	}

	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(Kind.class, new Integer(id)));
	}

	public void delete(Kind kind)
	{
		getHibernateTemplate().delete(kind);
	}

	public List<Kind> getAll()
	{
		@SuppressWarnings("unchecked")
		List<Kind> result = (List<Kind>)getHibernateTemplate().find("from Kind");
		return result;
	}

	public List<Album> getAllByKind(final Kind kind, final int first, final int pageSize)
	{
		@SuppressWarnings("unchecked")
		List<Album> result = (List<Album>)getHibernateTemplate().execute(
		new HibernateCallback()
		{
			public Object doInHibernate(Session session)
			{
				List<?> tmp = session.createQuery("from Album as al where al.kind = :kind")
								  .setEntity("kind", kind)
								  .setFirstResult(first)
								  .setMaxResults(pageSize)
								  .list();
				return tmp;
			}
		}
		);
		return result;
	}

	public int getAmount(Kind kind)
	{
		Object[] args = {kind};
		@SuppressWarnings("unchecked")
		List<Album> result =(List<Album>) getHibernateTemplate().find("from Album as al where al.kind = ?", args);
		return result.size();
	}
}

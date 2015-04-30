package angus.dao.impl;

import angus.model.Album;
import angus.dao.AlbumDao;
import angus.model.Client;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import java.util.List;

public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao
{
	public Album get(Integer id)
	{
		return (Album)getHibernateTemplate().get(Album.class, id);
	}

	public void save(Album album)
	{
		getHibernateTemplate().save(album);
	}

	public void update(Album album)
	{
		getHibernateTemplate().update(album);
	}

	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(Album.class, new Integer(id)));
	}

	public void delete(Album album)
	{
		getHibernateTemplate().delete(album);
	}

	public List<?> getAllByClient(final Client client, final int first, final int pageSize)
	{
		List<?> result = (List<?>)getHibernateTemplate().execute(
		new HibernateCallback()
		{
			public Object doInHibernate(Session sess)throws HibernateException
			{
				List<?> tmp = sess.createQuery("from Album as al where al.client = :client")
									   .setEntity("client", client)
									   .setFirstResult(first)
									   .setMaxResults(pageSize)
									   .list();
				return tmp;
			}
		});
		return result;
	}
	public List<?> getAllByClient(final Client client)
	{
		List<?> result = (List<?>)getHibernateTemplate().execute(
		new HibernateCallback()
		{
			public Object doInHibernate(Session sess)throws HibernateException
			{
				List<?> tmp = sess.createQuery("from Album as al where al.client = :client")
									   .setEntity("client", client)
									   .list();
				return tmp;
			}
		});
		return result;
	}
	//获取该用户相册数量
	public int getAmount(Client client)
	{
		Client[] args = {client};
		List<?> result = getHibernateTemplate().find("from Album as al where al.client = ?", args);
		return result.size();	
	}
}

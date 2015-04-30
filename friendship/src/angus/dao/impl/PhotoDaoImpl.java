package angus.dao.impl;

import angus.dao.PhotoDao;
import angus.model.Photo;
import angus.model.Album;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import java.util.List;


public class PhotoDaoImpl extends HibernateDaoSupport implements PhotoDao
{
	public Photo get(Integer id)
	{
		return (Photo)getHibernateTemplate().get(Photo.class, id);
	}

	public void save(Photo photo)
	{
		getHibernateTemplate().save(photo);
	}

	public void update(Photo photo)
	{
		getHibernateTemplate().update(photo);
	}

	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(Photo.class, new Integer(id)));
	}

	public void delete(Photo photo)
	{
		getHibernateTemplate().delete(photo);
	}

	public Integer getCover(Album al, boolean flag)
	{
		Object[] args = {al, flag};
		List<?> result = getHibernateTemplate().find("from Photo as ph where ph.album = ? and ph.cover = ?", args);
		if (result.size() == 1)
		{
			Photo ph = (Photo)result.get(0);
			return new Integer(ph.getId());
		}
		return null;
	}

	public List<Photo> getPhotos(final Album al, final int first, final int pageSize)
	{
		@SuppressWarnings("unchecked")
		List<Photo> result = (List<Photo>)getHibernateTemplate().execute(
		new HibernateCallback()
		{
			public Object doInHibernate(Session session)
			{
				List<?> tmp = session.createQuery("from Photo as ph where ph.album = :al")
								  .setEntity("al", al)
								  .setFirstResult(first)
								  .setMaxResults(pageSize)
								  .list();
				return tmp;
			}
		});
		return result;
	}

	public int getCount(Album al)
	{
		Object[] args = {al};
		List<?> result = getHibernateTemplate().find("from Photo as ph where ph.album = ?", args);
		return result.size();
	}

	public Photo getCoverPhoto(Album al, boolean flag)
	{
		Object[] args = {al, flag};
		List<?> result = getHibernateTemplate().find("from Photo as ph where ph.album = ? and ph.cover = ?", args);
		if (result.size() == 1)
		{
			return (Photo)result.get(0);
		}
		else
		{
			return null;
		}
	}
}

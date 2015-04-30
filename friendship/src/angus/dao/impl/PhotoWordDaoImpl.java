package angus.dao.impl;

import angus.dao.PhotoWordDao;
import angus.model.PhotoWord;
import angus.model.Photo;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import java.util.List;

public class PhotoWordDaoImpl extends HibernateDaoSupport implements PhotoWordDao
{
	public PhotoWord get(Integer id)
	{
		return (PhotoWord)getHibernateTemplate().get(PhotoWord.class, id);
	}

	public void save(PhotoWord photoWord)
	{
		getHibernateTemplate().save(photoWord);
	}

	public void update(PhotoWord photoWord)
	{
		getHibernateTemplate().update(photoWord);
	}

	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(PhotoWord.class, new Integer(id)));
	}

	public void delete(PhotoWord photoWord)
	{
		getHibernateTemplate().delete(photoWord);
	}

	public List<PhotoWord> getPhotoWordByPhoto(final Photo photo, final int first, final int pageSize)
	{
		@SuppressWarnings("unchecked")
		List<PhotoWord> result = (List<PhotoWord>)getHibernateTemplate().execute(
		new HibernateCallback()
		{
			public Object doInHibernate(Session session)
			{
				List<?> tmp = session.createQuery("from PhotoWord as pw where pw.photo = :photo order by pw.id desc")
								  .setEntity("photo", photo)
								  .setFirstResult(first)
								  .setMaxResults(pageSize)
								  .list();
				return tmp;
			}
		}
		);
		return result;
	}

	public int getCount(Photo photo)
	{
		Object[] args = {photo};
		@SuppressWarnings("unchecked")
		List<PhotoWord> result = (List<PhotoWord>)getHibernateTemplate().find("from PhotoWord as pw where pw.photo = ?", args);
		return result.size();
	}
}

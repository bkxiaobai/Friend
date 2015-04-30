package angus.dao.impl;

import java.util.List;

import angus.dao.AlbumWordDao;
import angus.model.Album;
import angus.model.AlbumWord;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AlbumWordDaoImpl extends HibernateDaoSupport implements AlbumWordDao
{
	public AlbumWord get(Integer id)
	{
		return (AlbumWord)getHibernateTemplate().get(AlbumWord.class, id);
	}

	public void save(AlbumWord albumWord)
	{
		getHibernateTemplate().save(albumWord);
	}

	public void update(AlbumWord albumWord)
	{
		getHibernateTemplate().update(albumWord);
	}

	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(AlbumWord.class, new Integer(id)));
	}

	public void delete(AlbumWord albumWord)
	{
		getHibernateTemplate().delete(albumWord);
	}
	public List<AlbumWord> getAlbumWordByPhoto(final Album album, final int first, final int pageSize)
	{
		@SuppressWarnings("unchecked")
		List<AlbumWord> result = (List<AlbumWord>)getHibernateTemplate().execute(
		new HibernateCallback()
		{
			public Object doInHibernate(Session session)
			{
				List<?> tmp = session.createQuery("from AlbumWord as aw where aw.album = :album order by aw.id desc")
								  .setEntity("album", album)
								  .setFirstResult(first)
								  .setMaxResults(pageSize)
								  .list();
				return tmp;
			}
		}
		);
		return result;
	}
	public int getCount(Album album)
	{
		Object[] args = {album};
		@SuppressWarnings("unchecked")
		List<AlbumWord> result = (List<AlbumWord>)getHibernateTemplate().find("from AlbumWord as aw where aw.album = ?", args);
		return result.size();
	}
}

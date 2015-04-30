package angus.dao.impl;

import angus.dao.ClientDao;
import angus.model.Client;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class ClientDaoImpl extends HibernateDaoSupport implements ClientDao
{
	/**
	 * 根据主键加载相片评论。
	 * @param id 需要加载的相片评论ID。
	 * @return 该主键对应的用户。
	 */
	public Client get(Integer id)
	{
		return (Client)getHibernateTemplate().get(Client.class, id);
	}

	/**
	 * 保存特定的相片评论实体。
	 * @param photoWord 需要保存的相册评论。
	 */
	public void save(Client client)
	{
		getHibernateTemplate().save(client);
	}

	/**
	 * 修改特定的相册评论实体
	 * @param photoWord 需要修改的相片评论
	 */
	public void update(Client client)
	{
		getHibernateTemplate().update(client);
	}

	/**
	 * 根据主键删除相片评论
	 * @param id 需要删除的相片评论ID。
	 */
	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(Client.class, new Integer(id)));
	}

	/**
	 * 删除指定的相片评论。
	 * @param photoWord 需要删除的相片评论
	 */
	public void delete(Client client)
	{
		getHibernateTemplate().delete(client);
	}

	/**
	 * 根据用户名和密码查询用户。
	 * @param name 需要查询用户的用户名。
	 * @param pass 需要查询用户的密码。
	 * @return 指定用户名和密码对应用户的主键值。
	 */
	public Integer findByNameAndPass(String name, String pass)
	{
		String[] args = {name, pass};
		List<?> result = getHibernateTemplate().find("from Client as c where c.name = ? and c.pass = ?", args);
		if (result.size() == 1)
		{
			Client c = (Client)result.get(0);
			return new Integer(c.getId());
		}
		return null;
	}

	/**
	 * 根据用户名查询用户。
	 * @param name 需要查询用户的用户名。
	 * @return 指定用户名对应用户的主键值。
	 */
	public Integer findByName(String name)
	{
		String[] args = {name};
		List<?> result = getHibernateTemplate().find("from Client as c where c.name = ?", args);
		if (result.size() == 1)
		{
			Client c = (Client)result.get(0);
			return new Integer(c.getId()); 
		}
		return null;
	}
}

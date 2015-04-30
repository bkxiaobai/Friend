package angus.dao.impl;

import angus.dao.ClientDao;
import angus.model.Client;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class ClientDaoImpl extends HibernateDaoSupport implements ClientDao
{
	/**
	 * ��������������Ƭ���ۡ�
	 * @param id ��Ҫ���ص���Ƭ����ID��
	 * @return ��������Ӧ���û���
	 */
	public Client get(Integer id)
	{
		return (Client)getHibernateTemplate().get(Client.class, id);
	}

	/**
	 * �����ض�����Ƭ����ʵ�塣
	 * @param photoWord ��Ҫ�����������ۡ�
	 */
	public void save(Client client)
	{
		getHibernateTemplate().save(client);
	}

	/**
	 * �޸��ض����������ʵ��
	 * @param photoWord ��Ҫ�޸ĵ���Ƭ����
	 */
	public void update(Client client)
	{
		getHibernateTemplate().update(client);
	}

	/**
	 * ��������ɾ����Ƭ����
	 * @param id ��Ҫɾ������Ƭ����ID��
	 */
	public void delete(int id)
	{
		getHibernateTemplate().delete(getHibernateTemplate().get(Client.class, new Integer(id)));
	}

	/**
	 * ɾ��ָ������Ƭ���ۡ�
	 * @param photoWord ��Ҫɾ������Ƭ����
	 */
	public void delete(Client client)
	{
		getHibernateTemplate().delete(client);
	}

	/**
	 * �����û����������ѯ�û���
	 * @param name ��Ҫ��ѯ�û����û�����
	 * @param pass ��Ҫ��ѯ�û������롣
	 * @return ָ���û����������Ӧ�û�������ֵ��
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
	 * �����û�����ѯ�û���
	 * @param name ��Ҫ��ѯ�û����û�����
	 * @return ָ���û�����Ӧ�û�������ֵ��
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

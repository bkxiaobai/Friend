package angus.dao;

import angus.model.Client;

public interface ClientDao  
{
	/**
	 * ��������������Ƭ���ۡ�
	 * @param id ��Ҫ���ص���Ƭ����ID��
	 * @return ��������Ӧ���û���
	 */
	Client get(Integer id);

	/**
	 * �����ض�����Ƭ����ʵ�塣
	 * @param photoWord ��Ҫ�����������ۡ�
	 */
	void save(Client client);

	/**
	 * �޸��ض����������ʵ��
	 * @param photoWord ��Ҫ�޸ĵ���Ƭ����
	 */
	void update(Client client);

	/**
	 * ��������ɾ����Ƭ����
	 * @param id ��Ҫɾ������Ƭ����ID��
	 */
	void delete(int id);

	/**
	 * ɾ��ָ������Ƭ���ۡ�
	 * @param photoWord ��Ҫɾ������Ƭ����
	 */
	void delete(Client client);

	/**
	 * �����û����������ѯ�û���
	 * @param name ��Ҫ��ѯ�û����û�����
	 * @param pass ��Ҫ��ѯ�û������롣
	 * @return ָ���û����������Ӧ�û�������ֵ��
	 */
	Integer findByNameAndPass(String name, String pass);

	/**
	 * �����û�����ѯ�û���
	 * @param name ��Ҫ��ѯ�û����û�����
	 * @return ָ���û�����Ӧ�û�������ֵ��
	 */
	Integer findByName(String name);
}

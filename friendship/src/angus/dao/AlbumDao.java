package angus.dao;

import angus.model.Album;
import angus.model.Client;
import java.util.List;

public interface AlbumDao 
{
	/**
	 * ��������������ᡣ
	 * @param id ��Ҫ���ص����ID��
	 * @return ��������Ӧ�����ʵ�塣
	 */
	Album get(Integer id);

	/**
	 * �����ض������ʵ�塣
	 * @param album ��Ҫ�������ᡣ
	 */
	void save(Album album);

	/**
	 * �޸��ض����������ʵ��
	 * @param album ��Ҫ�޸ĵ����
	 */
	void update(Album album);

	/**
	 * ��������ɾ�����
	 * @param id ��Ҫɾ�������ID��
	 */
	void delete(int id);

	/**
	 * ɾ��ָ������ᡣ
	 * @param album ��Ҫɾ�������
	 */
	void delete(Album album);

	/**
	 * ��ҳ��ȡָ���û���ȫ����ᡣ
	 * @param client ָ�����û���
	 * @param first ָ��ҳ����ʾ�ĵ�һ����ᡣ
	 * @pram pageSize ҳ������ʾ���������
	 * @return ��ȡָ��ҳ��ȫ������б�
	 */
	List<?> getAllByClient(final Client client, final int first, final int pageSize);
	/**
	 * ��ȡָ���û���ȫ����� 
	 * @param client
	 * @return
	 */
	List<?> getAllByClient(final Client client);
	/**
	 * ��ȡָ���û����������
	 * @return ����ָ���û����������
	 */
	int getAmount(Client client);
}

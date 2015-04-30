package angus.dao;

import angus.model.Photo;
import angus.model.Album;
import java.util.List;

public interface PhotoDao
{
	/**
	 * ��������������Ƭ��
	 * @param id ��Ҫ���ص���ƬID��
	 * @return ��������Ӧ����Ƭʵ�塣
	 */
	Photo get(Integer id);

	/**
	 * �����ض�����Ƭʵ�塣
	 * @param photo ��Ҫ�������Ƭ��
	 */
	void save(Photo photo);

	/**
	 * �޸��ض����������ʵ��
	 * @param photo ��Ҫ�޸ĵ���Ƭ
	 */
	void update(Photo photo);

	/**
	 * ��������ɾ����Ƭ
	 * @param id ��Ҫɾ������ƬID��
	 */
	void delete(int id);

	/**
	 * ɾ��ָ������Ƭ��
	 * @param photo ��Ҫɾ������Ƭ
	 */
	void delete(Photo photo);

	/**
	 * ��ȡָ�����ķ�����ƬID��
	 * @param al ָ����ᡣ
	 * @flag ��Ƭ�Ƿ�Ϊ���������ꡣ
	 * @return ָ�����ķ���ID��
	 */
	Integer getCover(Album al, boolean flag);

	/**
	 * ��ȡָ������ָ��ҳ����Ƭ�б�
     * @param al ָ������ᡣ
	 * @param first ָ�������Ҫ��ʾ�ĵ�һ����Ƭ
	 * @param pageSize ÿҳ��ʾ����Ƭ����
	 * @return �ض�ҳ����ʾ����Ƭ�б�
	 */
	List<Photo> getPhotos(final Album al, final int first, final int pageSize);

	/**
	 * ��ʾ�������������
	 * @param ָ�������
	 * @return �������������
	 */
	int getCount(Album al);

	/**
	 * ��ȡָ�����ķ�����Ƭ��
	 * @param al ָ����ᡣ
	 * @flag ��Ƭ�Ƿ�Ϊ���������ꡣ
	 * @return ָ�����ķ��档
	 */
	Photo getCoverPhoto(Album al, boolean flag);
}

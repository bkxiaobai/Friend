package angus.dao;

import angus.model.Kind;
import angus.model.Album;
import java.util.List;

public interface KindDao
{
	/**
	 * �����������������ࡣ
	 * @param id ��Ҫ���ص�������ID��
	 * @return ��������Ӧ�������ࡣ
	 */
	Kind get(Integer id);

	/**
	 * �����ض���������ʵ�塣
	 * @param kind ��Ҫ����������ࡣ
	 */
	void save(Kind kind);

	/**
	 * �޸��ض����������ʵ��
	 * @param kind ��Ҫ�޸ĵ�������
	 */
	void update(Kind kind);

	/**
	 * ��������ɾ��������
	 * @param id ��Ҫɾ����������ID��
	 */
	void delete(int id);

	/**
	 * ɾ��ָ���������ࡣ
	 * @param kind ��Ҫɾ����������
	 */
	void delete(Kind kind);

	/**
	 * ��ȡȫ����������
	 * return ��ϵͳ��ȫ���������ࡣ
	 */
	List<Kind> getAll();

	/**
	 * ��ҳ��ʾָ�������������б�
	 * @param kind ָ���������ࡣ
	 * @param first ��Ҫ��ʾ�ĵ�һ����ᡣ
	 * @param pageSize ÿҳ��ʾ�����������
	 * @return ָ���������ࡣ
	 */
	List<Album> getAllByKind(final Kind kind, final int first, final int pageSize);


	/**
	 * ��ȡָ����������������
	 * @param kind ָ���������ࡣ
	 * @return ָ���������ࡣ
	 */
	int getAmount(Kind kind);
}

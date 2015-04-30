package angus.service.root;

import angus.vo.AlbumVO;
import angus.vo.AlbumWordVO;
import angus.vo.PhotoVO;
import angus.vo.PhotoWordVO;
import angus.vo.KindVO;
import angus.vo.ClientVO;
import angus.exception.MyException;
import java.util.List;

public interface ClientService
{

	/**
	 * ������Ƭ����
	 * @param title ������Ƭ���۵ı���
	 * @param content ������Ƭ���۵�����
	 * @param addDate ��Ƭ���۵����ʱ��
	 * @param photoId ��Ƭ���۶�Ӧ����Ƭ 
	 * @paam clientId ��Ƭ���۵������ID
	 */
	void addPhotoWord(String title, String content, String addDate, Integer photoId, Integer clientId)throws MyException;
	/**
	 * �����������
	 * @param title
	 * @param content
	 * @param addDate
	 * @param AlbumId
	 * @param clientId
	 * @throws MyException
	 */
	void addAlbumWord(String title, String content, String addDate, Integer albumId, Integer clientId)throws MyException;

	/**
	 * ������Ƭ����
	 * @param title ������Ƭ���۵ı���
	 * @param content ������Ƭ���۵�����
	 * @param addDate ��Ƭ���۵����ʱ��
	 * @param photoId ��Ƭ���۶�Ӧ����Ƭ 
	 * @paam clientId ��Ƭ���۵������ID
	 */
	void addAlbum(String name, String desc, String createDate, long times, Integer cId, Integer kindId)
		throws MyException;

	/**
	 * �������
	 * @param name �������
	 * @param desc �������
	 * @param kindId ��Ҫ������޸�Ϊ�������ࡣ
	 * @param albumId ���ID
	 */
	void updateAlbum(String name, String desc, Integer kindId, Integer albumId)throws MyException;
	/**
	 * ���µ����
	 */
	void updateTimes(Integer albumId)throws MyException;
	/**
	 * ���ָ��albumId�Ƿ�����Ƭ
	 * @param albumId
	 * @return
	 */
	boolean checkHavePhotos(int albumId)throws MyException;
	/**
	 * ɾ�����
	 * @param albumId ��Ҫɾ�������ID
	 */
	void deleteAlbum(int albumId)throws MyException;

	/**
	 * ���ָ��ID������Ƿ����
	 * @param id ��Ҫ�������ID
	 * @return ���ڷ���true�������ڷ���false��
	 */
	boolean checkAlbum(Integer id)throws MyException;

	/**
	 * ����ID����ȡ������ϡ�
	 * @param id ��Ҫ��ȡ������ϵ�ID��
	 * @return ָ��ID��Ӧ�����ֵ����
	 */
	AlbumVO getAlbum(Integer id)throws MyException;

	/**
	 * ����������
	 * @param albumId ָ�����ID
	 * @param photoId ��Ҫ����Ϊ���������ƬID
	 */
	void setCover(Integer albumId, Integer photoId)throws MyException;

	/**
	 * �����û���������У���û���¼
	 * @param name ��ҪУ����û���
	 * @param pass ��ҪУ�������
	 * @return ��ѯ�û�������ֵ�������ѯ�����û�����-1
	 */	
	int checkClient(String name, String pass)throws MyException;

	/**
	 * ��ȡָ���û�������б�
	 * @param clientId ָ���û���ID
	 * @param first ��Ҫ��ʾ�ĵ�һ���ID
	 * @param pageSize ÿҳ��ʾ�����������
	 * @return ���û���Ӧ������б�
	 */
	List<AlbumVO> getClientAlbums(int clinetId , int first, int pageSize)throws MyException;

	/**
	 * ��ȡָ���û������������
	 * @param clientId ��Ҫ�������������û�ID
	 * @return ���û����������
	 */
	int getAlbumCount(int clientId)throws MyException;

	/**
	 * ����ID��ȡָ��������Ϣ
	 * @param id ָ�������ID
	 * @return ��������Ϣ
	 */
	AlbumVO getClientAlbum(Integer id)throws MyException;

	/**
	 * ��ȡָ��ID���û���Ϣ
	 * @param clientId ָ���û����û�ID��
	 * @return ָ���û�����ϸ��Ϣ
	 */
	ClientVO getClientInfo(int clientId)throws MyException;

	/**
	 * �ж�ָ���û������û��Ƿ����
	 * @param name ��Ҫ�жϵ��û���
	 * @return ������û�����Ӧ���û����ڣ��򷵻�true�����򷵻�false
	 */
	boolean checkName(String name)throws MyException;

	/**
	 * ����û�
	 * @param name ����û����û���
	 * @param pass ����û�������
	 * @param sex ����û�������
	 * @param mail ����û��ĵ����ʼ���
	 * @return �����û�������ֵ
	 */
	int addClient(String name, String pass, boolean sex, String mail, String qq)throws MyException;

	/**
	 * ������������ȡ����б�
	 * @param kindId ��Ҫ��ȡ���������ID
	 * @param first ��Ҫ��ʾ�ĵ�һ�����
	 * @param pageSize ÿҳ��ʾ���������
	 * @return ��ѯ��������б�
	 */
	List<AlbumVO> getAlbumsByKind(Integer kindId, int first, int pageSize)throws MyException;

	/**
	 * ��ȡָ���������µ��������
	 * @param kindId ��Ҫ��ѯ��������ID
	 * @return ָ���������µ��������
	 */
	int getAlbumCount(Integer kindId)throws MyException;

	/**
	 * ��ȡָ��������ID��Ӧ��������Ϣ
	 * @param kindId ��Ҫ��ѯ��������ID
	 * @return ָ��������ID��Ӧ����������Ϣ
	 */
	KindVO getKind(Integer kindId)throws MyException;

	/**
	 * ��������ȡ������������Ƭ��
	 * @param albumId ��Ҫ��ѯ�����ID
	 * @param first ��Ҫ��ʾ�ĵ�һ����Ƭ
	 * @param pageCount ÿҳ��ʾ����Ƭ����
	 * @return ��ѯ������������ȫ����Ƭ��
	 */
	List<PhotoVO> getPhotos(Integer albumId, int first, int pageCount)throws MyException;

	/**
	 * ��ȡָ������°�����Ƭ����
	 * @param albumId ָ������ID
	 * @return ������°�������ƬID��
	 */
	int getCount(Integer albumId)throws MyException;
	/**
	 * �����������ID��ȡ��Ƭ��������
	 * @param AlbumId ָ�����ID
	 * @return ������Ӧ���������������
	 */
	int getAlbumWordCount(Integer AlbumId)throws MyException;

	/**
	 * ����ָ��AlbumId��ȡ�������
	 * @param AlbumId ���ID
	 * @param first��Ҫ��ʾ�ĵ�һ������
	 * @param pageSize ÿҳ��ʾ���۵Ĵ�С
	 * @return ��������List
	 * @throws MyException
	 */
	List<AlbumWordVO> getAlbumWords(Integer AlbumId, int first, int pageSize)throws MyException;

	/** 
     * ����һ����Ƭ
	 * @param title ��Ƭ����
	 * @param desc ��Ƭ����
	 * @param times ��Ƭ���ʴ�����
	 * @param picUrl ��Ƭ��URL
	 * @param bigPicUrl ��Ƭ��ͼ��URL
	 * @param smallPicUrl ��ƬСͼ��URL
	 * @param date ��Ƭ���������
	 * @param cover �Ƿ�Ϊ�����档
	 * @param albumId ����Ƭ��Ҫ��ӵ������ID
	 */
	void addPhoto(String title, String desc, long times, String picUrl, String bigPicUrl, String smallPicUrl, 
		String date, boolean cover, Integer albumId)throws MyException;
	
	/**
	 * �ж�ָ��ID��Ӧ����Ƭ�Ƿ���ڡ�
	 * @param ��Ҫ��ѯ����ƬID
	 * @return �����ID��Ӧ����Ƭ���ڣ�����true�����򷵻�false��
	 */
	boolean checkPhoto(Integer phId)throws MyException;
	/**
	 * �޸���Ƭ��Ϣ
	 */
	void updatePhoto(String name, String desc, Integer albumId, Integer phId)throws MyException;
	
	/**
	 * ���µ����
	 * @param phId ���µ����Ƭ�ĵ����
	 */
	void updatePhotoTimes(Integer phId)throws MyException;
	/**
	 * ɾ��ָ����Ƭ
	 * @param ��Ҫɾ������ƬID
	 */
	void deletePhoto(int phId)throws MyException;

	/**
	 * �ж�ָ��ID��ȡ��Ӧ����Ƭ
	 * @param ��Ҫ��ѯ����ƬID
	 * @return ���ظ�ID��Ӧ����Ƭ
	 */
	PhotoVO getPhoto(Integer phId)throws MyException;

	/**
	 * ��ȡָ����Ƭ����Ƭ����
	 * @param first ��Ҫ���ʵĵ�һ����Ƭ
	 * @param pageSize ÿҳ��ʾ����Ƭ����
	 * @return ����ָ��ҳ��ѯ���ص���Ƭ���ۡ�
	 */
	List<PhotoWordVO> getPhotoWords(Integer photoId, int first, int pageSize)throws MyException;

	/**
	 * ������Ƭ����ID��ȡ��Ƭ��������
	 * @param photoId ָ����ƬID
	 * @return ����Ƭ��Ӧ����Ƭ����������
	 */
	int getWordCount(Integer photoId)throws MyException;

	/**
	 * ��ȡ��Ƭ�����ڵ�������
	 * @param photoId ��Ҫ��ѯ����ƬID
	 * @return ָ����Ƭ��Ӧ�������ࡣ
	 */
	KindVO getKindByPhoto(Integer photoId)throws MyException;
	/**
	 * ��ȡ��������ڵ�������
	 * @param AlbumId ��Ҫ��ѯ�����ID
	 * @return ָ������Ӧ�������ࡣ
	 */
	KindVO getKindByAlbum(Integer AlbumId)throws MyException;

	/**
	 * ��ȡϵͳ��ȫ��������
	 * @return ϵͳ������ȫ��������
	 */
	List<KindVO> getAllKind()throws MyException;
	
	/**
	 * ����ƶ��û������
	 * @param cId
	 * @return
	 * @throws MyException
	 */
	List<AlbumVO> getMyAlbum(Integer cId)throws MyException;
	/** 
	 * �޸��û���ϸ��Ϣ
	 * @param cId �û�������ֵ��
	 * @param sex �û����Ա�
	 * @param qq �û���QQ��
	 * @param mail �û��ĵ����ʼ�
	 */
	void updateClient(Integer cId, boolean sex, String qq, String mail)throws MyException;

	/**
	 * �޸��û�������
	 * @param id ��Ҫ�޸ĵ��û�ID��Ϣ
	 * @param pass ��Ҫ�޸ĵ��û�������
	 */
	void updateClient(Integer id, String pass)throws MyException;
}
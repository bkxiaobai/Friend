package angus.service.impl;

import angus.service.root.ClientService;
import angus.dao.PhotoDao;
import angus.dao.ClientDao;
import angus.dao.PhotoWordDao;
import angus.dao.AlbumDao;
import angus.dao.KindDao;
import angus.dao.AlbumWordDao;
import angus.model.AlbumWord;
import angus.model.Photo;
import angus.model.Client;
import angus.model.Kind;
import angus.model.Album;
import angus.model.PhotoWord;
import angus.vo.AlbumWordVO;
import angus.vo.PhotoVO;
import angus.vo.ClientVO;
import angus.vo.PhotoWordVO;
import angus.vo.AlbumVO;
import angus.vo.KindVO;
import angus.exception.MyException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ClientServiceImpl implements ClientService
{
	//ҵ���߼�����־û�����������PhotoDao���
	private PhotoDao pd;
	//ҵ���߼�����־û�����������ClientDao���
	private ClientDao cd;
	//ҵ���߼�����־û�����������PhotoWordDao���
	private PhotoWordDao pwd;
	//ҵ���߼�����־û�����������AlbumDao���
	private AlbumDao ad;
	//ҵ���߼�����־û�����������KindDao���
	private KindDao hd;
	//ҵ���߼�����־û�����������AlbumWordDao���
	private AlbumWordDao awd;
	//spring��ioc��ʵ��
	
	//����ע�����DAO����������setter����
	public void setAd(AlbumDao ad)
	{
		this.ad = ad;
	}
	public void setPd(PhotoDao pd)
	{
		this.pd = pd;
	}
	public void setKd(KindDao hd)
	{
		this.hd = hd;
	}
	public void setCd(ClientDao cd)
	{
		this.cd = cd;
	}
	public void setPwd(PhotoWordDao pwd)
	{
		this.pwd = pwd;
	}
	public void setAwd(AlbumWordDao awd)
	{
		this.awd = awd;
	}

	/**
	 * ������Ƭ����
	 * @param title ������Ƭ���۵ı���
	 * @param content ������Ƭ���۵�����
	 * @param addDate ��Ƭ���۵����ʱ��
	 * @param photoId ��Ƭ���۶�Ӧ����Ƭ 
	 * @paam clientId ��Ƭ���۵������ID
	 */
	public void addPhotoWord(String title, String content, String addDate, Integer photoId, Integer clientId)
		throws MyException
	{
		try
		{
			Photo photo = pd.get(photoId);
			Client client = cd.get(clientId);
			pwd.save(new PhotoWord(title, content, addDate, photo, client));
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("���������쳣");
		}
	}
	/**
	 * �����������
	 * @param title
	 * @param content
	 * @param addDate
	 * @param AlbumId
	 * @param clientId
	 * @throws MyException
	 */
	public void addAlbumWord(String title, String content, String addDate, Integer albumId, Integer clientId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			Client client = cd.get(clientId);
			awd.save(new AlbumWord(title, content, addDate, album, client));
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("���������쳣");
		}
	}

	/**
	 * �������
	 * @param name �������
	 * @param desc �������
	 * @param createDate ���Ĵ���ʱ�䡣
	 * @param times ���ķ��ʴ�����
	 * @param cId ���Ĵ�����ID
	 * @param kindId ���������������ID
	 */
	public void addAlbum(String name, String desc, String createDate, long times, Integer cId, Integer kindId)
		throws MyException
	{
		try
		{
			Client client = cd.get(cId);
			Kind kind = hd.get(kindId);
			Album album = new Album(name, desc, createDate, times, client, kind);
			ad.save(album);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new MyException("�������쳣,������");
		}
	}

	/**
	 * �������
	 * @param name �������
	 * @param desc �������
	 * @param kindId ��Ҫ������޸�Ϊ�������ࡣ
	 * @param albumId ���ID
	 */
	public void updateAlbum(String name, String desc, Integer kindId, Integer albumId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			Kind kind = hd.get(kindId);
			album.setKind(kind);
			album.setName(name);
			album.setDesc(desc);
			ad.update(album);			
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new MyException("�޸������Ϣ�쳣");
		}

	}
	/**
	 * ���µ����
	 */
	public void updateTimes(Integer albumId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			album.setTimes(album.getTimes()+1);
			ad.update(album);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("���µ���������쳣");
		}
	}
	/**
	 * �ж�������Ƿ�����Ƭ
	 * @param albumId
	 * @return
	 */
	public boolean checkHavePhotos(int albumId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			if(album.getPhotos().isEmpty())return false;
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("����Ƿ�����Ƭ�쳣��������");
		}
	}
	/**
	 * ɾ�����
	 * @param albumId ��Ҫɾ�������ID
	 */
	public void deleteAlbum(int albumId)throws MyException
	{
		//�������ļ�Album.hbm.xml�н�Photos �����м����˹ر��ӳټ��� ��Ȼ�Ļ��ᱨһ���쳣
		try
		{
			ad.delete(albumId);		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new MyException("ɾ������쳣");
		}
	}

	/**
	 * ���ָ��ID������Ƿ����
	 * @param id ��Ҫ�������ID
	 * @return ���ڷ���true�������ڷ���false��
	 */
	public boolean checkAlbum(Integer id)throws MyException
	{
		try
		{
			Album album = ad.get(id);
			if (album == null)
			{
				return false;
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new MyException("�����������쳣��������");
		}

	}

	/**
	 * ����ID����ȡ������ϡ�
	 * @param id ��Ҫ��ȡ������ϵ�ID��
	 * @return ָ��ID��Ӧ�����ֵ����
	 */
	public AlbumVO getAlbum(Integer id)throws MyException
	{
		try
		{
			AlbumVO vo = null;
			Album album = ad.get(id);
			if (pd.getCover(album,true)==null)
			{
				vo = fillAlbumVO(album);
			}
			else
			{
				Photo ph = pd.get(pd.getCover(album,true));
				vo = fillAlbumVO(album,ph);
			}
			return vo;
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new MyException("��ȡ��������쳣");
		}
	}

	/**
	 * ����������
	 * @param albumId ָ�����ID
	 * @param photoId ��Ҫ����Ϊ���������ƬID
	 */
	public void setCover(Integer albumId, Integer photoId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			Photo photo = pd.get(photoId);
			Photo coverPhoto = pd.getCoverPhoto(album, true);
			if (coverPhoto == null)
			{
				photo.setCover(true);
				pd.update(photo);
			}
			else
			{
				coverPhoto.setCover(false);
				photo.setCover(true);
				pd.update(photo);
				pd.update(coverPhoto);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace(); 		
			throw new MyException("�����������쳣");
		}
	}

	/**
	 * �����û���������У���û���¼
	 * @param name ��ҪУ����û���
	 * @param pass ��ҪУ�������
	 * @return ��ѯ�û�������ֵ�������ѯ�����û�����-1
	 */	  
	public int checkClient(String name, String pass)throws MyException
	{
		try
		{
			Integer id = cd.findByNameAndPass(name, pass);
			if (id ==null)
			{
				return -1;
			}
			return id.intValue();
		}
		catch (Exception e)
		{
			e.printStackTrace(); 		
			throw new MyException("����û��쳣,������");
		}
	}

	/**
	 * ��ȡָ���û�������б�
	 * @param clientId ָ���û���ID
	 * @param first ��Ҫ��ʾ�ĵ�һ���ID
	 * @param pageSize ÿҳ��ʾ�����������
	 * @return ���û���Ӧ������б�
	 */
	public List<AlbumVO> getClientAlbums(int clientId , int first, int pageSize)throws MyException
	{
		try
		{
			Client client = cd.get(clientId);
			List<?> result = ad.getAllByClient(client, first, pageSize);
			List<AlbumVO> vos = new ArrayList<AlbumVO>();
			for (Iterator<?> it = result.iterator() ; it.hasNext() ; )
			{
				AlbumVO vo = null;
				Album al = (Album)it.next();
				if (pd.getCover(al, true) == null)
				{
					vo = fillAlbumVO(al);
				}
				else
				{
					Photo ph = pd.get(pd.getCover(al, true));
					vo = fillAlbumVO(al, ph);
				}
				vos.add(vo);
			}
			return vos;		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 		
			throw new MyException("��ȡ�û�����쳣");
		}
	}

	/**
	 * ��ȡָ���û������������
	 * @param clientId ��Ҫ�������������û�ID
	 * @return ���û����������
	 */
	public int getAlbumCount(int clientId)throws MyException
	{
		try
		{
			Client client = cd.get(clientId);
			return ad.getAmount(client);			
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ��������쳣");
		}

	}
	
	/**
	 * ����ID��ȡָ��������Ϣ
	 * @param id ָ�������ID
	 * @return ��������Ϣ
	 */
	public AlbumVO getClientAlbum(Integer id)throws MyException
	{
		try
		{
			Album album = ad.get(id);
			if (album == null)
			{
				return null;
			}
			return fillAlbumVO(album);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ���������Ϣ�쳣");
		}
	}

	/* ��ȡָ��ID���û���Ϣ
	 * @param clientId ָ���û����û�ID��
	 * @return ָ���û�����ϸ��Ϣ
	 */
	public ClientVO getClientInfo(int clientId)throws MyException
	{
		try
		{
			Client client = cd.get(clientId);
			if (client == null)
			{
				return null;
			}
			return fillClientInfoVO(client);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ�û������쳣,������");
		}
	}

	/**
	 * �ж�ָ���û������û��Ƿ����
	 * @param name ��Ҫ�жϵ��û���
	 * @return ������û�����Ӧ���û����ڣ��򷵻�true�����򷵻�false
	 */
	public boolean checkName(String name)throws MyException
	{
		try
		{
			if (cd.findByName(name) == null)
			{
				return false;
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException("�����û���ʱ�����쳣");
		}
	}

	/**
	 * ����û�
	 * @param name ����û����û���
	 * @param pass ����û�������
	 * @param sex ����û�������
	 * @param mail ����û��ĵ����ʼ���
	 * @return �����û�������ֵ
	 */
	public int addClient(String name, String pass, boolean sex, String mail, String qq)throws MyException
	{
		try
		{
			Client client = new Client(name, pass, sex, mail, qq); 
			cd.save(client);
			return client.getId();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("ע���û�ʱ�����쳣");
		}
	}

	/**
	 * ������������ȡ����б�
	 * @param kindId ��Ҫ��ȡ���������ID
	 * @param first ��Ҫ��ʾ�ĵ�һ�����
	 * @param pageSize ÿҳ��ʾ���������
	 * @return ��ѯ��������б�
	 */
	public List<AlbumVO> getAlbumsByKind(Integer kindId, int first, int pageSize)throws MyException
	{
		try
		{
			Kind kind = hd.get(kindId);
			List<AlbumVO> avos = new ArrayList<AlbumVO>();
			List<Album> albums = hd.getAllByKind(kind, first, pageSize);
			for (Iterator<Album> it = albums.iterator() ; it.hasNext() ; )
			{
				AlbumVO avo = null;
				Album album = (Album)it.next();
				if (pd.getCover(album, true) == null)
				{
					avo = fillAlbumVO(album);
				}
				else
				{
					Photo ph = pd.get(pd.getCover(album, true));
					avo = fillAlbumVO(album, ph);
				}
				avos.add(avo);
			}
			return avos;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("�쳣");
		}
	}

	/**
	 * ��ȡָ���������µ��������
	 * @param kindId ��Ҫ��ѯ��������ID
	 * @return ָ���������µ��������
	 */
	public int getAlbumCount(Integer kindId)throws MyException
	{
		try
		{
			Kind kind = hd.get(kindId);
			return hd.getAmount(kind);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ��������쳣");
		}
	}

	/**
	 * ��ȡָ��������ID��Ӧ��������Ϣ
	 * @param kindId ��Ҫ��ѯ��������ID
	 * @return ָ��������ID��Ӧ����������Ϣ
	 */
	public KindVO getKind(Integer kindId)throws MyException
	{
		try
		{
			Kind kind = hd.get(kindId);
			return fillKindVO(kind);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ���������쳣");
		}
	}

	/**
	 * ��������ȡ������������Ƭ��
	 * @param albumId ��Ҫ��ѯ�����ID
	 * @param first ��Ҫ��ʾ�ĵ�һ����Ƭ
	 * @param pageCount ÿҳ��ʾ����Ƭ����
	 * @return ��ѯ������������ȫ����Ƭ��
	 */
	public List<PhotoVO> getPhotos(Integer albumId, int first, int pageCount)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			List<Photo> result = pd.getPhotos(album, first, pageCount);
			List<PhotoVO> pvos = new ArrayList<PhotoVO>();
			for (Iterator<Photo> it = result.iterator() ; it.hasNext() ; )
			{
				Photo ph = (Photo)it.next();
				pvos.add(fillPhotoVO(ph));
			}
			return pvos;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ�������Ƭ�쳣,������");
		}
	}
	/**
	 * ����ָ��AlbumId��ȡ�������
	 * @param AlbumId ���ID
	 * @param first��Ҫ��ʾ�ĵ�һ������
	 * @param pageSize ÿҳ��ʾ���۵Ĵ�С
	 * @return ��������List
	 * @throws MyException
	 */
	public List<AlbumWordVO> getAlbumWords(Integer AlbumId, int first, int pageSize)throws MyException
	{
		try
		{
			List<AlbumWordVO> awvos = new ArrayList<AlbumWordVO>();
			Album album = ad.get(AlbumId);
			List<AlbumWord> aws = awd.getAlbumWordByPhoto(album, first, pageSize);
			for (Iterator<AlbumWord> it = aws.iterator() ; it.hasNext() ; )
			{
				AlbumWord aw = (AlbumWord)it.next();
				awvos.add(fillAlbumVO(aw));
			}
			return awvos;
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ��Ƭ�����쳣");
		}
		
	}

	/**
	 * ��ȡָ������°�����Ƭ����
	 * @param albumId ָ������ID
	 * @return ������°�������ƬID��
	 */
	public int getCount(Integer albumId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			return pd.getCount(album);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ��¼�����쳣,������");
		}
	}

	/**
	 * �����������ID��ȡ��Ƭ��������
	 * @param AlbumId ָ�����ID
	 * @return ������Ӧ���������������
	 */
	public int getAlbumWordCount(Integer AlbumId)throws MyException
	{
		try
		{
			Album album = ad.get(AlbumId);
			return awd.getCount(album);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ���������쳣");
		}
	}
	/**
	 * ��ȡ��������ڵ�������
	 * @param AlbumId ��Ҫ��ѯ�����ID
	 * @return ָ������Ӧ�������ࡣ
	 */
	public KindVO getKindByAlbum(Integer AlbumId)throws MyException
	{
		try
		{
			Kind kind = ad.get(AlbumId).getKind();
			return fillKindVO(kind);
		}
		catch (Exception e)
		{
			
			throw new MyException("��ȡ��Ƭ�����쳣");
		}
	}
	
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
	public void addPhoto(String title, String desc, long times, String picUrl, String bigPicUrl, String smallPicUrl, 
		String upDate, boolean cover, Integer albumId)throws MyException
	{
		try
		{
			Album album = ad.get(albumId);
			Photo ph = new Photo(title, desc, times, picUrl, bigPicUrl, smallPicUrl, upDate, album);
			pd.save(ph);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("�����Ƭ�쳣,������");
		}
	}
	/**
	 * �޸���Ƭ��Ϣ
	 */
	public void updatePhoto(String name, String desc, Integer albumId, Integer phId)throws MyException
	{
		try
		{
			Photo photo = pd.get(phId);
			photo.setTitle(name);
			photo.setDesc(desc);
			photo.setCover(false);
			Album album = ad.get(albumId);
			photo.setAlbum(album);
			pd.update(photo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("�޸���Ƭ��Ϣʱ�����쳣");
		}
	}
	/**
	 * ���µ����
	 * @param phId ���µ����Ƭ�ĵ����
	 */
	public void updatePhotoTimes(Integer phId)throws MyException
	{
		try
		{
			Photo photo = pd.get(phId);
			photo.setTimes(photo.getTimes()+1);
			pd.update(photo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("���µ���������쳣");
		}
	}
	/**
	 * �ж�ָ��ID��Ӧ����Ƭ�Ƿ���ڡ�
	 * @param ��Ҫ��ѯ����ƬID
	 * @return �����ID��Ӧ����Ƭ���ڣ�����true�����򷵻�false��
	 */
	public boolean checkPhoto(Integer phId)throws MyException
	{
		try
		{
			Photo photo = pd.get(phId);
			if (photo == null)
			{
				return false;
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException("У����Ƭ�����쳣");
		}
	}

	/**
	 * ɾ��ָ����Ƭ
	 * @param ��Ҫɾ������ƬID
	 */
	public void deletePhoto(int phId)throws MyException
	{
		try
		{
			pd.delete(phId);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("ɾ����Ƭ�쳣");
		}
	}
	
	/**
	 * �ж�ָ��ID��ȡ��Ӧ����Ƭ
	 * @param ��Ҫ��ѯ����ƬID
	 * @return ���ظ�ID��Ӧ����Ƭ
	 */
	public PhotoVO getPhoto(Integer phId)throws MyException
	{
		try
		{
			Photo photo = pd.get(phId);
			PhotoVO pvo = fillPhotoVO(photo);
			return pvo;
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ��Ƭ��Ϣ�쳣");
		}
	}

	/**
	 * ��ȡָ����Ƭ����Ƭ����
	 * @param first ��Ҫ���ʵĵ�һ����Ƭ
	 * @param pageSize ÿҳ��ʾ����Ƭ����
	 * @return ����ָ��ҳ��ѯ���ص���Ƭ���ۡ�
	 */
	public List<PhotoWordVO> getPhotoWords(Integer photoId, int first, int pageSize)throws MyException
	{
		try
		{
			List<PhotoWordVO> pwvos = new ArrayList<PhotoWordVO>();
			Photo photo = pd.get(photoId);
			List<PhotoWord> pws = pwd.getPhotoWordByPhoto(photo, first, pageSize);
			for (Iterator<PhotoWord> it = pws.iterator() ; it.hasNext() ; )
			{
				PhotoWord pw = (PhotoWord)it.next();
				pwvos.add(fillPhotoVO(pw));
			}
			return pwvos;
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ��Ƭ�����쳣");
		}
	}

	/**
	 * ������Ƭ����ID��ȡ��Ƭ��������
	 * @param photoId ָ����ƬID
	 * @return ����Ƭ��Ӧ����Ƭ����������
	 */
	public int getWordCount(Integer photoId)throws MyException
	{
		try
		{
			Photo photo = pd.get(photoId);
			return pwd.getCount(photo);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ѯ���������쳣");
		}
	}

	/**
	 * ��ȡ��Ƭ�����ڵ�������
	 * @param photoId ��Ҫ��ѯ����ƬID
	 * @return ָ����Ƭ��Ӧ�������ࡣ
	 */
	public KindVO getKindByPhoto(Integer photoId)throws MyException
	{
		try
		{
			Kind kind = pd.get(photoId).getAlbum().getKind();
			return fillKindVO(kind);
		}
		catch (Exception e)
		{
			
			throw new MyException("��ȡ��Ƭ�����쳣");
		}
	}

	/**
	 * ��ȡϵͳ��ȫ��������
	 * @return ϵͳ������ȫ��������
	 */
	public List<KindVO> getAllKind()throws MyException
	{
		try
		{
			List<KindVO> result = new ArrayList<KindVO>();
			List<Kind> kinds = hd.getAll();
			for (Iterator<Kind> it = kinds.iterator() ; it.hasNext() ; )
			{
				Kind kind = (Kind)it.next();
				result.add(fillKindVO(kind));
			}
			return result;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ���������쳣");
		}

	}
	/**
	 * ��ȡ��ǰ�û���������
	 * @param cId �û�������ֵ��
	 */
	public List<AlbumVO> getMyAlbum(Integer cId)throws MyException
	{
		try
		{
			Client client = cd.get(cId);
			List<AlbumVO> result = new ArrayList<AlbumVO>();
			@SuppressWarnings("unchecked")
			List<Album> albums = (List<Album>) ad.getAllByClient(client);
			for (Iterator<Album> it = albums.iterator() ; it.hasNext() ; )
			{
				Album album = (Album)it.next();
				result.add(fillAlbumVO(album));
			}
			return result;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("��ȡ���������쳣");
		}

	}
	/** 
	 * �޸��û���ϸ��Ϣ
	 * @param cId �û�������ֵ��
	 * @param sex �û����Ա�
	 * @param qq �û���QQ��
	 * @param mail �û��ĵ����ʼ�
	 */
	public void updateClient(Integer cId, boolean sex, String qq, String mail)throws MyException
	{
		try
		{
			Client client = cd.get(cId);
			client.setSex(sex);
			client.setMail(mail);
			client.setQq(qq);
			cd.update(client);		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("�޸������쳣");
		}

	}

	/**
	 * �޸��û�������
	 * @param id ��Ҫ�޸ĵ��û�ID��Ϣ
	 * @param pass ��Ҫ�޸ĵ��û�������
	 */
	public void updateClient(Integer id, String pass)throws MyException
	{
		try
		{
			Client client = cd.get(id);
			client.setPass(pass);
			cd.update(client);		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			throw new MyException("�޸������쳣");
		}

	}

	//--------------------------------------------------
	//��������������ڽ�POת����VO�Ĺ��߷�����
	//--------------------------------------------------
	private ClientVO fillClientInfoVO(Client client)throws Exception
	{
		ClientVO civo = new ClientVO(client.getId(), client.getName(), client.getPass(), client.getSex(), 
			client.getMail(), client.getQq());
		return civo;
	}

	private AlbumVO fillAlbumVO(Album al, Photo ph)throws Exception
	{
		AlbumVO avo = null;
		avo = new AlbumVO(al.getId(), al.getName(), al.getDesc(), al.getCreateDate(), 
			al.getTimes(), al.getClient().getId(), al.getClient().getName(), 
			al.getKind().getId(), al.getKind().getName(), ph.getId(), ph.getSmallPicUrl());
		return avo;
	}

	private AlbumVO fillAlbumVO(Album al)throws Exception
	{
		AlbumVO avo = null;
		avo = new AlbumVO(al.getId(), al.getName(), al.getDesc(), al.getCreateDate(), 
			al.getTimes(), al.getClient().getId(), al.getClient().getName(), 
			al.getKind().getId(), al.getKind().getName());
		return avo;
	}

	private KindVO fillKindVO(Kind kind)throws Exception
	{
		KindVO kvo = new KindVO(kind.getId(), kind.getName(), kind.getDesc());
		return kvo;
	}

	private PhotoVO fillPhotoVO(Photo ph)throws Exception
	{
		PhotoVO pvo = new PhotoVO(ph.getId(), ph.getTitle(), ph.getDesc(), ph.getTimes(), 
			ph.getPicUrl(), ph.getBigPicUrl(), ph.getSmallPicUrl(), ph.getUpDate(), 
			ph.getCover(), ph.getAlbum().getId(), ph.getAlbum().getName());
		return pvo;
	}

	private PhotoWordVO fillPhotoVO(PhotoWord pw)throws Exception
	{
		PhotoWordVO pwvo = new PhotoWordVO(pw.getId(), pw.getTitle(), pw.getContent(), pw.getAddDate(), 
			pw.getPhoto().getId(), pw.getPhoto().getTitle(), pw.getClient().getId(), pw.getClient().getName());
		return pwvo;
	}
	private AlbumWordVO fillAlbumVO(AlbumWord aw)throws Exception
	{
		AlbumWordVO awvo = new AlbumWordVO(aw.getId(), aw.getTitle(), aw.getContent(), aw.getAddDate(), 
			aw.getAlbum().getId(), aw.getAlbum().getName(), aw.getClient().getId(), aw.getClient().getName());
		return awvo;
	}
}

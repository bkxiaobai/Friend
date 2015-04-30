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
	//业务逻辑组件持久化访问依赖的PhotoDao组件
	private PhotoDao pd;
	//业务逻辑组件持久化访问依赖的ClientDao组件
	private ClientDao cd;
	//业务逻辑组件持久化访问依赖的PhotoWordDao组件
	private PhotoWordDao pwd;
	//业务逻辑组件持久化访问依赖的AlbumDao组件
	private AlbumDao ad;
	//业务逻辑组件持久化访问依赖的KindDao组件
	private KindDao hd;
	//业务逻辑组件持久化访问依赖的AlbumWordDao组件
	private AlbumWordDao awd;
	//spring中ioc的实现
	
	//依赖注入各种DAO组件所必须的setter方法
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
	 * 新增相片评论
	 * @param title 新增相片评论的标题
	 * @param content 新增相片评论的内容
	 * @param addDate 相片评论的添加时间
	 * @param photoId 相片评论对应的相片 
	 * @paam clientId 相片评论的添加人ID
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
			throw new MyException("发表评论异常");
		}
	}
	/**
	 * 新增相册评论
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
			throw new MyException("发表评论异常");
		}
	}

	/**
	 * 新增相册
	 * @param name 相册名字
	 * @param desc 相册描述
	 * @param createDate 相册的创建时间。
	 * @param times 相册的访问次数。
	 * @param cId 相册的创建人ID
	 * @param kindId 相册所属的相册分类ID
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
			throw new MyException("添加相册异常,请重试");
		}
	}

	/**
	 * 更新相册
	 * @param name 相册名字
	 * @param desc 相册描述
	 * @param kindId 需要将相册修改为的相册分类。
	 * @param albumId 相册ID
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
			throw new MyException("修改相册信息异常");
		}

	}
	/**
	 * 更新点击数
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
			throw new MyException("更新点击数出现异常");
		}
	}
	/**
	 * 判断相册内是否含有相片
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
			throw new MyException("检查是否含有照片异常，请重试");
		}
	}
	/**
	 * 删除相册
	 * @param albumId 需要删除的相册ID
	 */
	public void deleteAlbum(int albumId)throws MyException
	{
		//在配置文件Album.hbm.xml中将Photos 属性中加上了关闭延迟加载 不然的话会报一个异常
		try
		{
			ad.delete(albumId);		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new MyException("删除相册异常");
		}
	}

	/**
	 * 检查指定ID的相册是否存在
	 * @param id 需要检查的相册ID
	 * @return 存在返回true，不存在返回false。
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
			throw new MyException("检验相册出现异常，请重试");
		}

	}

	/**
	 * 根据ID来获取相册资料。
	 * @param id 需要获取相册资料的ID。
	 * @return 指定ID对应的相册值对象。
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
			throw new MyException("获取相册资料异常");
		}
	}

	/**
	 * 设置相册封面
	 * @param albumId 指定相册ID
	 * @param photoId 需要设置为相册封面的相片ID
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
			throw new MyException("设置相册封面异常");
		}
	}

	/**
	 * 根据用户名和密码校验用户登录
	 * @param name 需要校验的用户名
	 * @param pass 需要校验的密码
	 * @return 查询用户的主键值，如果查询不到用户返回-1
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
			throw new MyException("检查用户异常,请重试");
		}
	}

	/**
	 * 获取指定用户的相册列表
	 * @param clientId 指定用户的ID
	 * @param first 需要显示的第一相册ID
	 * @param pageSize 每页显示的相册数量。
	 * @return 该用户对应的相册列表。
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
			throw new MyException("获取用户相册异常");
		}
	}

	/**
	 * 获取指定用户的相册数量。
	 * @param clientId 需要获得相册数量的用户ID
	 * @return 该用户的相册数量
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
			throw new MyException("获取相册数量异常");
		}

	}
	
	/**
	 * 根据ID获取指定相册的信息
	 * @param id 指定的相册ID
	 * @return 该相册的信息
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
			throw new MyException("获取单个相册信息异常");
		}
	}

	/* 获取指定ID的用户信息
	 * @param clientId 指定用户的用户ID。
	 * @return 指定用户的详细信息
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
			throw new MyException("获取用户资料异常,请重试");
		}
	}

	/**
	 * 判断指定用户名的用户是否存在
	 * @param name 需要判断的用户名
	 * @return 如果该用户名对应的用户存在，则返回true，否则返回false
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
			throw new MyException("检验用户名时出现异常");
		}
	}

	/**
	 * 添加用户
	 * @param name 添加用户的用户名
	 * @param pass 添加用户的密码
	 * @param sex 添加用户的密码
	 * @param mail 添加用户的电子邮件。
	 * @return 新增用户的主键值
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
			throw new MyException("注册用户时出现异常");
		}
	}

	/**
	 * 根据种类来获取相册列表
	 * @param kindId 需要获取的相册种类ID
	 * @param first 需要显示的第一个相册
	 * @param pageSize 每页显示的相册数量
	 * @return 查询到的相册列表
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
			throw new MyException("异常");
		}
	}

	/**
	 * 获取指定相册分类下的相册数量
	 * @param kindId 需要查询的相册分类ID
	 * @return 指定相册分类下的相册数量
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
			throw new MyException("查询相册总数异常");
		}
	}

	/**
	 * 获取指定相册分类ID对应相册分类信息
	 * @param kindId 需要查询的相册分类ID
	 * @return 指定相册分类ID对应的相册分类信息
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
			throw new MyException("获取单个种类异常");
		}
	}

	/**
	 * 根据相册获取该相册包含的相片。
	 * @param albumId 需要查询的相册ID
	 * @param first 需要显示的第一张相片
	 * @param pageCount 每页显示的相片数量
	 * @return 查询到该相册包含的全部相片。
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
			throw new MyException("查询该相册相片异常,请重试");
		}
	}
	/**
	 * 根据指定AlbumId获取相册评论
	 * @param AlbumId 相册ID
	 * @param first需要显示的第一条评论
	 * @param pageSize 每页显示评论的大小
	 * @return 返回评论List
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
			throw new MyException("查询相片留言异常");
		}
		
	}

	/**
	 * 获取指定相册下包含相片数量
	 * @param albumId 指定相册的ID
	 * @return 该相册下包含的相片ID。
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
			throw new MyException("获取记录总数异常,请重试");
		}
	}

	/**
	 * 根据相册评论ID获取相片评论总数
	 * @param AlbumId 指定相册ID
	 * @return 该相册对应的相册评论总数。
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
			throw new MyException("查询评论总数异常");
		}
	}
	/**
	 * 获取相册所属于的相册大类
	 * @param AlbumId 需要查询的相册ID
	 * @return 指定相册对应的相册大类。
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
			
			throw new MyException("获取相片种类异常");
		}
	}
	
	/** 
     * 增加一张相片
	 * @param title 相片标题
	 * @param desc 相片描述
	 * @param times 相片访问次数。
	 * @param picUrl 相片的URL
	 * @param bigPicUrl 相片大图的URL
	 * @param smallPicUrl 相片小图的URL
	 * @param date 相片的添加日期
	 * @param cover 是否为相册封面。
	 * @param albumId 该相片需要添加到的相册ID
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
			throw new MyException("添加照片异常,请重试");
		}
	}
	/**
	 * 修改相片信息
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
			throw new MyException("修改相片信息时出现异常");
		}
	}
	/**
	 * 更新点击数
	 * @param phId 更新点击相片的点击数
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
			throw new MyException("更新点击数出现异常");
		}
	}
	/**
	 * 判断指定ID对应的相片是否存在。
	 * @param 需要查询的相片ID
	 * @return 如果该ID对应的相片存在，返回true，否则返回false。
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
			throw new MyException("校验相片出现异常");
		}
	}

	/**
	 * 删除指定相片
	 * @param 需要删除的相片ID
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
			throw new MyException("删除照片异常");
		}
	}
	
	/**
	 * 判断指定ID获取对应的相片
	 * @param 需要查询的相片ID
	 * @return 返回该ID对应的相片
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
			throw new MyException("查询照片信息异常");
		}
	}

	/**
	 * 获取指定相片的相片评论
	 * @param first 需要访问的第一张相片
	 * @param pageSize 每页显示的相片数量
	 * @return 根据指定页查询返回的相片评论。
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
			throw new MyException("查询相片留言异常");
		}
	}

	/**
	 * 根据相片评论ID获取相片评论总数
	 * @param photoId 指定相片ID
	 * @return 该相片对应的相片评论总数。
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
			throw new MyException("查询评论总数异常");
		}
	}

	/**
	 * 获取相片所属于的相册分类
	 * @param photoId 需要查询的相片ID
	 * @return 指定相片对应的相册分类。
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
			
			throw new MyException("获取相片种类异常");
		}
	}

	/**
	 * 获取系统中全部相册分类
	 * @return 系统包含的全部相册分类
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
			throw new MyException("获取所有种类异常");
		}

	}
	/**
	 * 获取当前用户的相册分类
	 * @param cId 用户的主键值。
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
			throw new MyException("获取所有种类异常");
		}

	}
	/** 
	 * 修改用户详细信息
	 * @param cId 用户的主键值。
	 * @param sex 用户的性别
	 * @param qq 用户的QQ号
	 * @param mail 用户的电子邮件
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
			throw new MyException("修改资料异常");
		}

	}

	/**
	 * 修改用户的密码
	 * @param id 需要修改的用户ID信息
	 * @param pass 需要修改的用户新密码
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
			throw new MyException("修改密码异常");
		}

	}

	//--------------------------------------------------
	//下面包含六个用于将PO转换成VO的工具方法。
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

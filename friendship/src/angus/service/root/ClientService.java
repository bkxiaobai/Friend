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
	 * 新增相片评论
	 * @param title 新增相片评论的标题
	 * @param content 新增相片评论的内容
	 * @param addDate 相片评论的添加时间
	 * @param photoId 相片评论对应的相片 
	 * @paam clientId 相片评论的添加人ID
	 */
	void addPhotoWord(String title, String content, String addDate, Integer photoId, Integer clientId)throws MyException;
	/**
	 * 新增相册评论
	 * @param title
	 * @param content
	 * @param addDate
	 * @param AlbumId
	 * @param clientId
	 * @throws MyException
	 */
	void addAlbumWord(String title, String content, String addDate, Integer albumId, Integer clientId)throws MyException;

	/**
	 * 新增相片评论
	 * @param title 新增相片评论的标题
	 * @param content 新增相片评论的内容
	 * @param addDate 相片评论的添加时间
	 * @param photoId 相片评论对应的相片 
	 * @paam clientId 相片评论的添加人ID
	 */
	void addAlbum(String name, String desc, String createDate, long times, Integer cId, Integer kindId)
		throws MyException;

	/**
	 * 更新相册
	 * @param name 相册名字
	 * @param desc 相册描述
	 * @param kindId 需要将相册修改为的相册分类。
	 * @param albumId 相册ID
	 */
	void updateAlbum(String name, String desc, Integer kindId, Integer albumId)throws MyException;
	/**
	 * 更新点击数
	 */
	void updateTimes(Integer albumId)throws MyException;
	/**
	 * 检查指定albumId是否含有相片
	 * @param albumId
	 * @return
	 */
	boolean checkHavePhotos(int albumId)throws MyException;
	/**
	 * 删除相册
	 * @param albumId 需要删除的相册ID
	 */
	void deleteAlbum(int albumId)throws MyException;

	/**
	 * 检查指定ID的相册是否存在
	 * @param id 需要检查的相册ID
	 * @return 存在返回true，不存在返回false。
	 */
	boolean checkAlbum(Integer id)throws MyException;

	/**
	 * 根据ID来获取相册资料。
	 * @param id 需要获取相册资料的ID。
	 * @return 指定ID对应的相册值对象。
	 */
	AlbumVO getAlbum(Integer id)throws MyException;

	/**
	 * 设置相册封面
	 * @param albumId 指定相册ID
	 * @param photoId 需要设置为相册封面的相片ID
	 */
	void setCover(Integer albumId, Integer photoId)throws MyException;

	/**
	 * 根据用户名和密码校验用户登录
	 * @param name 需要校验的用户名
	 * @param pass 需要校验的密码
	 * @return 查询用户的主键值，如果查询不到用户返回-1
	 */	
	int checkClient(String name, String pass)throws MyException;

	/**
	 * 获取指定用户的相册列表
	 * @param clientId 指定用户的ID
	 * @param first 需要显示的第一相册ID
	 * @param pageSize 每页显示的相册数量。
	 * @return 该用户对应的相册列表。
	 */
	List<AlbumVO> getClientAlbums(int clinetId , int first, int pageSize)throws MyException;

	/**
	 * 获取指定用户的相册数量。
	 * @param clientId 需要获得相册数量的用户ID
	 * @return 该用户的相册数量
	 */
	int getAlbumCount(int clientId)throws MyException;

	/**
	 * 根据ID获取指定相册的信息
	 * @param id 指定的相册ID
	 * @return 该相册的信息
	 */
	AlbumVO getClientAlbum(Integer id)throws MyException;

	/**
	 * 获取指定ID的用户信息
	 * @param clientId 指定用户的用户ID。
	 * @return 指定用户的详细信息
	 */
	ClientVO getClientInfo(int clientId)throws MyException;

	/**
	 * 判断指定用户名的用户是否存在
	 * @param name 需要判断的用户名
	 * @return 如果该用户名对应的用户存在，则返回true，否则返回false
	 */
	boolean checkName(String name)throws MyException;

	/**
	 * 添加用户
	 * @param name 添加用户的用户名
	 * @param pass 添加用户的密码
	 * @param sex 添加用户的密码
	 * @param mail 添加用户的电子邮件。
	 * @return 新增用户的主键值
	 */
	int addClient(String name, String pass, boolean sex, String mail, String qq)throws MyException;

	/**
	 * 根据种类来获取相册列表
	 * @param kindId 需要获取的相册种类ID
	 * @param first 需要显示的第一个相册
	 * @param pageSize 每页显示的相册数量
	 * @return 查询到的相册列表
	 */
	List<AlbumVO> getAlbumsByKind(Integer kindId, int first, int pageSize)throws MyException;

	/**
	 * 获取指定相册分类下的相册数量
	 * @param kindId 需要查询的相册分类ID
	 * @return 指定相册分类下的相册数量
	 */
	int getAlbumCount(Integer kindId)throws MyException;

	/**
	 * 获取指定相册分类ID对应相册分类信息
	 * @param kindId 需要查询的相册分类ID
	 * @return 指定相册分类ID对应的相册分类信息
	 */
	KindVO getKind(Integer kindId)throws MyException;

	/**
	 * 根据相册获取该相册包含的相片。
	 * @param albumId 需要查询的相册ID
	 * @param first 需要显示的第一张相片
	 * @param pageCount 每页显示的相片数量
	 * @return 查询到该相册包含的全部相片。
	 */
	List<PhotoVO> getPhotos(Integer albumId, int first, int pageCount)throws MyException;

	/**
	 * 获取指定相册下包含相片数量
	 * @param albumId 指定相册的ID
	 * @return 该相册下包含的相片ID。
	 */
	int getCount(Integer albumId)throws MyException;
	/**
	 * 根据相册评论ID获取相片评论总数
	 * @param AlbumId 指定相册ID
	 * @return 该相册对应的相册评论总数。
	 */
	int getAlbumWordCount(Integer AlbumId)throws MyException;

	/**
	 * 根据指定AlbumId获取相册评论
	 * @param AlbumId 相册ID
	 * @param first需要显示的第一条评论
	 * @param pageSize 每页显示评论的大小
	 * @return 返回评论List
	 * @throws MyException
	 */
	List<AlbumWordVO> getAlbumWords(Integer AlbumId, int first, int pageSize)throws MyException;

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
	void addPhoto(String title, String desc, long times, String picUrl, String bigPicUrl, String smallPicUrl, 
		String date, boolean cover, Integer albumId)throws MyException;
	
	/**
	 * 判断指定ID对应的相片是否存在。
	 * @param 需要查询的相片ID
	 * @return 如果该ID对应的相片存在，返回true，否则返回false。
	 */
	boolean checkPhoto(Integer phId)throws MyException;
	/**
	 * 修改相片信息
	 */
	void updatePhoto(String name, String desc, Integer albumId, Integer phId)throws MyException;
	
	/**
	 * 更新点击数
	 * @param phId 更新点击相片的点击数
	 */
	void updatePhotoTimes(Integer phId)throws MyException;
	/**
	 * 删除指定相片
	 * @param 需要删除的相片ID
	 */
	void deletePhoto(int phId)throws MyException;

	/**
	 * 判断指定ID获取对应的相片
	 * @param 需要查询的相片ID
	 * @return 返回该ID对应的相片
	 */
	PhotoVO getPhoto(Integer phId)throws MyException;

	/**
	 * 获取指定相片的相片评论
	 * @param first 需要访问的第一张相片
	 * @param pageSize 每页显示的相片数量
	 * @return 根据指定页查询返回的相片评论。
	 */
	List<PhotoWordVO> getPhotoWords(Integer photoId, int first, int pageSize)throws MyException;

	/**
	 * 根据相片评论ID获取相片评论总数
	 * @param photoId 指定相片ID
	 * @return 该相片对应的相片评论总数。
	 */
	int getWordCount(Integer photoId)throws MyException;

	/**
	 * 获取相片所属于的相册分类
	 * @param photoId 需要查询的相片ID
	 * @return 指定相片对应的相册分类。
	 */
	KindVO getKindByPhoto(Integer photoId)throws MyException;
	/**
	 * 获取相册所属于的相册大类
	 * @param AlbumId 需要查询的相册ID
	 * @return 指定相册对应的相册大类。
	 */
	KindVO getKindByAlbum(Integer AlbumId)throws MyException;

	/**
	 * 获取系统中全部相册分类
	 * @return 系统包含的全部相册分类
	 */
	List<KindVO> getAllKind()throws MyException;
	
	/**
	 * 获得制定用户的相册
	 * @param cId
	 * @return
	 * @throws MyException
	 */
	List<AlbumVO> getMyAlbum(Integer cId)throws MyException;
	/** 
	 * 修改用户详细信息
	 * @param cId 用户的主键值。
	 * @param sex 用户的性别
	 * @param qq 用户的QQ号
	 * @param mail 用户的电子邮件
	 */
	void updateClient(Integer cId, boolean sex, String qq, String mail)throws MyException;

	/**
	 * 修改用户的密码
	 * @param id 需要修改的用户ID信息
	 * @param pass 需要修改的用户新密码
	 */
	void updateClient(Integer id, String pass)throws MyException;
}
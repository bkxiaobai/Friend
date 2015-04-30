package angus.dao;

import angus.model.Album;
import angus.model.Client;
import java.util.List;

public interface AlbumDao 
{
	/**
	 * 根据主键加载相册。
	 * @param id 需要加载的相册ID。
	 * @return 该主键对应的相册实体。
	 */
	Album get(Integer id);

	/**
	 * 保存特定的相册实体。
	 * @param album 需要保存的相册。
	 */
	void save(Album album);

	/**
	 * 修改特定的相册评论实体
	 * @param album 需要修改的相册
	 */
	void update(Album album);

	/**
	 * 根据主键删除相册
	 * @param id 需要删除的相册ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的相册。
	 * @param album 需要删除的相册
	 */
	void delete(Album album);

	/**
	 * 分页获取指定用户的全部相册。
	 * @param client 指定的用户。
	 * @param first 指定页需显示的第一个相册。
	 * @pram pageSize 页面中显示的相册数。
	 * @return 获取指定页的全部相册列表。
	 */
	List<?> getAllByClient(final Client client, final int first, final int pageSize);
	/**
	 * 获取指定用户的全部相册 
	 * @param client
	 * @return
	 */
	List<?> getAllByClient(final Client client);
	/**
	 * 获取指定用户的相册数量
	 * @return 返回指定用户的相册数量
	 */
	int getAmount(Client client);
}

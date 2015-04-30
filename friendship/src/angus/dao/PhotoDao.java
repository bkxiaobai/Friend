package angus.dao;

import angus.model.Photo;
import angus.model.Album;
import java.util.List;

public interface PhotoDao
{
	/**
	 * 根据主键加载相片。
	 * @param id 需要加载的相片ID。
	 * @return 该主键对应的相片实体。
	 */
	Photo get(Integer id);

	/**
	 * 保存特定的相片实体。
	 * @param photo 需要保存的相片。
	 */
	void save(Photo photo);

	/**
	 * 修改特定的相册评论实体
	 * @param photo 需要修改的相片
	 */
	void update(Photo photo);

	/**
	 * 根据主键删除相片
	 * @param id 需要删除的相片ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的相片。
	 * @param photo 需要删除的相片
	 */
	void delete(Photo photo);

	/**
	 * 获取指定相册的封面相片ID。
	 * @param al 指定相册。
	 * @flag 相片是否为相册封面的旗标。
	 * @return 指定相册的封面ID。
	 */
	Integer getCover(Album al, boolean flag);

	/**
	 * 获取指定相册的指定页的相片列表
     * @param al 指定的相册。
	 * @param first 指定相册需要显示的第一张相片
	 * @param pageSize 每页显示的相片数量
	 * @return 特定页所显示的相片列表
	 */
	List<Photo> getPhotos(final Album al, final int first, final int pageSize);

	/**
	 * 显示该相册的浏览次数
	 * @param 指定的相册
	 * @return 该相册的浏览次数
	 */
	int getCount(Album al);

	/**
	 * 获取指定相册的封面相片。
	 * @param al 指定相册。
	 * @flag 相片是否为相册封面的旗标。
	 * @return 指定相册的封面。
	 */
	Photo getCoverPhoto(Album al, boolean flag);
}

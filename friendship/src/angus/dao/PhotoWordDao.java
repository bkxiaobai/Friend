package angus.dao;

import angus.model.Photo;
import angus.model.PhotoWord;
import java.util.List;

public interface PhotoWordDao
{
	/**
	 * 根据主键加载相片评论。
	 * @param id 需要加载的相片评论ID。
	 * @return 该主键对应的相片评论实体。
	 */
	PhotoWord get(Integer id);

	/**
	 * 保存特定的相片评论实体。
	 * @param photoWord 需要保存的相片评论。
	 */
	void save(PhotoWord photoWord);

	/**
	 * 修改特定的相册评论实体
	 * @param photoWord 需要修改的相片评论
	 */
	void update(PhotoWord photoWord);

	/**
	 * 根据主键删除相片评论
	 * @param id 需要删除的相片评论ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的相片评论。
	 * @param photoWord 需要删除的相片评论
	 */
	void delete(PhotoWord photoWord);

	/**
	 * 查询指定相片的特定页的相片评论。
	 * @param photo 需要获取相片评论的指定相片
	 * @param first 需要获取的第一条相片评论。
	 * @praam pageSize 每页显示的相片数量。
	 * @return 该主键对应的相片实体。
	 */
	List<PhotoWord> getPhotoWordByPhoto(Photo photo, int first, int pageSize);

	/**
	 * 返回指定相片的访问次数
	 * @param photo 需要获取访问次数的指定相片
	 * @return 指定相片对应的访问次数。
	 */
	int getCount(Photo photo);
}

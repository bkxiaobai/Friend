package angus.dao;

import java.util.List;

import angus.model.Album;
import angus.model.AlbumWord;

public interface AlbumWordDao  
{
	/**
	 * 根据主键加载相册评论。
	 * @param id 需要加载的相册评论ID。
	 * @return 该主键对应的相册评论。
	 */
	AlbumWord get(Integer id);

	/**
	 * 保存特定的相册评论实体。
	 * @param albumWord 需要保存的相册评论。
	 */
	void save(AlbumWord albumWord);

	/**
	 * 修改特定的相册评论实体
	 * @param albumWord 需要修改的相册评论
	 */
	void update(AlbumWord albumWord);

	/**
	 * 根据主键删除相册评论
	 * @param id 需要删除的相册评论ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的相册评论。
	 * @param albumWord 需要删除的相册评论
	 */
	void delete(AlbumWord albumWord);
	/**
	 * 获取指定ID的评论
	 * @param album
	 * @param first
	 * @param pageSize
	 * @return
	 */
	List<AlbumWord> getAlbumWordByPhoto(final Album album, final int first, final int pageSize);
	/**
	 * 获取相册下的
	 * @param album
	 * @return
	 */
	int getCount(Album album);

}

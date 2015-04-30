package angus.dao;

import angus.model.Kind;
import angus.model.Album;
import java.util.List;

public interface KindDao
{
	/**
	 * 根据主键加载相册分类。
	 * @param id 需要加载的相册分类ID。
	 * @return 该主键对应的相册分类。
	 */
	Kind get(Integer id);

	/**
	 * 保存特定的相册分类实体。
	 * @param kind 需要保存的相册分类。
	 */
	void save(Kind kind);

	/**
	 * 修改特定的相册评论实体
	 * @param kind 需要修改的相册分类
	 */
	void update(Kind kind);

	/**
	 * 根据主键删除相册分类
	 * @param id 需要删除的相册分类ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的相册分类。
	 * @param kind 需要删除的相册分类
	 */
	void delete(Kind kind);

	/**
	 * 获取全部的相册分类
	 * return 该系统中全部的相册分类。
	 */
	List<Kind> getAll();

	/**
	 * 分页显示指定相册分类的相册列表
	 * @param kind 指定的相册分类。
	 * @param first 需要显示的第一个相册。
	 * @param pageSize 每页显示的相册数量。
	 * @return 指定的相册分类。
	 */
	List<Album> getAllByKind(final Kind kind, final int first, final int pageSize);


	/**
	 * 获取指定相册分类的相册数量
	 * @param kind 指定的相册分类。
	 * @return 指定的相册分类。
	 */
	int getAmount(Kind kind);
}

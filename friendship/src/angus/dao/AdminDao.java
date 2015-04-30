package angus.dao;

import angus.model.Admin;

public interface AdminDao
{
	/**
	 * 根据主键加载管理员。
	 * @param id 需要加载的管理员ID。
	 * @return 该主键对应的管理员。
	 */
	Admin get(Integer id);

	/**
	 * 保存特定的管理员实体。
	 * @param admin 需要保存的管理员。
	 */
	void save(Admin admin);

	/**
	 * 修改特定的相册评论实体
	 * @param admin 需要修改的管理员
	 */
	void update(Admin admin);

	/**
	 * 根据主键删除管理员
	 * @param id 需要删除的管理员ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的管理员。
	 * @param admin 需要删除的管理员
	 */
	void delete(Admin admin);

	/**
	 * 根据管理员名和密码查询管理员。
	 * @param name 需要查询管理员的管理员名。
	 * @param pass 需要查询管理员的密码。
	 * @return 指定管理员名和密码对应管理员的主键值。
	 */
	Integer findByNameAndPass(String name, String pass);
}

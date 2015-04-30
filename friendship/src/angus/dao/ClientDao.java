package angus.dao;

import angus.model.Client;

public interface ClientDao  
{
	/**
	 * 根据主键加载相片评论。
	 * @param id 需要加载的相片评论ID。
	 * @return 该主键对应的用户。
	 */
	Client get(Integer id);

	/**
	 * 保存特定的相片评论实体。
	 * @param photoWord 需要保存的相册评论。
	 */
	void save(Client client);

	/**
	 * 修改特定的相册评论实体
	 * @param photoWord 需要修改的相片评论
	 */
	void update(Client client);

	/**
	 * 根据主键删除相片评论
	 * @param id 需要删除的相片评论ID。
	 */
	void delete(int id);

	/**
	 * 删除指定的相片评论。
	 * @param photoWord 需要删除的相片评论
	 */
	void delete(Client client);

	/**
	 * 根据用户名和密码查询用户。
	 * @param name 需要查询用户的用户名。
	 * @param pass 需要查询用户的密码。
	 * @return 指定用户名和密码对应用户的主键值。
	 */
	Integer findByNameAndPass(String name, String pass);

	/**
	 * 根据用户名查询用户。
	 * @param name 需要查询用户的用户名。
	 * @return 指定用户名对应用户的主键值。
	 */
	Integer findByName(String name);
}

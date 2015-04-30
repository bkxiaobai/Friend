package angus.service.root;

import angus.exception.MyException;
import angus.vo.AdminVO;

public interface AdminService  
{
	AdminVO checkAdmin(String name, String pass)throws MyException;

	void addKind(String kindName, String desc)throws MyException;

	void updateKind(Integer kindId, String name)throws MyException;
}

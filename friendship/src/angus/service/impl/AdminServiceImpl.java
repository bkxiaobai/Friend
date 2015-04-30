package angus.service.impl;

import angus.exception.MyException;

import angus.service.root.AdminService;
import angus.dao.AdminDao;
import angus.dao.KindDao;
import angus.model.Admin;
import angus.model.Kind;
import angus.vo.AdminVO;

public class AdminServiceImpl implements AdminService
{
	private AdminDao ad;

	private KindDao kd;

	public void setAd(AdminDao ad)
	{
		this.ad = ad;
	}


	public void setKd(KindDao kd)
	{
		this.kd = kd;
	}

	public AdminVO checkAdmin(String name, String pass)throws MyException
	{
		try
		{
			Integer adminId = ad.findByNameAndPass(name, pass);
			Admin admin = ad.get(adminId);
			if (admin == null)
			{
				return null;
			}
			return fillAdminVO(admin);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException("登录异常");
		}
	}
	public void addKind(String kindName, String desc)throws MyException
	{
		try
		{
			Kind kind = new Kind(kindName, desc);
			kd.save(kind);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException("添加种类异常");
		}
	}

	public void updateKind(Integer kindId, String name)throws MyException
	{
		try
		{
			Kind kind = kd.get(kindId);
			kind.setName(name);
			kd.save(kind);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MyException("修改种类信息异常");
		}
	}

	private AdminVO fillAdminVO(Admin admin)throws Exception
	{
		AdminVO avo = new AdminVO(admin.getId(), admin.getName());
		return avo;
	}
}

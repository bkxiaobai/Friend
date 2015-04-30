package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import angus.exception.MyException;
import angus.service.root.ClientService;

public class DelAlbumAction extends Action
{

	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer albumId = Integer.valueOf(request.getParameter("albumId"));
		if (cs.checkAlbum(albumId) == false)
		{
			request.setAttribute("noexist", "你要删除的相册不存在");
			return mapping.findForward("noexist");
		}
		if(cs.checkHavePhotos(albumId))throw new MyException("请先把相册内相片全部删除!");
		cs.deleteAlbum(albumId.intValue());
		request.setAttribute("success", "删除相册成功");
		return mapping.findForward("success");
	}
}

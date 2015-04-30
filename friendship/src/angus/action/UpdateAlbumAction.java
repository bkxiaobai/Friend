package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;

public class UpdateAlbumAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm updateAlbumForm = (DynaActionForm)form;
		Integer albumId = Integer.valueOf((String)updateAlbumForm.get("albumId"));
		String name = (String)updateAlbumForm.get("name");
		Integer kindId = Integer.valueOf((String)updateAlbumForm.get("kind"));
		String desc = (String)updateAlbumForm.get("desc");
		if (cs.checkAlbum(albumId) == false)
		{
			request.setAttribute("noexist", "你所要修改的相册不存在");
			return mapping.findForward("noexist");
		}
		cs.updateAlbum(name, desc, kindId, albumId);
		AlbumVO avo = cs.getClientAlbum(albumId);
		request.setAttribute("album", avo);
		request.setAttribute("success", "修改相册信息成功");
		return mapping.findForward("success");
	}
}

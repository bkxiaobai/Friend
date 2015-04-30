package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;

public class ViewAlbumInfoAction extends Action
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
		AlbumVO avo = cs.getClientAlbum(albumId);
		if (avo == null)
		{
			request.setAttribute("noexist", "你所要查看的相册不存在");
			return mapping.findForward("noexist");
		}
		request.setAttribute("album", avo);
		return mapping.findForward("success");
	}
}

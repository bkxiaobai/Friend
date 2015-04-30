package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;

public class ChangeCoverAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		HttpSession session = request.getSession();
		AlbumVO avo = (AlbumVO)session.getAttribute("albumInfo");
		Integer albumId = Integer.valueOf(avo.getId());
		Integer photoId = Integer.parseInt(request.getParameter("photoId"));
		cs.setCover(albumId, photoId);
		request.setAttribute("success", "设置相册封面成功");
		return mapping.findForward("success");
	}
}

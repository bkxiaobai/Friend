package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.tools.page.PageConst;
import angus.vo.PhotoVO;
import angus.vo.AlbumVO;
import angus.service.root.ClientService;

public class ViewAlbumClientAction extends Action
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
		List<PhotoVO> pvos = cs.getPhotos(albumId, PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(cs.getCount(albumId), 1);
		AlbumVO avo = cs.getAlbum(albumId);
		request.setAttribute("album", avo);
		request.setAttribute("photos", pvos);
		request.setAttribute("page", pc);
		return mapping.findForward("get");
	}
}

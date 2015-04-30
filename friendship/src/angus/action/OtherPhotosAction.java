package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import angus.service.root.ClientService;
import angus.tools.page.PageConst;
import angus.vo.PhotoVO;
import angus.vo.AlbumVO;

public class OtherPhotosAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm pageForm = (DynaActionForm)form;
		int currentPage = Integer.parseInt((String)pageForm.get("currentPage"));
		Integer albumId = Integer.valueOf((String)pageForm.get("albumId"));
		PageConst pc = new PageConst(cs.getCount(albumId), currentPage);
		List<PhotoVO> pvos = cs.getPhotos(albumId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		AlbumVO avo = cs.getAlbum(albumId);
		request.setAttribute("album", avo);
		request.setAttribute("photos", pvos);
		request.setAttribute("page", pc);
		return mapping.findForward("success");
	}
}

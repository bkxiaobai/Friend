package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import angus.vo.PhotoVO;
import angus.tools.page.PageConst;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;

public class PhotoPageAction extends Action
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
		HttpSession session = request.getSession();
		AlbumVO avo = (AlbumVO)session.getAttribute("albumInfo");
		Integer albumId = new Integer(avo.getId());
		int currentPage = getCurrentPage(pageForm);
		PageConst pc = new PageConst(cs.getCount(albumId), currentPage);
		List<PhotoVO> pvos = cs.getPhotos(albumId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		request.setAttribute("page", pc);
		request.setAttribute("photos", pvos);
		return mapping.findForward("success");
	}

	private int getCurrentPage(DynaActionForm pageForm)
	{
		int currentPage = 1;
		try
		{
			currentPage = Integer.parseInt((String)pageForm.get("currentPage"));
		}
		catch (Exception e)
		{
			currentPage = 1;
		}
		return currentPage;
	}
}

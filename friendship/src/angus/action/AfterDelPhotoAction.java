package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.service.root.ClientService;
import angus.vo.PhotoVO;
import angus.vo.AlbumVO;
import angus.tools.page.PageConst;

public class AfterDelPhotoAction extends Action
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
		List<PhotoVO> pvos = cs.getPhotos(new Integer(avo.getId()), PageConst.FIRST, PageConst.PAGE_SIZE);
		request.setAttribute("photos", pvos);
		PageConst pc = new PageConst(cs.getCount(new Integer(avo.getId())), 1);
		request.setAttribute("page", pc);
		return mapping.findForward("success");
	}
}

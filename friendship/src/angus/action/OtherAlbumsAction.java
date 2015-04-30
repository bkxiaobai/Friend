package angus.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import angus.service.root.ClientService;
import angus.tools.page.PageConst;
import angus.vo.AlbumVO;
import angus.vo.KindVO;

public class OtherAlbumsAction extends Action 
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
		KindVO kvo = (KindVO)request.getSession().getAttribute("kind");
		Integer kindId = Integer.valueOf(kvo.getId());
		int currentPage = Integer.parseInt((String)pageForm.get("currentPage"));
		int rsCount = cs.getAlbumCount(kindId);
		PageConst pc = new PageConst(rsCount, currentPage);
		List<AlbumVO> avos = cs.getAlbumsByKind(kindId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("get");
	}
}

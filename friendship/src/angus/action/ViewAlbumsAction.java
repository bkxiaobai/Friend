package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.vo.AlbumVO;
import angus.vo.KindVO;
import angus.tools.page.PageConst;
import angus.service.root.ClientService;

public class ViewAlbumsAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer kindId = Integer.valueOf(request.getParameter("kindId"));
		List<AlbumVO> avos = cs.getAlbumsByKind(kindId, PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(cs.getAlbumCount(kindId), 1);
		KindVO kvo = cs.getKind(kindId);
		request.getSession().setAttribute("kind", kvo);
		request.setAttribute("kind", kvo);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("get");
	}
}

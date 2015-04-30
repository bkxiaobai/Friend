package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.vo.AlbumVO;
import angus.vo.ClientVO;
import angus.service.root.ClientService;
import angus.tools.page.PageConst;

public class AlbumListAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		ClientVO cvo = (ClientVO)request.getSession().getAttribute("clientInfo");
		int cId = cvo.getId();
		List<AlbumVO> avos = cs.getClientAlbums(cId , PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(cs.getAlbumCount(cId), 1);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
		return mapping.findForward("success");
	}
}

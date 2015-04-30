package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import angus.tools.page.PageConst;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;
import angus.vo.ClientVO;


public class AlbumPageAction extends Action
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
		DynaActionForm pageForm = (DynaActionForm)form;
		int currentPage = getCurrentPage(pageForm);
		PageConst pc = new PageConst(cs.getAlbumCount(cId), currentPage);
		List<AlbumVO> avos = cs.getClientAlbums(cId , pc.getPageFirst(), PageConst.PAGE_SIZE);
		request.setAttribute("page", pc);
		request.setAttribute("albums", avos);
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

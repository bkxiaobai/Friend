package angus.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import angus.service.root.ClientService;
import angus.vo.KindVO;

public class IndexAction extends Action
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
		List<KindVO> kinds = cs.getAllKind();
		session.setAttribute("kinds", kinds);
		return mapping.findForward("success");
	}
}

package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import angus.vo.ClientVO;

public class CommentLinkAtion extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO)session.getAttribute("clientInfo");
		if (cvo == null)
		{
			System.out.println(request.getQueryString());
			System.out.println(request.getRequestURL());
			System.out.println(request.getRequestURI());
			System.out.println("没有登录");
		}
		else
		{
			System.out.println("已经登录了");
		}
		return mapping.findForward("login");
	}
}

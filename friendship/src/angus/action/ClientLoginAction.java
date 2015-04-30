package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.service.root.ClientService;
import angus.vo.ClientVO;

public class ClientLoginAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm clientLoginForm = (DynaActionForm)form;
		String name = (String)clientLoginForm.get("name");
		String pass = (String)clientLoginForm.get("pass");
		String code = (String)clientLoginForm.get("code");
		String rCode = (String)request.getSession().getAttribute("checkCode");
		HttpSession session = request.getSession();
		int cId = 0;
		if (code.equals(rCode))
		{
			if ((cId = cs.checkClient(name, pass)) <= 0)
			{
				request.setAttribute("name", name);
				request.setAttribute("wrong", "用户名或者密码错误");
				return mapping.findForward("wrong");
			}
			else
			{
				ClientVO cvo = cs.getClientInfo(cId);
				request.getSession().setAttribute("clientInfo", cvo);
				String url = (String)session.getAttribute("clientUrl");
				if (url == null)
				{
					return mapping.findForward("success");
				}
				else
				{
					ActionForward af = new ActionForward(url);
					return af;
				}
			}
		}
		else
		{
			request.setAttribute("name", name);
			request.setAttribute("wrongCode", "请输入正确的验证码");
			return mapping.findForward("wrongCode");
		}
	}
}

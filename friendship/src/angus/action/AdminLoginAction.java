package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.service.root.AdminService;
import angus.vo.AdminVO;

public class AdminLoginAction extends Action
{
	private AdminService as;

	public void setAs(AdminService as)
	{
		this.as = as;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm adminLoginForm = (DynaActionForm)form;
		String name = (String)adminLoginForm.get("userName");
		String pass = (String)adminLoginForm.get("pass");
		String code = (String)adminLoginForm.get("code");
		String wrightCode = (String)request.getSession().getAttribute("checkCode");
		if (wrightCode.equals(code))
		{
			AdminVO avo = as.checkAdmin(name, pass);
			if (avo == null)
			{
				request.setAttribute("wrong", "用户名或密码错误");
				return mapping.findForward("wrong");
			}
			else
			{
				request.getSession().setAttribute("adminInfo", avo);
				return mapping.findForward("success");
			}
		}
		request.setAttribute("wrongCode", "请输入正确的验证码");
		return mapping.findForward("wrongCode");
	}
}

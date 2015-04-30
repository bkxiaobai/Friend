package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.vo.ClientVO;
import angus.service.root.ClientService;

public class UpdatePassAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm updatePassForm = (DynaActionForm)form;
		String old = (String)updatePassForm.get("old");
		String newPass = (String)updatePassForm.get("newPass");
		ClientVO cvo = (ClientVO)request.getSession().getAttribute("clientInfo");
		if (old.equals(cvo.getPass()))
		{
			cs.updateClient(cvo.getId(), newPass);
			request.setAttribute("success", "修改密码成功,请重新登录");
			return mapping.findForward("success");
		}
		request.setAttribute("noSame", "修改失败,输入的旧密码有误");
		return mapping.findForward("fail");
	}
}

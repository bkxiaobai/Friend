package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.service.root.ClientService;

public class CheckClientNameAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm checkNameForm = (DynaActionForm)form;
		String name = (String)checkNameForm.get("userName");
		request.setAttribute("name", name);
		if (cs.checkName(name) == false)
		{
			request.setAttribute("success", "���û�������");
			return mapping.findForward("success");
		}
		request.setAttribute("have", "���û��Ѿ���ע��,����������");
		return mapping.findForward("have");
	}
}

package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import angus.service.root.AdminService;
import angus.service.root.ClientService;
import angus.vo.KindVO;

public class AddKindAction extends Action
{
	private AdminService as;

	private ClientService cs;

	public void setAs(AdminService as)
	{
		this.as = as;
	}

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm addKindForm = (DynaActionForm)form;
		String name = (String)addKindForm.get("name");
		as.addKind(name, null);
		List<KindVO> kvos = cs.getAllKind();
		request.getSession().setAttribute("kinds", kvos);
		request.setAttribute("success", "添加种类成功");
		return mapping.findForward("success");
	}
}

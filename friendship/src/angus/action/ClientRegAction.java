package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.io.File;
import angus.service.root.ClientService;
import angus.tools.weburl.WebUrl;

public class ClientRegAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm clientRegForm = (DynaActionForm)form;
		String sex = (String)clientRegForm.get("sex");
		String name = (String)clientRegForm.get("name");
		String pass = (String)clientRegForm.get("pass");
		String qq = (String)clientRegForm.get("qq");
		String mail = (String)clientRegForm.get("mail");
		String code = (String)clientRegForm.get("code");
		String rCode = (String)request.getSession().getAttribute("checkCode");
		request.setAttribute("name", name);
		boolean newSex = true;
		if (code.equals(rCode) == false)
		{
			request.setAttribute("wrongCode", "�������֤����,����������");
			return mapping.findForward("wrongCode");
		}
		else
		{
			if (cs.checkName(name) == true)
			{

				request.setAttribute("have", "����ע����û����Ѿ�����, �뻻���û���");
				return mapping.findForward("have");
			}
			else
			{
				if (sex.equals("man"))
				{
					newSex = true;
				}
				else
				{
					newSex = false;
				}
				String path = WebUrl.DATA_URL;
				int cid = cs.addClient(name, pass, newSex, mail, qq);
				File userPath = new File(path + cid);
				userPath.mkdir();
				request.setAttribute("success", "ע��ɹ�, ���¼");
				return mapping.findForward("success");
			}
		}
	}
}

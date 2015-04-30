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

public class UpdateClientInfoAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm updateInfoForm = (DynaActionForm)form;
		HttpSession session = request.getSession();
		String sex = (String)updateInfoForm.get("sex");
		String qq = (String)updateInfoForm.get("qq");
		String mail = (String)updateInfoForm.get("mail");
		String code = (String)updateInfoForm.get("code");
		String rCode = (String)session.getAttribute("checkCode");
		if (code.equals(rCode) == false)
		{
			request.setAttribute("wrongCode", "你输入的验证码有误");
			return mapping.findForward("wrongCode");
		}
		ClientVO cvo = (ClientVO)session.getAttribute("clientInfo");
		boolean newSex = true;
		if (sex.equals("man"))
		{
			newSex = true;
		}
		else
		{
			newSex = false;
		}
		cs.updateClient(cvo.getId(), newSex, qq, mail);
		cvo.setSex(newSex);
		cvo.setMail(mail);
		cvo.setQq(qq);
		session.setAttribute("clientInfo", cvo);
		request.setAttribute("success", "修改资料成功");
		return mapping.findForward("success");
	}
}

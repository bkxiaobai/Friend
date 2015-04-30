package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.service.root.ClientService;
import angus.vo.ClientVO;
import angus.tools.date.DateUtil;

public class AddAlbumCommentAction extends Action
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
		DynaActionForm commentForm = (DynaActionForm)form;
		String title = (String)commentForm.get("title");
		String content = (String)commentForm.get("content");
		String addTime = DateUtil.getFormalTime();
		Integer albumId = Integer.valueOf((String)commentForm.get("albumId"));
		Integer clientId = Integer.valueOf(cvo.getId());
		cs.addAlbumWord(title, content, addTime, albumId, clientId);
		ActionForward af = new ActionForward("/seealbumcomment.do?albumId=" + String.valueOf(albumId));
		return af;
	}
}

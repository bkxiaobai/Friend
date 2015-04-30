package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.tools.date.DateUtil;
import angus.service.root.ClientService;
import angus.vo.ClientVO;

public class AddAlbumAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}
	/**
	 * yanghang 20090515
	 * ActionMapping就是用来描述一个Action的URL、具体实现的文件、相对应的ActionForm
       数据属性(request or session)、是否需要进行数据校验和回写、以及处理完成后可能
       跳转的URL.
       而ActionForward你就可以理解为Action 操作完成后的跳转URL,Action在处理完相关操作后
       返回的是一个ActionForward也就是告诉Struts我做完这个操作下一步到哪儿去。
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm addAlbumForm = (DynaActionForm)form;
		String name = (String)addAlbumForm.get("name");
		Integer kindId = Integer.valueOf((String)addAlbumForm.get("kind"));
		String desc = (String)addAlbumForm.get("desc");
		ClientVO cvo = (ClientVO)request.getSession().getAttribute("clientInfo");
		Integer cId = new Integer(cvo.getId());
		cs.addAlbum(name, desc, DateUtil.getFormalTime(), 0, cId, kindId);
		return mapping.findForward("success");
	}
}

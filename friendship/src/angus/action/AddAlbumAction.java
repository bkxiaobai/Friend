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
	 * ActionMapping������������һ��Action��URL������ʵ�ֵ��ļ������Ӧ��ActionForm
       ��������(request or session)���Ƿ���Ҫ��������У��ͻ�д���Լ�������ɺ����
       ��ת��URL.
       ��ActionForward��Ϳ������ΪAction ������ɺ����תURL,Action�ڴ�������ز�����
       ���ص���һ��ActionForwardҲ���Ǹ���Struts���������������һ�����Ķ�ȥ��
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

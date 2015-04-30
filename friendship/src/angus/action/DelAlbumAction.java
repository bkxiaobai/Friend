package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import angus.exception.MyException;
import angus.service.root.ClientService;

public class DelAlbumAction extends Action
{

	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer albumId = Integer.valueOf(request.getParameter("albumId"));
		if (cs.checkAlbum(albumId) == false)
		{
			request.setAttribute("noexist", "��Ҫɾ������᲻����");
			return mapping.findForward("noexist");
		}
		if(cs.checkHavePhotos(albumId))throw new MyException("���Ȱ��������Ƭȫ��ɾ��!");
		cs.deleteAlbum(albumId.intValue());
		request.setAttribute("success", "ɾ�����ɹ�");
		return mapping.findForward("success");
	}
}

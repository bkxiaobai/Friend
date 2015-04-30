package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import angus.service.root.ClientService;
import angus.tools.file.Upload;
import angus.vo.PhotoVO;


public class DelPhotoAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer phId = Integer.valueOf(request.getParameter("photoId"));

		if (cs.checkPhoto(phId) == false)
		{
			request.setAttribute("noexist", "你要删除的照片不存在");
			return mapping.findForward("noexist");
		}
		PhotoVO pvo = cs.getPhoto(phId);
		String picUrl = pvo.getPicUrl();
		String bigPicUrl = pvo.getBigPicUrl();
		String smallPicUrl = pvo.getSmallPicUrl();
		Upload up = new Upload();
		up.deleteImage(picUrl, bigPicUrl, smallPicUrl, request.getSession().getServletContext().getRealPath(""));
		cs.deletePhoto(phId.intValue());
		
		request.setAttribute("success", "删除照片成功");
		return mapping.findForward("success");
	}
}

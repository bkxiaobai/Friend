
package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import angus.service.root.ClientService;
import angus.vo.PhotoVO;

public class UpdatePhotoAction  extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm updatePhotoForm = (DynaActionForm)form;
		Integer photoId = Integer.valueOf((String)updatePhotoForm.get("photoId"));
		String name = (String)updatePhotoForm.get("name");
		Integer albumId = Integer.valueOf((String)updatePhotoForm.get("album"));
		String desc = (String)updatePhotoForm.get("desc");
		if (cs.checkPhoto(photoId) == false)
		{
			request.setAttribute("noexist", "你所要修改的相片不存在");
			return mapping.findForward("noexist");
		}
		cs.updatePhoto(name, desc, albumId, photoId);
		PhotoVO pvo = cs.getPhoto(photoId);
		request.setAttribute("photo", pvo);
		request.setAttribute("success", "修改相册信息成功");
		return mapping.findForward("success");
	}
}


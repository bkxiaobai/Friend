
package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;
import angus.vo.PhotoVO;


public class ViewPhotoInfoAction  extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{

		Integer cId = Integer.valueOf(request.getParameter("cId"));
		Integer photoId = Integer.valueOf(request.getParameter("photoId"));
		PhotoVO pvo = cs.getPhoto(photoId);
		if (pvo == null)
		{
			request.setAttribute("noexist", "你所要查看的相册不存在");
			return mapping.findForward("noexist");
		}
		try
		{
			//HttpSession session = request.getSession();
			List<AlbumVO> albums = cs.getMyAlbum(cId);
			request.getSession().setAttribute("albums", albums);
			request.setAttribute("photo", pvo);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mapping.findForward("success");
	}
}

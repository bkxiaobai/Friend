package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.vo.PhotoVO;
import angus.tools.page.PageConst;
import angus.service.root.ClientService;
import angus.vo.AlbumVO;

public class ViewPhotosAction extends Action
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
		
		//修改点击数
		if (cs.checkAlbum(albumId) == false)
		{
			request.setAttribute("noexist", "你所要修改的相册不存在");
			return mapping.findForward("noexist");
		}
		cs.updateTimes(albumId);
		AlbumVO avo = cs.getClientAlbum(albumId);
		List<PhotoVO> pvos = cs.getPhotos(new Integer(avo.getId()), PageConst.FIRST, PageConst.PAGE_SIZE);
		PageConst pc = new PageConst(cs.getCount(new Integer(avo.getId())), 1);
		request.getSession().setAttribute("albumInfo", avo);
		request.setAttribute("page", pc);
		request.setAttribute("photos", pvos);
		return mapping.findForward("success");
	}
}

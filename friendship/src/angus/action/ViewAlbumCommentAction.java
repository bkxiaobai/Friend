package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;

import angus.vo.AlbumVO;
import angus.vo.AlbumWordVO;
import angus.vo.KindVO;
import angus.service.root.ClientService;
import angus.tools.page.PageConst;

public class ViewAlbumCommentAction extends Action
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
			request.setAttribute("noexist", "你要查看相册不存在");
			return mapping.findForward("noexist");
		}
		request.getSession().setAttribute("albumId",albumId);
		List<AlbumWordVO> awvos = cs.getAlbumWords(albumId, PageConst.FIRST, PageConst.PAGE_SIZE);
		int rsCount = cs.getAlbumWordCount(albumId);
		PageConst pc = new PageConst(rsCount, 1);
		if (awvos.size() == 0)
		{
			request.setAttribute("nohave", "暂无评论");
		}
		else
		{
			request.setAttribute("awvo", awvos);
		}
		AlbumVO avo = cs.getAlbum(albumId);
		KindVO kvo = cs.getKindByAlbum(albumId);
		request.setAttribute("page", pc);
		request.setAttribute("album", avo);
		request.setAttribute("kind", kvo);
		return mapping.findForward("success");
	}
}

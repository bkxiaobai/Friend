package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import java.util.List;
import angus.vo.KindVO;
import angus.vo.PhotoVO;
import angus.vo.PhotoWordVO;
import angus.service.root.ClientService;
import angus.tools.page.PageConst;

public class ViewPhotoClientAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Integer photoId = Integer.valueOf(request.getParameter("photoId"));
		if (cs.checkPhoto(photoId) == false)
		{
			request.setAttribute("noexist", "��Ҫ�鿴��Ƭ������");
			return mapping.findForward("noexist");
		}
		request.getSession().setAttribute("photoId", photoId);
		List<PhotoWordVO> pwvos = cs.getPhotoWords(photoId, PageConst.FIRST, PageConst.PAGE_SIZE);
		int rsCount = cs.getWordCount(photoId);
		PageConst pc = new PageConst(rsCount, 1);
		if (pwvos.size() == 0)
		{
			request.setAttribute("nohave", "��������");
		}
		else
		{
			request.setAttribute("pwvo", pwvos);
		}
		PhotoVO pvo = cs.getPhoto(photoId);
		KindVO kvo = cs.getKindByPhoto(photoId);
		request.setAttribute("page", pc);
		request.setAttribute("photo", pvo);
		request.setAttribute("kind", kvo);
		return mapping.findForward("success");
	}
}

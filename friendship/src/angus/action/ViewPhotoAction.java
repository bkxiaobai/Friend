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

public class ViewPhotoAction extends Action
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
			request.setAttribute("noexist", "你要查看照片不存在");
			return mapping.findForward("noexist");
		}
		//修改点击数
		cs.updatePhotoTimes(phId);
		
		List<PhotoWordVO> pwvos = cs.getPhotoWords(phId, 1, 1);
		//System.out.println(pwvos.size());
		int rsCount = cs.getWordCount(phId);
		PageConst pc = new PageConst(rsCount, 1);
		
		if (pwvos.size() == 0)
		{
			request.setAttribute("nohave", "暂无评论");
		}
		else
		{
			PhotoWordVO pwvo = pwvos.get(0);
			request.setAttribute("pwvo", pwvo);
		}
		PhotoVO pvo = cs.getPhoto(phId);
		KindVO kvo = cs.getKindByPhoto(phId);

		request.setAttribute("page", pc);
		request.setAttribute("photo", pvo);
		request.setAttribute("kind", kvo);
		return mapping.findForward("success");
	}
}

package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.List;
import angus.service.root.ClientService;
import angus.vo.PhotoVO;
import angus.vo.PhotoWordVO;
import angus.vo.KindVO;
import angus.tools.page.PageConst;

public class OtherPhotoWordAction extends Action
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm photoWordPageForm = (DynaActionForm)form;
		Integer photoId = Integer.valueOf((String)photoWordPageForm.get("photoId"));
		int currentPage = Integer.parseInt((String)photoWordPageForm.get("currentPage"));
		int rsCount = cs.getWordCount(photoId);
		PageConst pc = new PageConst(rsCount, currentPage);
		List<PhotoWordVO> pwvos = cs.getPhotoWords(photoId, pc.getPageFirst(), PageConst.PAGE_SIZE);
		PhotoVO pvo = cs.getPhoto(photoId);
		KindVO kvo = cs.getKindByPhoto(photoId);
		request.setAttribute("pwvo", pwvos);
		request.setAttribute("page", pc);
		request.setAttribute("photo", pvo);
		request.setAttribute("kind", kvo);
		return mapping.findForward("success");
	}
}

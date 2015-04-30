package angus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import angus.vo.ClientVO;
import angus.vo.AlbumVO;
import angus.tools.date.DateUtil;
import angus.tools.weburl.WebUrl;
import angus.tools.file.Upload;
import angus.service.root.ClientService;

public class AddPhotoAction extends Action 
{
	private ClientService cs;

	public void setCs(ClientService cs)
	{
		this.cs = cs;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		DynaActionForm addPhotoForm = (DynaActionForm)form;
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO)session.getAttribute("clientInfo");
		AlbumVO avo = (AlbumVO)session.getAttribute("albumInfo");
		Integer albumId = Integer.valueOf(avo.getId());
		int clientId = cvo.getId();
		String clientPath = WebUrl.DATA_URL + String.valueOf(clientId);
		String path = WebUrl.NEW_DATA_URL + String.valueOf(clientId);
		System.out.println(clientPath);
		
		String name = (String)addPhotoForm.get("name");
		FormFile file = (FormFile)addPhotoForm.get("image");
		String desc = (String)addPhotoForm.get("desc");
		try
		{
			String fileName = file.getFileName();
			String suffix = fileName.substring(fileName.indexOf("."));
			System.out.println(suffix);
			if (checkImage(suffix) == false)
			{
				request.setAttribute("wrongType", "上传类型错误,请重新上传");
				return mapping.findForward("wrongType");
			}
			if (checkImageSize(file, 2097152) == false)
			{
				request.setAttribute("tooBig", "上传的文件过大,请不要上传2M以上的图片");
				return mapping.findForward("tooBig");
			}
			Upload upload = new Upload();
			upload.upload(file, clientPath, suffix);
			upload.makeImage(upload.getUrl(), 140, -20, upload.makeNewUrl(clientPath, suffix, "_small"), suffix.substring(1));
			upload.makeImage(upload.getUrl(), 600, -20, upload.makeNewUrl(clientPath, suffix, "_big"), suffix.substring(1));
			cs.addPhoto(name, desc, 0, upload.makeNewUrl(path, suffix, ""), upload.makeNewUrl(path, suffix, "_big"), 
				upload.makeNewUrl(path, suffix, "_small"), DateUtil.getFormalTime(), false, albumId);
			System.out.println(path);
			request.setAttribute("success", "上传图片成功");
			return mapping.findForward("success");
		}
		catch (Exception e)
		{
			request.setAttribute("nofind", "找不到该文件,请重新上传");
			return mapping.findForward("nofind");
		}
	}


	private boolean checkImage(String suffix)
	{
		//本类只可以上传JEPG和BMP的图片
		if (suffix.equalsIgnoreCase(".jpg"))
		{
			return true;
		}
		else if (suffix.equalsIgnoreCase(".bmp"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean checkImageSize(FormFile file, int size)
	{
		//如果文件大小比限定的值大,则返回false
		if (file.getFileSize() > size)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

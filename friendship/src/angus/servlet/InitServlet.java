package angus.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import angus.tools.weburl.WebUrl;

public class InitServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()throws ServletException
	{
		WebUrl.DATA_URL = getServletContext().getRealPath("/data/") + "\\";
		WebUrl.NEW_DATA_URL =   "data\\";
	}
}

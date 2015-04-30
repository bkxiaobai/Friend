package angus.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyActionServlet extends org.apache.struts.action.ActionServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void process(HttpServletRequest request, HttpServletResponse response)
		throws java.io.IOException, javax.servlet.ServletException
	{
		request.setCharacterEncoding("GBK");
		super.process(request, response);
	}
}

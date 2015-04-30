package angus.interceptor;

import org.aopalliance.intercept.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import angus.vo.ClientVO;

public class ClientInterceptor implements MethodInterceptor
{
	public Object invoke(MethodInvocation invocation)throws Throwable
	{
		HttpServletRequest request = null;
		@SuppressWarnings("unused")
		ActionMapping mapping = null;
		Object[] args = invocation.getArguments();
		for (int i = 0 ; i < args.length ; i++ )
		{
			if (args[i] instanceof HttpServletRequest)
			{
				request = (HttpServletRequest)args[i];
			}
			if (args[i] instanceof ActionMapping)
			{
				mapping = (ActionMapping)args[i];
			}
		}
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO)session.getAttribute("clientInfo");
		if (cvo == null)
		{
			request.setAttribute("pleaseLogin", "ÇëÏÈµÇÂ¼");
			String url =  request.getRequestURI() + "?" + request.getQueryString();
			session.setAttribute("clientUrl", url);
			request.setAttribute("nologin", "ÇëÏÈµÇÂ¼");
			ActionForward af = new ActionForward("/myalbum.do");
			return af;
		}
		else
		{
			return invocation.proceed();
		}
	}
}

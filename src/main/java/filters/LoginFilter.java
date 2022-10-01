package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String contextPath = ((HttpServletRequest) request).getContextPath();
		String servletPath = ((HttpServletRequest) request).getServletPath();

		if (servletPath.matches("/css.*")) {
			//Exclude authentication process in css folder
			chain.doFilter(request, response);
		}else {
			HttpSession session = ((HttpServletRequest) request).getSession();

			//Acquire action and command from query parameter
			String action = request.getParameter(ForwardConst.ACT.getValue());
			String command = request.getParameter(ForwardConst.CMD.getValue());

			//Acquire logged in employee's information from the session
			EmployeeView ev = (EmployeeView) session.getAttribute(AttributeConst.LOGIN_EMP.getValue());

			if (ev == null) {
				//Not logged in

				if (!(ForwardConst.ACT_AUTH.getValue().equals(action)
							&& (ForwardConst.CMD_SHOW_LOGIN.getValue().equals(command)
								|| ForwardConst.CMD_LOGIN.getValue().equals(command)))) {

					//redirect to login page except displays login page or logging in
					((HttpServletResponse) response).sendRedirect(
						contextPath + "?action=" + ForwardConst.ACT_AUTH.getValue()
						+ "&command=" + ForwardConst.CMD_SHOW_LOGIN.getValue());
					return;
				}
			}else {
				//Logged in

				if (ForwardConst.ACT_AUTH.getValue().equals(action)) {
					//In case trying to authentication action

					if (ForwardConst.CMD_SHOW_LOGIN.getValue().equals(command)) {
						//Redirect to top screen if displays login page
						((HttpServletResponse) response).sendRedirect(
							contextPath + "?action=" + ForwardConst.ACT_TOP.getValue()
							+ "&command=" + ForwardConst.CMD_INDEX.getValue());
						return;
					}else if(ForwardConst.CMD_LOGOUT.getValue().equals(command)){
						//Allow logging out
					}else {
						//Displays error screen if authentication processing that other else above this

						String forward = String.format("/WEB-INF/views/%s.jsp", "error/unknown");
						RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
						dispatcher.forward(request, response);

						return;
					}
				}else if(servletPath.matches("/script/debug/.*")) {
					try {
						if (((EmployeeView)session.getAttribute(AttributeConst.LOGIN_EMP.getValue()))
								.getAdminFlag() != AttributeConst.ROLE_ADMIN.getIntegerValue()){
							throw null;
						}
					}catch (NullPointerException e) {
						String forward = String.format("/WEB-INF/views/%s.jsp", "error/unknown");
						RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
						dispatcher.forward(request, response);
						return;
					}

				}
			}
			//Call next filter or servlet
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
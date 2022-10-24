package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import constants.AttributeConst;
import constants.LanguageClassConst;

/**
 * Servlet Filter implementation class InitializeSession
 */
@WebFilter("/*")
public class InitializeSession implements Filter {

    /**
     * Default constructor.
     */
    public InitializeSession() {
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
//		System.out.println(((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LANGUAGE.getValue()));
//		if (((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LANGUAGE.getValue()) != null) {
//			((HttpServletRequest) request).getSession().removeAttribute(AttributeConst.LANGUAGE.getValue());
//		}else {
		if (((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LANGUAGE.getValue()) == null) {
			((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE.getValue(), LanguageClassConst.JPN_JP);
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

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
import constants.DeclaredLanguage;
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
		Object nullCheck;
		//If is there single action
		if (null != (nullCheck = ((HttpServletRequest) request).getParameter(AttributeConst.POST.getValue()))) {
			//e.g: post=English_United-States
			if (null != (nullCheck = DeclaredLanguage.getByName((String)nullCheck))) {
				LanguageClassConst lcc = ((DeclaredLanguage)nullCheck).getLcc();
				((HttpServletRequest) request).setAttribute(AttributeConst.POST_FLUSH.getValue(), "Update display language to " + lcc.getLanguageName());
				((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE.getValue(), lcc);
			}else {
				((HttpServletRequest) request).setAttribute(AttributeConst.POST_FLUSH_ERR.getValue(), "No such declared language");
			}
			
		}
		if (((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LANGUAGE.getValue()) == null) {
			((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE.getValue(), LanguageClassConst.ENG_US);
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

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
import constants.MessageConst;

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
			LanguageClassConst lang = (LanguageClassConst)((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LANGUAGE.getValue());
			if (null != (nullCheck = DeclaredLanguage.getByName((String)nullCheck))) {
				LanguageClassConst lcc = ((DeclaredLanguage)nullCheck).getLcc();
				if (lcc != lang) {
					((HttpServletRequest) request).setAttribute(AttributeConst.POST_FLUSH.getValue(), MessageConst.I_POST_LANG_UPDATED_L.getMessage(lcc)
								+ lcc.getDisplayName() + MessageConst.I_POST_LANG_UPDATED_R.getMessage(lcc));
					((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE.getValue(), lcc);
					((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE_POST.getValue(), Boolean.TRUE);
				}
			}else {
				((HttpServletRequest) request).setAttribute(AttributeConst.POST_FLUSH_ERR.getValue(), MessageConst.E_POST_LANG_NO_SUCH.getMessage(lang));
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

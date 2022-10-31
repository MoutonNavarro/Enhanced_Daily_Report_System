package filters;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import actions.views.ConfigureView;
import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.DeclaredLanguage;
import constants.LanguageClassConst;
import constants.MessageConst;
import services.ConfigureService;

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
		Object nullCheck;	//For null check at expression
		//If is there single action
		if (null != (nullCheck = ((HttpServletRequest) request).getParameter(AttributeConst.POST.getValue()))) {
			//e.g: post=English_United-States
			LanguageClassConst lang = (LanguageClassConst)((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LANGUAGE.getValue());
			if (null != (nullCheck = DeclaredLanguage.getByName((String)nullCheck))) {	//Continue expression with cast to target type if it is not null
				LanguageClassConst lcc = ((DeclaredLanguage)nullCheck).getLcc();
				if (lcc != lang) {
					((HttpServletRequest) request).setAttribute(AttributeConst.POST_FLUSH.getValue(), MessageConst.I_POST_LANG_UPDATED_L.getMessage(lcc)
								+ lcc.getDisplayName() + MessageConst.I_POST_LANG_UPDATED_R.getMessage(lcc));
					try(ConfigureService cs = new ConfigureService()){
						int id;
						if (null == (nullCheck = ((HttpServletRequest) request).getSession().getAttribute(AttributeConst.LOGIN_EMP.getValue())) ? false
								: null == cs.findOne(id = ((EmployeeView)nullCheck).getId())){
							LocalDateTime ldt = LocalDateTime.now();
							ConfigureView cv = new ConfigureView(id, ldt, ldt, lcc.getLanguageCode(), lcc.getLanguageCountry(), "UTC+09:00", "", (byte)2, "default", false, false, "", "", false);	//Empty Configure instance
							cs.create(cv);	//The initialization timing may change after update
						}

					}
					((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE.getValue(), lcc);
					((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE_POST.getValue(), Boolean.TRUE);
				}
			}else {
				//Initialize display language
				if (lang == null) {
					((HttpServletRequest) request).getSession().setAttribute(AttributeConst.LANGUAGE.getValue(), LanguageClassConst.ENG_US);
					lang = LanguageClassConst.ENG_US;
				}
				((HttpServletRequest) request).setAttribute(AttributeConst.POST_FLUSH_ERR.getValue(), MessageConst.E_POST_LANG_NO_SUCH.getMessage(lang));
			}

		}
		//Initialize display language
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

package actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.AttributeConst;
import constants.ForwardConst;
import constants.PropertyConst;

/**
 * Super class that each Action class. do common process.
 */
public abstract class ActionBase {
   protected ServletContext context;
   protected HttpServletRequest request;
   protected HttpServletResponse response;

   /**
    * Initialize process
    * Set servlet context, request, response at the class field
    * @param servletContext
    * @param servletRequest
    * @param servletResponse
    */
   public void init(
         ServletContext servletContext,
         HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
      this.context   = servletContext;
      this.request   = servletRequest;
      this.response  = servletResponse;
   }

   /**
    * Method that call from front controller
    * @throws ServletException
    * @throws IOException
    */
   public abstract void process() throws ServletException, IOException;

   /**
    * Run method that corresponds command's value of the parameter
    * @throws ServletException
    * @throws IOException
    */
   protected void invoke() throws ServletException, IOException{
      Method commandMethod;
      try {
         //Acquire command from the parameter
         String command = request.getParameter(ForwardConst.CMD.getValue());

         //Run method that corresponds to command
         //(Example: In case action=Employee command=show then run show() method of EmployeeAction class)
         commandMethod = this.getClass().getDeclaredMethod(command, new Class[0]);
         commandMethod.invoke(this, new Object[0]);   //No arguments to the method
      }catch(NoSuchMethodException | SecurityException | IllegalAccessException
            | InvocationTargetException | NullPointerException e) {
         //Displays occurred exception at console
         e.printStackTrace();
         //In case cannot to run because command's value is illegal then call error screen
         forward(ForwardConst.FW_ERR_UNKNOWN);
      }
   }

   /**
    * Do call jsp specified
    * @param target File name to forward (not include expansion)
    * @throws ServletExcepotion
    * @throws IOException
    */
   protected void forward(ForwardConst target) throws ServletException, IOException{
      //Create jsp file's relative path
      String forward = String.format("/WEB-INF/views/%s.jsp", target.getValue());
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward);

      //Call jsp file
      dispatcher.forward(request, response);
   }

   /**
    * Construct URL and do redirect
    * @param action Value that set to the parameter
    * @param command Value that set to the parameter
    * @throws ServletException
    * @throws IOException
    */
   protected void redirect(ForwardConst action, ForwardConst command) throws ServletException, IOException{
      //Construct the URL
      String redirectUrl = request.getContextPath() + "/?action=" + action.getValue();
      if (command != null) {
         redirectUrl = redirectUrl + "&command=" + command.getValue();
      }

      //Redirect to the URL
      response.sendRedirect(redirectUrl);
   }

   /**
    * In case Anti-CSRF token is illegal then displays error screen
    * @return true: Valid token. false: Illegal token
    * @throws ServletException
    * @throws IOEception
    */
   protected boolean checkToken() throws ServletException, IOException{
      //Acquire token's value from the parameter
      String _token = getRequestParam(AttributeConst.TOKEN);

      if (_token == null || !(_token.equals(getTokenId()))) {
         //In case not set the token or not match to the session ID then displays error screen
         forward(ForwardConst.FW_ERR_UNKNOWN);

         return false;
      }else {
         return true;
      }
   }

   /**
    * Acquire the session ID
    * @param Session ID
    */
   protected String getTokenId() {
      return request.getSession().getId();
   }

   /**
    * Acquire number of page that requested to be displayed from the request and return it
    * @return Number of requested page(No request then 1)
    */
   protected int getPage() {
      int page;
      page = toNumber(request.getParameter(AttributeConst.PAGE.getValue()));
      if (page == Integer.MIN_VALUE) {
         page = 1;
      }
      return page;
   }

   /**
    * Convert String to int
    * @param strNumber Before convert String
    * @return Converted number
    */
   protected int toNumber(String strNumber) {
      int number = 0;
      try {
         number = Integer.parseInt(strNumber);
      }catch(Exception e) {
         number = Integer.MIN_VALUE;
      }
      return number;
   }

   /**
    * Convert String to LocalDate type
    * @param strDate Before convert String
    * @return Converted LocalDate instance
    */
   protected LocalDate toLocalDate(String strDate) {
      if (strDate == null || strDate.equals("")) {
         return LocalDate.now();
      }
      return LocalDate.parse(strDate);
   }

   /**
    * Set the parameter to the request scope
    * @param key Parameter name
    * @return Parameter's value
    */
   protected String getRequestParam(AttributeConst key) {
      return request.getParameter(key.getValue());
   }

   /**
    * Acquire specified parameter's value from session scope and return it
    * @param key Parameter name
    * @param value Parameter's value
    */
   protected<V> void putRequestScope(AttributeConst key, V value) {
      request.setAttribute(key.getValue(), value);
   }

   /**
    * Acquire specified parameter's value from session scope and return it
    * @param key Parameter name
    * @return parameter's value
    */
   @SuppressWarnings("unchecked")
   protected<R> R getSessionScope(AttributeConst key) {
      return (R)request.getSession().getAttribute(key.getValue());
   }

   /**
    * Set the parameter at the session scope
    * @param key parameter name
    * @param value parameter's value
    */
   protected<V> void putSessionScope(AttributeConst key, V value) {
      request.getSession().setAttribute(key.getValue(), value);
   }

   /**
    * Remove specified name's parameter from the session scope
    * @param key Parameter name
    */
   protected void removeSessionScope(AttributeConst key) {
      request.getSession().removeAttribute(key.getValue());
   }

   /**
    * Acquire specified parameter's value from the application scope and return it
    * @param key parameter name
    * @return parameter's value
    */
   @SuppressWarnings("unchecked")
   protected<R> R getContextScope(PropertyConst key) {
      return (R) context.getAttribute(key.getValue());
   }
}

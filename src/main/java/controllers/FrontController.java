package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.ActionBase;
import actions.UnknownAction;
import constants.ForwardConst;

/**
 * Front controller
 */
@WebServlet("/")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //Instance of Action class that corresponds to the parameter
      ActionBase action = getAction(request, response);

      //Set servlet context, request, and response at field of the Action instance
      action.init(getServletContext(), request, response);

      //Call process of Action class
      action.process();
    }
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


   /**
    * Create instance of Action class that corresponds from the request parameter, and return it
    * (Example: In case parameter is action=Employee then actions.EmployeeAction object)
    * @param request Request
    * @param response Response
    * @return
    */
   @SuppressWarnings({"rawtypes", "unchecked"}) //Suppress compiler warnings
   private ActionBase getAction(HttpServletRequest request, HttpServletResponse response) {
      Class type = null;
      ActionBase action = null;
      try {
         //Acquire parameter value of "action" from request(Example: "Employee". "Report")
         String actionString = request.getParameter(ForwardConst.ACT.getValue());

         //Create correspond Action object(Example: In case parameter action=Employee from request then actions.EmployeeAction object)
         type = Class.forName(String.format("actions.%sAction", actionString));

         //Cast to object of the ActionBase(Example: actions.EmployeeAction object -> actions.ActionBase object)
         action = (ActionBase)(type.asSubclass(ActionBase.class)
            .getDeclaredConstructor().newInstance());
      }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException
            | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
         //In case "action"'s value that set at the request parameter is illegal (Example: action=xxxx and else, no such corresponded Action class)
         //Create Action object that do error processing
         action = new UnknownAction();
      }
      return action;
   }

}

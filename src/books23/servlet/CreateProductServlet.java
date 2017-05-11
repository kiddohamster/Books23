package books23.servlet;
 
import java.io.IOException;
 


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import books23.beans.UserAccount;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public CreateProductServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  
	  HttpSession session = request.getSession();
	  UserAccount loginedUser = MyUtils.getLoginedUser(session);
	  
	  if (loginedUser.getUserName().equals("admin")){
		  request.setAttribute("user", loginedUser);
		  
	      RequestDispatcher dispatcher = request.getServletContext()
	              .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
	      dispatcher.forward(request, response);
	  } else {
		  response.sendRedirect(request.getContextPath() + "/");
	  }
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
package books23.servlet;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doLogOut" })
public class DoLogOutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoLogOutServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        
      HttpSession session=request.getSession();  
      session.invalidate();  
        
      response.sendRedirect(request.getContextPath() + "/");
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
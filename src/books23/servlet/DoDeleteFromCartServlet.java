package books23.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import javax.servlet.http.HttpSession;

import books23.beans.UserAccount;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/deleteFromCart" })
public class DoDeleteFromCartServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoDeleteFromCartServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      Connection conn = MyUtils.getStoredConnection(request);
 
      HttpSession session = request.getSession();
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      String userName = loginedUser.getUserName();
      
      String code = (String) request.getParameter("code");
 
      String errorString = null;
 
      try {
          DBUtils.deleteFromCart(conn, userName, code);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      
      // Nếu có lỗi forward sang trang báo lỗi.
      if (errorString != null) {
          // Lưu thông tin vào request attribute trước khi forward sang views.
          request.setAttribute("errorString", errorString);
          //
          RequestDispatcher dispatcher = request.getServletContext()
                  .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
          dispatcher.forward(request, response);
      }
      // Nếu mọi thứ tốt đẹp.
      // Redirect sang trang danh sách sản phẩm.
      else {
          response.sendRedirect(request.getContextPath() + "/cart");
      }
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
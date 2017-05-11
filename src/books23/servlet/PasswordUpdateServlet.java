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

import books23.beans.Product;
import books23.beans.UserAccount;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/passwordUpdate"})
public class PasswordUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public PasswordUpdateServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  Connection conn = MyUtils.getStoredConnection(request);
	  
	  HttpSession session = request.getSession();
      
      // Kiểm tra người dùng login chưa
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      
      String userName = loginedUser.getUserName();
 
      UserAccount user = null;
 
      String errorString = null;
 
      try {
          user = DBUtils.findUser(conn, userName);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
 
      // Không có lỗi.
      // Sản phẩm không tồn tại để edit.
      // Redirect sang trang danh sách sản phẩm.
      if (errorString != null && user == null) {
          response.sendRedirect(request.getServletPath() + "/userInfo");
          return;
      }
 
      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("user", user);
      
      // Forward toi trang /WEB-INF/views/loginView.jsp
      // (Người dùng không bao giờ truy cập trực tiếp được vào các trang JSP
      // đặt trong WEB-INF)
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/passwordUpdateView.jsp");
      
      dispatcher.forward(request, response);
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
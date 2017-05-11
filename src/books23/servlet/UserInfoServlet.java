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
 
@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public UserInfoServlet() {
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
      // Chưa login.
      if (loginedUser == null) {
          // Chuyển hướng về trang login.
          response.sendRedirect(request.getContextPath() + "/login");
          return;
      }
      try {
          user = DBUtils.findUser(conn, userName);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      // Ghi thông tin vào request trước khi forward.
      request.setAttribute("user", user);
 
      // Đã login rồi thì chuyển tiếp sang /WEB-INF/views/userInfoView.jsp
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
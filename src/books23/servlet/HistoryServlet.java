package books23.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import books23.beans.History;
import books23.beans.Product;
import books23.beans.UserAccount;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/history" })
public class HistoryServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public HistoryServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  Connection conn = MyUtils.getStoredConnection(request);
	  HttpSession session = request.getSession();
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      String userName = loginedUser.getUserName();
      
      String errorString = null;
      List<History> list = null;
      
      UserAccount user = null;
 
      try {
          user = DBUtils.findUser(conn, userName);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      
      try {
          list = DBUtils.getHistory(conn, userName);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("user", user);
      request.setAttribute("historyList", list);
      
      // Forward sang /WEB-INF/views/productListView.jsp
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/userHistoryView.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
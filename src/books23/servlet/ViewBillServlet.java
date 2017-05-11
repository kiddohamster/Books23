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

import books23.beans.Bill;
import books23.beans.History;
import books23.beans.Product;
import books23.beans.UserAccount;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/bill"})
public class ViewBillServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public ViewBillServlet() {
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
      List<Bill> list = null;
      
      UserAccount user = null;
      History history = null;
      try {
          user = DBUtils.findUser(conn, userName);
          history = DBUtils.findHistory(conn, userName, code);
          list = DBUtils.getBill(conn, userName, code);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      
      String address = list.get(0).getUserAddress();
      int total = history.getTotalPrice();
      int pointUse = history.getPointUse();
      // Lưu thông tin vào request attribute trước khi forward sang views.
      
      request.setAttribute("errorString", errorString);
      request.setAttribute("billList", list);
      request.setAttribute("total", total);
      request.setAttribute("point", (total+pointUse)/100);
      request.setAttribute("address", address);
      request.setAttribute("user", user);
      request.setAttribute("pointUse", pointUse);
 
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/billView.jsp");
      dispatcher.forward(request, response);
      
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
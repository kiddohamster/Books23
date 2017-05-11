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

import books23.beans.Cart;
import books23.beans.Product;
import books23.beans.UserAccount;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/cart"})
public class CartServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public CartServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
	  Connection conn = MyUtils.getStoredConnection(request);
	  
	  HttpSession session = request.getSession();
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      if (loginedUser != null) {
	      String userName = loginedUser.getUserName();
	      
	      String errorString = null;
	      List<Cart> list = null;
	      UserAccount user = null;
	      int total = 0;
	      try {
	          list = DBUtils.getCart(conn, userName);
	          total = DBUtils.getTotal(conn, userName);
	          user = DBUtils.findUser(conn, userName);
	      } catch (SQLException e) {
	          e.printStackTrace();
	          errorString = e.getMessage();
	      }
	      int pointCapable = 0;
	      if (user.getPoint() < 20000) {
	    	  pointCapable = user.getPoint();
	      } else {
	    	  pointCapable = 20000;
	      }
	      // Lưu thông tin vào request attribute trước khi forward sang views.
	      request.setAttribute("errorString", errorString);
	      request.setAttribute("cartList", list);
	      request.setAttribute("total", total);
	      request.setAttribute("user", user);
	      request.setAttribute("pointCapable", pointCapable);
	      
	      // Forward sang /WEB-INF/views/productListView.jsp
	      RequestDispatcher dispatcher = request.getServletContext()
	              .getRequestDispatcher("/WEB-INF/views/cartView.jsp");
	      dispatcher.forward(request, response);
      } else {
    	  RequestDispatcher dispatcher = request.getServletContext()
	              .getRequestDispatcher("/WEB-INF/views/loginView.jsp");
	      dispatcher.forward(request, response);
      }
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
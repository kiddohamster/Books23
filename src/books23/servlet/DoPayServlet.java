package books23.servlet;
 
import java.io.IOException;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import books23.beans.Bill;
import books23.beans.Cart;
import books23.beans.Product;
import books23.beans.UserAccount;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/pay"})
public class DoPayServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoPayServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
	  Connection 		conn 			= 	MyUtils.getStoredConnection(request);
	  HttpSession 		session 		= 	request.getSession();
      UserAccount 		loginedUser 	= 	MyUtils.getLoginedUser(session);
      String 			userName 		= 	loginedUser.getUserName();
      String			userAddress		=	loginedUser.getAddress();
      String			billCode		=	null;
      String			confirmString	= 	null;
      String 			errorString 	= 	null;
      List<Cart> 		cartList 		= 	null;
      int 				total 			= 	0;
      int				pointUse		=	0;
      int				totalPrice		=	0;
      String			pointUseStr		=	request.getParameter("pointUse");
      Date				billDate		=	new Date(System.currentTimeMillis());
      try {	
    	  pointUse 	=	Integer.parseInt(pointUseStr);
    	  cartList 	= 	DBUtils.getCart(conn, userName);
    	  if (cartList.size() > 0) {
	          total 		= 	DBUtils.getTotal(conn, userName);
	          totalPrice	=	total - pointUse;
	    	  billCode		=	DBUtils.getBillCode(conn, userName);
	    	  
	    	  for (int i = 0; i < cartList.size(); i++) {
	    		  String 	bookCode 		= 	cartList.get(i).getBookCode();
	    		  String 	bookName 		=	cartList.get(i).getBookName();
	    		  int		bookQuantity	=	cartList.get(i).getBookQuantity();
	    		  int		bookPrice		=	cartList.get(i).getBookPrice();
	    		  Bill		bill			= 	new Bill(userName, billCode, bookCode, bookName, bookQuantity, 
	    													bookPrice, userAddress, billDate);
	    		  DBUtils.addToBill(conn, bill, userName);
	    	  }
	    	  DBUtils.updatePoint(conn, userName, total/100);
	    	  DBUtils.updatePoint(conn, userName, -pointUse);
	    	  DBUtils.addToHistory(conn, billCode, userName, totalPrice, billDate, pointUse);
	    	  DBUtils.newCart(conn, userName);
    	  } else {
    		  errorString = "Không có sản phẩm trong giỏ hàng!";
    		  request.setAttribute("errorString", errorString);
    		  RequestDispatcher dispatcher = request.getServletContext()
    	              .getRequestDispatcher("/WEB-INF/views/cartView.jsp");
    	      dispatcher.forward(request, response);
    	  }
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      
      if (errorString != null) {
	      // Forward sang /WEB-INF/views/productListView.jsp
	      confirmString	= "Đặt hàng thất bại!";
      } else {
    	// Forward sang /WEB-INF/views/productListView.jsp
	      confirmString = "Đặt hàng thành công!";
      }
      
      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("confirm", confirmString);
      request.setAttribute("total", totalPrice);
      request.setAttribute("point", total/100);
      request.setAttribute("pointUse", pointUse);
      
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/payConfirmView.jsp");
      dispatcher.forward(request, response);
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
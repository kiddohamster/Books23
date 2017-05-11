package books23.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 






import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 







import books23.beans.Product;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doEditProduct" })
public class DoEditProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoEditProductServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      Connection conn = MyUtils.getStoredConnection(request);
 
      String errorString = null;
      
      Timestamp addTime 		=	new Timestamp(System.currentTimeMillis());
      String 	code 			= 	(String) request.getParameter("code");
      String 	name 			= 	(String) request.getParameter("name");
      String 	priceStr 		= 	(String) request.getParameter("price");
      String 	author 			= 	(String) request.getParameter("author");
      String 	category 		= 	(String) request.getParameter("category");
      String 	info 			= 	String.join("", request.getParameterValues("info"));
      String 	imageUrl 		= 	(String) request.getParameter("imageUrl");
      String 	quantityStr 	= 	(String) request.getParameter("quantity");
      int 		rating 			= 	0;
      int		price 			= 	0;
      int 		quantity		= 	0;
      try {
          price 		= 	Integer.parseInt(priceStr);
          quantity 		= 	Integer.parseInt(quantityStr);
      } catch (Exception e) {
    	  errorString = "Kiểm tra lại Giá và Số lượng!";
      }
      Product product = new Product(code, name, price, author, category, info, rating, imageUrl, quantity, addTime);
 
      try {
          DBUtils.updateProduct(conn, product);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("product", product);
 
      // Nếu có lỗi forward sang trang edit
      if (errorString != null) {
          RequestDispatcher dispatcher = request.getServletContext()
                  .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
          dispatcher.forward(request, response);
      }
      // Nếu mọi thứ tốt đẹp.
      // Redirect sang trang danh sách sản phẩm.
      else {
          response.sendRedirect(request.getContextPath() + "/productList");
      }
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
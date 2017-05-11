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

import books23.beans.Product;
import books23.utils.DBUtils;
import books23.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/Book"})
public class DoProductViewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoProductViewServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  Connection conn = MyUtils.getStoredConnection(request);
	  
      String code = (String) request.getParameter("code");
 
      Product product = null;
 
      String errorString = null;
 
      try {
          product = DBUtils.findProduct(conn, code);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
 
      // Không có lỗi.
      // Sản phẩm không tồn tại để edit.
      // Redirect sang trang danh sách sản phẩm.
      if (errorString != null && product == null) {
          response.sendRedirect(request.getServletPath() + "/");
          return;
      }
 
      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("product", product);
 
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/productView.jsp");
      dispatcher.forward(request, response);
      
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
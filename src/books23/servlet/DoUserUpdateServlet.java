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
 
@WebServlet(urlPatterns = { "/doUserUpdate" })
public class DoUserUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoUserUpdateServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      
      String errorString = null;
      
      String 	userName 		= 	loginedUser.getUserName();      
      String 	gender 			= 	loginedUser.getGender();
      String 	password 		= 	loginedUser.getPassword();
      String 	fullName 		= 	(String) request.getParameter("fullName");
      String 	email 			= 	(String) request.getParameter("email");
      String 	phone 			= 	(String) request.getParameter("phone");
      String 	address 		= 	(String) request.getParameter("address");
      
      String	bank	 		= 	(String) request.getParameter("bank");
      String	creditCard 		= 	(String) request.getParameter("creditCard");
      int 		point 			= 	loginedUser.getPoint();
      
      if (fullName == null || email == null || phone == null || address == null || fullName.length() == 0 
			  || email.length() == 0 || phone.length() == 0 || address.length() == 0){
          errorString = "Yêu cầu nhập đủ các thông tin (*)!";
      }
      
      UserAccount user1 = null;
 
      try {
          user1 = DBUtils.findUser(conn, userName);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
     
      String	avatarUrl 		= 	user1.getAvatarUrl();
      
	  UserAccount user = new UserAccount(userName, gender, password, fullName, email, phone, address, point, avatarUrl, bank, creditCard); 

      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("user", user);
 
      // Nếu có lỗi forward sang trang edit
      if (errorString != null) {
          RequestDispatcher dispatcher = request.getServletContext()
                  .getRequestDispatcher("/WEB-INF/views/userUpdateView.jsp");
          dispatcher.forward(request, response);
      }
      // Nếu mọi thứ tốt đẹp.
      // Redirect sang trang danh sách sản phẩm.
      else {          
          try {
              DBUtils.updateUser(conn, user);
          } catch (SQLException e) {
              e.printStackTrace();
              errorString = e.getMessage();
          }
          request.setAttribute("user", user);
          response.sendRedirect(request.getContextPath() + "/userInfo");
      }
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
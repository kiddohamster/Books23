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
 
@WebServlet(urlPatterns = { "/doPasswordUpdate" })
public class DoPasswordUpdateView extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoPasswordUpdateView() {
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
      String 	password 		= 	(String) request.getParameter("password");
      String 	newPassword		=	(String) request.getParameter("newPassword");
      String 	fullName 		= 	loginedUser.getFullName();
      String 	email 			= 	loginedUser.getEmail();
      String 	phone 			= 	loginedUser.getPhone();
      String 	address 		= 	loginedUser.getAddress();
      String	bank	 		= 	loginedUser.getBank();
      String	creditCard 		= 	loginedUser.getCreditCard();
      int 		point 			= 	loginedUser.getPoint();
      
      try {
    	  if (!password.equals(DBUtils.findPassword(conn, userName).getPassword())) {
			  errorString = "Sai mật khẩu cũ!";
		  } else if (password == null || newPassword == null || password.length() == 0 || newPassword.length() == 0){
		      errorString = "Yêu cầu nhập đủ các thông tin (*)!";
		  }
		} catch (SQLException e1) {
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
                  .getRequestDispatcher("/WEB-INF/views/passwordUpdateView.jsp");
          dispatcher.forward(request, response);
      }
      // Nếu mọi thứ tốt đẹp.
      // Redirect sang trang danh sách sản phẩm.
      else {
    	  
          
          try {
              DBUtils.updatePassword(conn, user, newPassword);
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
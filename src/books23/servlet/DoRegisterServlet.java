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
 
@WebServlet(urlPatterns = { "/doRegister" })
public class DoRegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoRegisterServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
      String userName 	= 	(String) 	request.getParameter("userName");
      String password 	= 	(String) 	request.getParameter("password");
      String fullName 	= 	(String) 	request.getParameter("fullName");
      String email 		= 	(String) 	request.getParameter("email");
      String phone 		= 	(String) 	request.getParameter("phone");
      String address 	= 	(String) 	request.getParameter("address");
      String gender		= 	null;
      String avatarUrl	=	"img/default.png";
      String bank		=	null;
      String creditCard	=	null;
 
      UserAccount user = null;
      boolean hasError = false;
      String errorString = null;
 
      try {
    	  Connection conn = MyUtils.getStoredConnection(request);
	      if (DBUtils.findUserName(conn, userName) != null) {
	    	  hasError = true;
	    	  errorString = "Tài khoản tồn tại!";
	      } else {
	    	  if (DBUtils.findEmail(conn, email) != null) {
	    		  hasError = true;
	    		  errorString = "Email tồn tại!";
	    	  } else {										
	    		  if (userName == null || password == null || fullName == null || email == null || phone == null 
	    				  || address == null || userName.length() == 0 || password.length() == 0 || fullName.length() == 0 
	    				  || email.length() == 0 || phone.length() == 0 || address.length() == 0){
	    			  hasError = true;
			          errorString = "Yêu cầu nhập đủ các thông tin (*)!";
	    		  } else {
	    			  int point = 0;
	    			  user = new UserAccount(userName, gender, password, fullName, email, phone, address, point, avatarUrl, bank, creditCard);
	    			  DBUtils.insertUser(conn, user);
	    		  }
	    	  }
	      }
	  } catch (SQLException e) {
		  e.printStackTrace();
		  hasError = true;
		  errorString = e.getMessage();
	  }
    	
      // Trong trường hợp có lỗi, forward về trang /WEB-INF/views/login.jsp
      if (hasError) {
          user = new UserAccount();
          user.setFullName(fullName);
          user.setPhone(phone);
          user.setAddress(address);
          
          // Ghi các thông tin vào request trước khi forward.
          request.setAttribute("errorString", errorString);
          request.setAttribute("user", user);
 
          // Chuyển tiếp tới trang /WEB-INF/views/login.jsp
          RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
 
          dispatcher.forward(request, response);
      }
      // Trường hợp không có lỗi.
      // Lưu thông tin người dùng vào Session.
      // Và chuyển hướng sang trang userInfo.
      else {
    	  request.setAttribute("errorString", errorString);
          request.setAttribute("user", user);
          
          HttpSession session = request.getSession();
          MyUtils.storeLoginedUser(session, user);
          
          // Rồi chuyển hướng sang trang /userInfo.
          response.sendRedirect(request.getContextPath() + "/");
      }
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
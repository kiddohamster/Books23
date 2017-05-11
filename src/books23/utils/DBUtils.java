package books23.utils;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 











import javax.servlet.jsp.jstl.sql.Result;

import books23.beans.Bill;
import books23.beans.Cart;
import books23.beans.History;
import books23.beans.Product;
import books23.beans.UserAccount;
 
public class DBUtils {
 
  public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
 
      String sql = "Select a.user_name, a.password, a.gender, a.full_name, a.email, a.phone, a.address, a.point, a.avatar_url, a.bank, a.credit_card "
      				+ "from User_Account a "
      				+ " where a.User_Name = ? and a.password= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, password);
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          String 	gender 		= 	rs.getString("gender");
          String 	fullName 	= 	rs.getString("full_name");
          String 	email		= 	rs.getString("email");
          String 	phone		=	rs.getString("phone");
          String 	address		=	rs.getString("address");
          int		point		=	rs.getInt("point");
          String	avatarUrl	=	rs.getString("avatar_url");
          String	bank		=	rs.getString("bank");
          String	creditCard	=	rs.getString("credit_card");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          user.setGender(gender);
          user.setFullName(fullName);
          user.setEmail(email);
          user.setPhone(phone);
          user.setAddress(address);
          user.setPoint(point);
          user.setAvatarUrl(avatarUrl);
          user.setBank(bank);
          user.setCreditCard(creditCard);
          return user;
      }
      return null;
  }
 
  public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
	  String sql = "Select a.user_name, a.password, a.gender, a.full_name, a.email, a.phone, a.address, a.point, a.avatar_url, a.bank, a.credit_card "
				+ "from User_Account a "
				+ " where a.user_name = ?";
	  
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  String	password	=	rs.getString("password");
    	  String 	gender 		= 	rs.getString("gender");
          String 	fullName 	= 	rs.getString("full_name");
          String 	email		= 	rs.getString("email");
          String 	phone		=	rs.getString("phone");
          String 	address		=	rs.getString("address");
          int		point		=	rs.getInt("point");
          String	avatarUrl	=	rs.getString("avatar_url");
          String	bank		=	rs.getString("bank");
          String	creditCard	=	rs.getString("credit_card");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          user.setGender(gender);
          user.setFullName(fullName);
          user.setEmail(email);
          user.setPhone(phone);
          user.setAddress(address);
          user.setPoint(point);
          user.setAvatarUrl(avatarUrl);
          user.setBank(bank);
          user.setCreditCard(creditCard);
          return user;
      }
      return null;
  }
  
  public static UserAccount findUserName(Connection conn, String userName) throws SQLException {
	  
      String sql = "Select a.User_Name from User_Account a where a.User_Name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          return user;
      }
      return null;
  }
  
public static UserAccount findPassword(Connection conn, String userName) throws SQLException {
	  
      String sql = "Select a.password from User_Account a where a.User_Name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  String password	=	rs.getString("password");
          UserAccount user = new UserAccount();
          user.setPassword(password);
          return user;
      }
      return null;
  }
  
  public static UserAccount findEmail(Connection conn, String email) throws SQLException {
	  
      String sql = "Select a.email from User_Account a where a.email = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, email);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          UserAccount user = new UserAccount();
          user.setEmail(email);
          return user;
      }
      return null;
  }
  
  public static void insertUser(Connection conn, UserAccount user) throws SQLException {
      String sql = "Insert into User_Account(user_name, gender, password, full_name, email, phone, address, point, avatar_url, bank, credit_card) "
      		+ "values (?,?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, user.getUserName());
      pstm.setString(2, user.getGender());
      pstm.setString(3, user.getPassword());
      pstm.setString(4, user.getFullName());
      pstm.setString(5, user.getEmail());
      pstm.setString(6, user.getPhone());
      pstm.setString(7, user.getAddress());
      pstm.setInt(8, user.getPoint());
      pstm.setString(9, user.getAvatarUrl());
      pstm.setString(10, user.getBank());
      pstm.setString(11, user.getCreditCard());
 
      pstm.executeUpdate();
  }
  
  public static void updateUser(Connection conn, UserAccount user) throws SQLException {
      String sql = "Update User_Account set gender=?, full_name=?, email=?, phone=?, address=?, point=?, "
      				+ "avatar_url=?, bank=?, credit_card=? where user_name=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, user.getGender());
      pstm.setString(2, user.getFullName());
      pstm.setString(3, user.getEmail());
      pstm.setString(4, user.getPhone());
      pstm.setString(5, user.getAddress());
      pstm.setInt(6, user.getPoint());
      pstm.setString(7, user.getAvatarUrl());
      pstm.setString(8, user.getBank());
      pstm.setString(9, user.getCreditCard());
      pstm.setString(10, user.getUserName());
      pstm.executeUpdate();
  }
  
  public static void updatePassword(Connection conn, UserAccount user, String newPassword) throws SQLException {
      String sql = "Update User_Account set password=? where user_name=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, newPassword);
      pstm.setString(2, user.getUserName());
      pstm.executeUpdate();
  }
  
  public static void updatePoint(Connection conn, String userName, int updatePoint) throws SQLException{
	  String sql0 = "select a.point from User_account a where a.user_name=?";
	  
	  PreparedStatement pstm = conn.prepareStatement(sql0);
	  pstm.setString(1, userName);
	  ResultSet rs = pstm.executeQuery();
	  int point = 0;
	  while (rs.next()) {
		  point = rs.getInt("point");
	  }
	  
	  String sql = "update User_Account set point=? where user_name=?";
	  
	  pstm = conn.prepareStatement(sql);
	  
	  pstm.setInt(1, point + updatePoint);
	  pstm.setString(2, userName);
	  
	  pstm.executeUpdate();
  }
  
  // Product-----------------------------------------------------------------------------------
  
  public static List<Product> searchProduct(Connection conn, String key) throws SQLException {
      String sql = "Select a.code, a.name, a.price, a.author, a.category, a.info, a.rating, a.image_url, a.quantity, a.add_time "
      				+ "from Product a where a.name like '%" + key + "%'";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Product> list = new ArrayList<Product>();
      while (rs.next()) {
          String 	code 		= rs.getString("code");
          String 	name 		= rs.getString("name");
          int 		price 		= rs.getInt("price");
          String 	author 		= rs.getString("author");
          String 	category 	= rs.getString("category");
          String 	info 		= rs.getString("info");
          int 		rating 		= rs.getInt("rating");
          String 	imageUrl 	= rs.getString("image_url");
          int 		quantity 	= rs.getInt("quantity");
          Timestamp addTime		= rs.getTimestamp("add_time");
          Product product = new Product();
          product.setCode(code);
          product.setName(name);
          product.setPrice(price);
          product.setAuthor(author);
          product.setCategory(category);
          product.setInfo(info);
          product.setRating(rating);
          product.setImageUrl(imageUrl);
          product.setQuantity(quantity);
          product.setAddTime(addTime);
          list.add(product);
      }
      return list;
  }
  
  public static List<Product> introProduct(Connection conn) throws SQLException {
      String sql = "Select a.code, a.name, a.price, a.author, a.category, a.info, a.rating, a.image_url, a.quantity, a.add_time "
      				+ "from Product a limit 8";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Product> list = new ArrayList<Product>();
      while (rs.next()) {
          String 	code 		= rs.getString("code");
          String 	name 		= rs.getString("name");
          int 		price 		= rs.getInt("price");
          String 	author 		= rs.getString("author");
          String 	category 	= rs.getString("category");
          String 	info 		= rs.getString("info");
          int 		rating 		= rs.getInt("rating");
          String 	imageUrl 	= rs.getString("image_url");
          int 		quantity 	= rs.getInt("quantity");
          Timestamp addTime		= rs.getTimestamp("add_time");
          Product product = new Product();
          product.setCode(code);
          product.setName(name);
          product.setPrice(price);
          product.setAuthor(author);
          product.setCategory(category);
          product.setInfo(info);
          product.setRating(rating);
          product.setImageUrl(imageUrl);
          product.setQuantity(quantity);
          product.setAddTime(addTime);
          list.add(product);
      }
      return list;
  }
 
  public static List<Product> queryProduct(Connection conn) throws SQLException {
      String sql = "Select a.code, a.name, a.price, a.author, a.category, a.info, a.rating, a.image_url, a.quantity, a.add_time "
      				+ "from Product a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Product> list = new ArrayList<Product>();
      while (rs.next()) {
          String 	code 		= rs.getString("code");
          String 	name 		= rs.getString("name");
          int 		price 		= rs.getInt("price");
          String 	author 		= rs.getString("author");
          String 	category 	= rs.getString("category");
          String 	info 		= rs.getString("info");
          int 		rating 		= rs.getInt("rating");
          String 	imageUrl 	= rs.getString("image_url");
          int 		quantity 	= rs.getInt("quantity");
          Timestamp addTime		= rs.getTimestamp("add_time");
          Product product = new Product();
          product.setCode(code);
          product.setName(name);
          product.setPrice(price);
          product.setAuthor(author);
          product.setCategory(category);
          product.setInfo(info);
          product.setRating(rating);
          product.setImageUrl(imageUrl);
          product.setQuantity(quantity);
          product.setAddTime(addTime);
          list.add(product);
      }
      return list;
  }
  
  public static Product findID(Connection conn, String code) throws SQLException {
	  
      String sql = "Select a.code from Product a where a.code = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, code);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          Product product = new Product();
          product.setCode(code);
          return product;
      }
      return null;
  }
 
  public static Product findProduct(Connection conn, String code) throws SQLException {
      String sql = "Select a.code, a.name, a.price, a.author, a.category, a.info, a.rating, a.image_url, a.quantity, a.add_time "
      				+ "from Product a "
      				+ "where a.code=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, code);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          String 	name 		= rs.getString("name");
          int 		price 		= rs.getInt("price");
          String 	author 		= rs.getString("author");
          String 	category 	= rs.getString("category");
          String 	info 		= rs.getString("info");
          int 		rating 		= rs.getInt("rating");
          String 	imageUrl 	= rs.getString("image_url");
          int 		quantity 	= rs.getInt("quantity");
          Timestamp addTime		= rs.getTimestamp("add_time");
          Product 	product 	= new Product(code, name, price, author, category, info, rating, imageUrl, quantity, addTime);
          return product;
      }
      return null;
  }
 
  public static void updateProduct(Connection conn, Product product) throws SQLException {
      String sql = "Update Product set name =?, price=?, author=?, category=?, info=?, rating=?, "
    		  		+ "image_url=?, quantity=?, add_time=? where code=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getName());
      pstm.setFloat(2, product.getPrice());
      pstm.setString(3, product.getAuthor());
      pstm.setString(4, product.getCategory());
      pstm.setString(5, product.getInfo());
      pstm.setInt(6, product.getRating());
      pstm.setString(7, product.getImageUrl());
      pstm.setInt(8, product.getQuantity());
      pstm.setTimestamp(9, product.getAddTime());
      pstm.setString(10, product.getCode());
      pstm.executeUpdate();
  }
 
  public static void insertProduct(Connection conn, Product product) throws SQLException {
      String sql = "Insert into Product(code, name, price, author, category, info, rating, image_url, quantity, add_time) "
      				+ "values (?,?,?,?,?,?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getCode());
      pstm.setString(2, product.getName());
      pstm.setFloat(3, product.getPrice());
      pstm.setString(4, product.getAuthor());
      pstm.setString(5, product.getCategory());
      pstm.setString(6, product.getInfo());
      pstm.setInt(7, product.getRating());
      pstm.setString(8, product.getImageUrl());
      pstm.setInt(9, product.getQuantity());
      pstm.setTimestamp(10, product.getAddTime());
 
      pstm.executeUpdate();
  }
 
  public static void deleteProduct(Connection conn, String code) throws SQLException {
      String sql = "Delete from Product where Code= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, code);
 
      pstm.executeUpdate();
  }
  
  // Cart--------------------------------------------------------------------------
  
  public static void newCart(Connection conn, String userName) throws SQLException {
      String sql = "Delete from Cart where user_name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.executeUpdate();
  }
  
  public static void addToCart(Connection conn, Cart cart, String userName) throws SQLException {
      String sql = "insert into cart(user_name, book_code, book_name, book_image_url, book_quantity, book_price) "
    		  		+ "value(?,?,?,?,?,?)";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, cart.getUserName());
      pstm.setString(2, cart.getBookCode());
      pstm.setString(3, cart.getBookName());
      pstm.setString(4, cart.getBookImageUrl());
      pstm.setInt(5, cart.getBookQuantity());
      pstm.setInt(6, cart.getBookPrice());
 
      pstm.executeUpdate();
  }
  
  public static List<Cart> getCart(Connection conn, String userName) throws SQLException {
      String sql = "Select a.user_name, a.book_code, a.book_name, a.book_image_url, a.book_quantity, a.book_price "
      				+ "from Cart a where a.user_name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      ResultSet rs = pstm.executeQuery();
      List<Cart> list = new ArrayList<Cart>();
      while (rs.next()) {
          String 	bookCode 		= rs.getString("book_code");
          String	bookName		= rs.getString("book_name");
          String 	bookImageUrl 	= rs.getString("book_image_url");
          int 		bookQuantity 	= rs.getInt("book_quantity");
          int 		bookPrice 		= rs.getInt("book_price");
          Cart cart = new Cart();
          cart.setUserName(userName);
          cart.setBookCode(bookCode);
          cart.setBookName(bookName);
          cart.setBookImageUrl(bookImageUrl);
          cart.setBookQuantity(bookQuantity);
          cart.setBookPrice(bookPrice);
          list.add(cart);
      }
      return list;
  }
  
  public static int getTotal(Connection conn, String userName) throws SQLException {
      String sql = "Select a.book_quantity, a.book_price "
      				+ "from Cart a where a.user_name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      ResultSet rs = pstm.executeQuery();
      int total = 0;
      while (rs.next()) {
          int 		bookQuantity 	= rs.getInt("book_quantity");
          int 		bookPrice 		= rs.getInt("book_price");
          total += bookQuantity*bookPrice;
      }
      return total;
  }
  
  public static void deleteFromCart(Connection conn, String userName, String bookCode) throws SQLException {
      String sql = "Delete from Cart where user_name = ? and book_code = ? limit 1";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, userName);
      pstm.setString(2, bookCode);
 
      pstm.executeUpdate();
  }
  
  public static void updateQuantityCart(Connection conn, String userName, String bookCode, int addQuantity) throws SQLException {
	  String sql1 = "Select a.book_quantity from Cart a where a.user_name = ? and a.book_code = ?";
	  
	  PreparedStatement pstm = conn.prepareStatement(sql1);
	  pstm.setString(1, userName);
	  pstm.setString(2, bookCode);
	  ResultSet rs = pstm.executeQuery();
	  int preQuantity = 0;
	  while (rs.next()) {
		  int bookQuantity = rs.getInt("book_quantity");
		  preQuantity += bookQuantity;
	  }
	  
	  String sql2 = "update cart set book_quantity = ? where user_name = ? and book_code = ?";
	  
	  pstm = conn.prepareStatement(sql2);
	  
	  pstm.setInt(1, preQuantity+addQuantity);
	  pstm.setString(2, userName);
	  pstm.setString(3, bookCode);
	  pstm.executeUpdate();
  }
  
  public static boolean existCart(Connection conn, String userName, String bookCode) throws SQLException {
	  String sql = "select * from cart a where a.user_name = ? and a.book_code = ?";
	  
	  PreparedStatement pstm = conn.prepareStatement(sql);
	  pstm.setString(1, userName);
	  pstm.setString(2, bookCode);
	  ResultSet rs = pstm.executeQuery();
	  int count = 0;
	  while (rs.next()) {
		  count++;
	  }
	  
	  if (count == 0) return false; 
	  else return true;
  }
  
  // Bill---------------------------------------------------------------------------------
  
  public static String getBillCode(Connection conn, String userName) throws SQLException {
	  long 	currentTime 	= 	new Timestamp(System.currentTimeMillis()).getTime();
	  return userName + "_" + currentTime;
  }
  
  public static void addToBill(Connection conn, Bill bill, String userName) throws SQLException {
      String sql = "insert into bill(user_name, bill_code, book_code, book_name, book_quantity, book_price, user_address, bill_date) "
    		  		+ "value(?,?,?,?,?,?,?,?)";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, bill.getUserName());
      pstm.setString(2, bill.getBillCode());
      pstm.setString(3, bill.getBookCode());
      pstm.setString(4, bill.getBookName());
      pstm.setInt(5, bill.getBookQuantity());
      pstm.setInt(6, bill.getBookPrice());
      pstm.setString(7, bill.getUserAddress());
      pstm.setDate(8, bill.getBillDate());
 
      pstm.executeUpdate();
  }
 
  public static List<Bill> getBill(Connection conn, String userName, String billCode) throws SQLException {
      String sql = "Select a.user_name, a.bill_code, a.book_code, a.book_name, a.book_quantity, a.book_price, a.user_address, a.bill_date "
      				+ "from bill a where a.user_name = ? and a.bill_code = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, billCode);
      ResultSet rs = pstm.executeQuery();
      List<Bill> list = new ArrayList<Bill>();
      while (rs.next()) {
          String 	bookCode 		= rs.getString("book_code");
          String	bookName		= rs.getString("book_name");
          int 		bookQuantity 	= rs.getInt("book_quantity");
          int 		bookPrice 		= rs.getInt("book_price");
          String	userAddress		= rs.getString("user_address");
          Date		billDate		= rs.getDate("bill_date");
          Bill bill = new Bill();
          bill.setUserName(userName);
          bill.setBillCode(billCode);
          bill.setBookCode(bookCode);
          bill.setBookName(bookName);
          bill.setBookQuantity(bookQuantity);
          bill.setBookPrice(bookPrice);
          bill.setUserAddress(userAddress);
          bill.setBillDate(billDate);
          list.add(bill);
      }
      return list;
  }
  
  // History------------------------------------------------------------------------
  
  public static void addToHistory(Connection conn, String billCode, String userName, int totalPrice, Date billDate, int pointUse) throws SQLException {
      String sql = "insert into history(user_name, bill_code, bill_date, total_price, point_use) "
    		  		+ "value(?,?,?,?,?)";
      
      PreparedStatement pstm = conn.prepareStatement(sql);
      
      pstm.setString(1, userName);
      pstm.setString(2, billCode);
      pstm.setDate(3, billDate);
      pstm.setInt(4, totalPrice);
      pstm.setInt(5, pointUse);
 
      pstm.executeUpdate();
  }
  
  public static List<History> getHistory(Connection conn, String userName) throws SQLException {
      String sql = "Select a.user_name, a.bill_code, a.bill_date, a.total_price, a.point_use "
      				+ "from history a where a.user_name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      ResultSet rs = pstm.executeQuery();
      List<History> list = new ArrayList<History>();
      while (rs.next()) {
          String 	billCode 		= rs.getString("bill_code");
          Date		billDate		= rs.getDate("bill_date");
          int		totalPrice		= rs.getInt("total_price");
          int		pointUse		= rs.getInt("point_use");
          History history = new History();
          history.setUserName(userName);
          history.setBillCode(billCode);
          history.setBillDate(billDate);
          history.setTotalPrice(totalPrice);
          history.setPointUse(pointUse);
          list.add(history);
      }
      return list;
  }
  
  public static History findHistory(Connection conn, String userName, String billCode) throws SQLException {
      String sql = "Select a.user_name, a.bill_code, a.bill_date, a.total_price, a.point_use "
      				+ "from history a where a.user_name = ? and a.bill_code = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, billCode);
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
          Date		billDate		= rs.getDate("bill_date");
          int		totalPrice		= rs.getInt("total_price");
          int		pointUse		= rs.getInt("point_use");
          History history = new History();
          history.setUserName(userName);
          history.setBillCode(billCode);
          history.setBillDate(billDate);
          history.setTotalPrice(totalPrice);
          history.setPointUse(pointUse);
          return history;
      }
      return null;
  }
  
}
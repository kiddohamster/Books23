package books23.beans;

import java.sql.Date;
 
public class Bill {
    
	private		String		userName;
	private		String		billCode;
	private 	String 		bookCode;
	private		String		bookName;
	private 	int 		bookQuantity;
	private 	int 		bookPrice;
	private		String		userAddress;
	private		Date		billDate;
	
	public Bill(){
		
	}
   
	public Bill(String userName, String billCode, String bookCode, String bookName, int bookQuantity, 
				int bookPrice, String userAddress, Date billDate) {
		this.userName 		= 	userName;
		this.billCode		=	billCode;
		this.bookCode 		= 	bookCode;
		this.bookName		= 	bookName;
		this.bookQuantity 	= 	bookQuantity;
		this.bookPrice 		= 	bookPrice;
		this.userAddress	=	userAddress;
		this.billDate		=	billDate;
	}
    
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getBillCode() {return billCode;}
	public void setBillCode(String billCode) {this.billCode = billCode;}
	
	public String getBookName() {return bookName;}
	public void setBookName(String bookName) {this.bookName = bookName;}
	
	public String getBookCode() {return bookCode;}
	public void setBookCode(String bookCode) {this.bookCode = bookCode;}
 
	public int getBookQuantity() {return bookQuantity;}
	public void setBookQuantity(int bookQuantity) {this.bookQuantity = bookQuantity;}
   
	public int getBookPrice() {return bookPrice;}
	public void setBookPrice(int bookPrice) {this.bookPrice = bookPrice;}
	
	public String getUserAddress() {return userAddress;}
	public void setUserAddress(String userAddress) {this.userAddress = userAddress;}
	
	public Date getBillDate() {return billDate;}
	public void setBillDate(Date billDate) {this.billDate = billDate;}
 
}
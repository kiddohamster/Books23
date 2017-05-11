package books23.beans;
 
public class Cart {
    
	private		String		userName;
	private 	String 		bookCode;
	private		String		bookName;
	private 	String 		bookImageUrl;
	private 	int 		bookQuantity;
	private 	int 		bookPrice;
	
	public Cart(){
		
	}
   
	public Cart(String userName, String bookCode, String bookName, String bookImageUrl, int bookQuantity, int bookPrice) {
		this.userName 		= 	userName;
		this.bookCode 		= 	bookCode;
		this.bookName		= 	bookName;
		this.bookImageUrl 	=	bookImageUrl;
		this.bookQuantity 	= 	bookQuantity;
		this.bookPrice 		= 	bookPrice;
	}
    
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getBookName() {return bookName;}
	public void setBookName(String bookName) {this.bookName = bookName;}
	
	public String getBookCode() {return bookCode;}
	public void setBookCode(String bookCode) {this.bookCode = bookCode;}
 
	public String getBookImageUrl() {return bookImageUrl;}
	public void setBookImageUrl(String bookImageUrl) {this.bookImageUrl = bookImageUrl;}
 
	public int getBookQuantity() {return bookQuantity;}
	public void setBookQuantity(int bookQuantity) {this.bookQuantity = bookQuantity;}
   
	public int getBookPrice() {return bookPrice;}
	public void setBookPrice(int bookPrice) {this.bookPrice = bookPrice;}
 
}
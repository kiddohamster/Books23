package books23.beans;

import java.sql.Date;
 
public class History {
    
	private		String		userName;
	private		String		billCode;
	private		Date		billDate;
	private		int			totalPrice;
	private		int			pointUse;
	
	public History(){
		
	}
   
	public History(String userName, String billCode, Date billDate, int totalPrice, int pointUse) {
		this.userName 		= 	userName;
		this.billCode		=	billCode;
		this.billDate		=	billDate;
		this.totalPrice		= 	totalPrice;
		this.pointUse		=	pointUse;
	}
    
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getBillCode() {return billCode;}
	public void setBillCode(String billCode) {this.billCode = billCode;}
	
	public Date getBillDate() {return billDate;}
	public void setBillDate(Date billDate) {this.billDate = billDate;}
	
	public int getTotalPrice() {return totalPrice;}
	public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}
	
	public int getPointUse() {return pointUse;}
	public void setPointUse(int pointUse) {this.pointUse = pointUse;}
 
}
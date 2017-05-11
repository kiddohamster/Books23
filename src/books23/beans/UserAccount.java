package books23.beans;
 
public class UserAccount {
 
   public static final String GENDER_MALE ="M";
   public static final String GENDER_FEMALE = "F";
    
   private String userName;
   private String gender;
   private String password;
   private String fullName;
   private String email;
   private String phone;
   private String address;
   private int    point;
   private String avatarUrl;
   private String bank;
   private String creditCard;
    
   public UserAccount(){
	   
   }
   
   public UserAccount(String userName, String gender, String password, String fullName, String email, String phone, 
		   				String address, int point, String avatarUrl, String bank, String creditCard) {
	   this.userName 	= 	userName;
	   this.gender 		=	gender;
	   this.password 	= 	password;
	   this.fullName 	= 	fullName;
	   this.email 		= 	email;
	   this.phone 		= 	phone;
	   this.address 	= 	address;
	   this.point 		= 	point;
	   this.avatarUrl	= 	avatarUrl;
	   this.bank		= 	bank;
	   this.creditCard 	= 	creditCard;
   }
    
   public String getUserName() {return userName;}
   public void setUserName(String userName) {this.userName = userName;}
 
   public String getGender() {return gender;}
   public void setGender(String gender) {this.gender = gender;}
 
   public String getPassword() {return password;}
   public void setPassword(String password) {this.password = password;}
   
   public String getFullName() {return fullName;}
   public void setFullName(String fullName) {this.fullName = fullName;}
   
   public String getEmail() {return email;}
   public void setEmail(String email) {this.email = email;}
   
   public String getPhone() {return phone;}
   public void setPhone(String phone) {this.phone = phone;}
   
   public String getAddress() {return address;}
   public void setAddress(String address) {this.address = address;}
   
   public int getPoint() {return point;}
   public void setPoint(int point) {this.point = point;}
   
   public String getAvatarUrl() {return avatarUrl;}
   public void setAvatarUrl(String avatarUrl) {this.avatarUrl = avatarUrl;}
   
   public String getBank() {return bank;}
   public void setBank(String bank) {this.bank = bank;}
   
   public String getCreditCard() {return creditCard;}
   public void setCreditCard(String creditCard) {this.creditCard = creditCard;}
 
}
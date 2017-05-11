package books23.beans;

import java.sql.Timestamp;
 
public class Product {
 
   private 	String 		code;
   private 	String 		name;
   private 	int 		price;
   private 	String 		author;
   private 	String 		category;
   private 	String 		info;
   private 	int 		rating;
   private 	String 		imageUrl;
   private 	int 		quantity;
   private	Timestamp 	addTime;
 
   public Product() {
 
   }
 
   public Product(String code, String name, int price, String author, String category, 
		   			String info, int rating, String imageUrl, int quantity, Timestamp addTime) {
       this.code = code;
       this.name = name;
       this.price = price;
       this.author = author;
       this.category = category;
       this.info = info;
       this.rating = rating;
       this.imageUrl = imageUrl;
       this.quantity = quantity;
       this.addTime = addTime;
   }
 
   public String getCode() {return code;}
   public void setCode(String code) {this.code = code;}
 
   public String getName() {return name;}
   public void setName(String name) {this.name = name;}
 
   public int getPrice() {return price;}
   public void setPrice(int price) {this.price = price;}
   
   public String getAuthor() {return author;}
   public void setAuthor(String author) {this.author = author;}
   
   public String getCategory() {return category;}
   public void setCategory(String category) {this.category = category;}
   
   public String getInfo() {return info;}
   public void setInfo(String info) {this.info = info;}
   
   public String getImageUrl() {return imageUrl;}
   public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
   
   public int getRating() {return rating;}
   public void setRating(int rating) {this.rating = rating;}
   
   public int getQuantity() {return quantity;}
   public void setQuantity(int quantity) {this.quantity = quantity;}
   
   public Timestamp getAddTime() {return addTime;}
   public void setAddTime(Timestamp addTime) {this.addTime = addTime;}
 
}
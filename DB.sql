-- create table
create table user_account
(
user_name 	varchar(255)	not null,
gender    	varchar(1) 				,
password  	varchar(255) 	not null,
full_name	varchar(255) 	not null,
email		varchar(255) 	not null,
phone		varchar(11) 	not null,
point		mediumint		not null,
address		varchar(255)	not null,
avatar_url	varchar(255)			,
bank		varchar(255)			,
credit_card	varchar(255)			,
primary key (user_name)
);
 
-- create table
create table product
(
code  		varchar(255) 	not null,
name  		varchar(255) 	not null,
author		varchar(255)	not null,
price 		int 			not null,
category	varchar(255)			,
rating		int(5)					,
info		varchar(255)			,
image_url	varchar(255)			,
quantity	int				not null,
add_time	timestamp		not null,
primary key (code)
) ;

-- create table
create table cart
(
user_name		varchar(255)	not null,
book_code		varchar(255)	not null,
book_name		varchar(255)	not null,
book_image_url	varchar(255)			,
book_quantity	int				not null,
book_price		int				not null
) ;

-- create table
create table bill
(
user_name		varchar(255)	not null,
bill_code		varchar(255)	not null,
book_code		varchar(255)	not null,
book_name		varchar(255)	not null,
book_quantity	int				not null,
book_price		int				not null,
total_price		int				not null,
user_address	varchar(255)	not null,
bill_time		timestamp		not null
) ;

-- create table

create table history
(
user_name		varchar(255)	not null,
bill_code		varchar(255)	not null,
point_use		int				not null,
total_price		int				not null,
bill_date		date			not null
) ;
 
-- insert data: ---------------------------------------------------------------
 
insert into user_account (user_name, password, full_name, email, phone, point, address)
values ('admin', 'books23admin', 'admin', '', '', '0', '');

-- insert products:

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0000', 'Thất lạc cõi người', 'Dazai Osamu', '88000', 'Văn học nước ngoài', '0', '', 'http://www.sachkhaitam.com/Data/Sites/1/Product/5179/thatlaccoi-sachkhaitam.jpg', '4', '2017-04-20 21:16:49');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0001', 'Khu vườn ngôn từ', 'Shinkai Makoto', '95000', 'Văn học nước ngoài', '0', '', 'https://upload.wikimedia.org/wikipedia/vi/c/c4/Khuvuonngontu.jpg', '4', '2017-04-20 21:16:09');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0002', 'Ame và Yuki - Những đứa con cuser_accountủa sói ', 'Mamoru Hosoda', '60000', 'Văn học nước ngoài', '0', '', 'https://vcdn.tikicdn.com/cache/w300/media/catalog/product/w/o/wolf-children---inner-cover---final.png', '4', '2017-04-20 21:15:51');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0003', 'Thuyết tương đối hẹp và rộng Albert Einstein ', 'Nguyễn Xuân Xanh ', '99000', 'Khoa học', '0', '', 'https://vcdn.tikicdn.com/cache/w300/media/catalog/product/i/m/img300_13.jpg', '4', '2017-04-20 21:15:22');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0004', 'Vũ trụ trong vỏ hạt dẻ', 'Stephen Hawking', '75000', 'Khoa học', '0', '', 'http://isach.info/images/story/cover/vu_tru_trong_vo_hat_de__stephen_hawking.jpg', '4', '2017-04-20 21:14:54');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0005', 'Lược sử thời gian', 'Stephen Hawking', '75000', 'Khoa học', '0', '', 'http://www.taisachhay.com/wp-content/uploads/2015/06/luoc-su-thoi-gian-stephen-hawking.jpg', '4', '2017-04-20 21:14:37');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0006', 'Quốc gia khởi nghiệp', 'Dan Senor & Saul Singer', '99000', '', '0', '', 'https://vcdn.tikicdn.com/cache/w300/media/catalog/product/q/u/quoc-gia-khoi-nghiep-a_2.jpg', '4', '2017-04-20 21:10:07');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0007', '5 centimet trên giây', 'Shinkai Makoto', '50000', 'Văn học nước ngoài', '0', '', 'https://vcdn.tikicdn.com/cache/w300/media/catalog/product/5/-/5-centimet-tren-giay.jpg', '4', '2017-04-20 21:08:08');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0008', 'Chú chó gác sao (Boxset 2 tập)', 'Takashi Murakami', '80000', 'Văn học nước ngoài', '0', '', 'http://pibook.vn/uploads/products/73437_05_04_17_chu-cho-gac-sao-boxset.jpg', '4', '2017-04-20 21:08:26');

insert into product (code, name, author, price, category, rating, info, image_url, quantity, add_time)
values ('B23_0009', 'Tiếng gọi từ vì sao xa', 'Shinkai Makoto', '65000', 'Văn học nước ngoài', '0', '', 'https://vcdn.tikicdn.com/cache/w300/media/catalog/product/c/o/cover%201.u547.d20160822.t173705.18225.jpg', '4', '2017-04-20 21:09:21');
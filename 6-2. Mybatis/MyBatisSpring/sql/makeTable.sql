drop table product;
create table product(
	code int AUTO_INCREMENT PRIMARY key,
    name varchar(10),
    price int,
    pictureurl varchar(20),
    description varchar(20)
);

insert into product values(10,'안녕',1000,'없어','나의 데이터');
select * from product;
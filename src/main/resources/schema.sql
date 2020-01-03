drop table if exists bank.customer_details;
create table bank.customer_details(
cust_id	        INT                 PRIMARY KEY   AUTO_INCREMENT	,
create_date	    TIMESTAMP           NOT NULL	,		           
user_id	        INT          	    NOT NULL      UNIQUE,
first_name	    varchar(255)	    NOT NULL	,
last_name	    varchar(255)	    NOT NULL	,
middle_name	    varchar(255)	    NOT NULL	,
email	        varchar(255)	    NOT NULL      UNIQUE,		
mobile	        varchar(255)	    NOT NULL      UNIQUE,		
expire_date     TIMESTAMP ,
FOREIGN KEY (user_id) REFERENCES bank.User_details(user_id)
);

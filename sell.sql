drop table if exists product_info;
drop table if exists product_category;
drop table if exists order_master;
drop table if exists order_detail;


create table `product_info`(
	`product_id` varchar(32) not null,
	`product_name` varchar(64) not null comment '商品名称',
	`product_price` decimal(8,2) not null comment '商品价格',
	`product_stock` int not null comment '商品库存',
	`product_description` varchar(64) not null comment '商品描述',
	`product_icon` varchar(512) comment '商品图',
	`category_type` int not null comment '种类',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	`update_time` timestamp not null default current_timestamp on update current_timestamp 	comment '更新时间',
	primary key (product_id)
)comment '商品信息';

create table product_category (
	category_id int not null auto_increment,
	category_name varchar(64) not null comment '类目名字',
	category_type int not null comment '类目编号',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp 	comment '更新时间',
	primary key (category_id),
	unique key (category_type)
);

create table order_master (
	order_id varchar(32) not null,
	buyer_name varchar(32) not null comment '卖家名字',
	buyer_phone varchar(32) not null comment '卖家电话',
	buyer_address varchar(128) not null comment '卖家地址',
	buyer_openid varchar(32) not null comment '微信openid',
	order_amount varchar(32) not null comment '总价',
	pay_status varchar(32) not null comment '支付状态',
	order_status varchar(32) not null comment '订单状态',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp 	comment '更新时间',
	primary key (order_id),
	key idx_buyer_openid (buyer_openid)
);

create table order_detail(
	detail_id varchar(32) not null,
	order_id varchar(32) not null,
	product_id varchar(32) not null,
	product_name varchar(32) not null comment '商品名称',
	product_price decimal(8,2) not null comment '商品价格',
	product_quantity int not null comment'商品数量',
	product_icon varchar(512) comment '商品小图',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp 	comment '更新时间',
	primary key (detail_id),
	key idx_order_id (order_id)
);

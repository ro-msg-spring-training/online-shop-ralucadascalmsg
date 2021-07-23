create table `product_category` (
    `id` integer not null auto_increment PRIMARY KEY,
    `name` varchar(255),
    `description` varchar(255)
);

create table `supplier` (
    `id` integer not null auto_increment PRIMARY KEY,
    `name` varchar(255)
);


create table `product` (
    `id` integer not null auto_increment  PRIMARY KEY,
    `name` varchar(255),
    `description` varchar(255),
    `price` numeric,
    `weight` real,
    `category_id` int REFERENCES product_category(id),
    `supplier_id` int REFERENCES supplier(id),
    `image_url` varchar(255)
);

create table `location` (
    `id` integer not null auto_increment PRIMARY KEY,
    `name` varchar(255),
    `address_country` varchar(255),
    `address_city` varchar(255),
    `address_county` varchar(255),
    `address_street_address` varchar(255)
);

create table `stock` (
    `id` integer not null auto_increment PRIMARY KEY,
    `product_id` int REFERENCES product(id),
    `location_id` int REFERENCES location(id),
    `quantity` int
);

create table `customer` (
    `id` integer not null auto_increment PRIMARY KEY,
    `firstname` varchar(255),
    `lastname` varchar(255),
    `username` varchar(255),
    `password` varchar(255),
    `email_address` varchar(255)
);

create table `orderT` (
    `id` integer not null auto_increment PRIMARY KEY,
    `shipped_from_id` int REFERENCES location(id),
    `customer_id` int REFERENCES customer(id),
    `created_at` DATETIME,
    `address_country` varchar(255),
    `address_city` varchar(255),
    `address_county` varchar(255),
    `address_street_address` varchar(255)
);

create table `order_detail` (
    `id` integer not null auto_increment PRIMARY KEY,
    `order_id` int REFERENCES orderT(id),
    `product_id` int REFERENCES product(id),
    `quantity` int
);

create table `revenue` (
    `id` integer not null auto_increment PRIMARY KEY,
    `location_id` int REFERENCES location(id),
    `date` DATETIME,
    `sum` numeric
);



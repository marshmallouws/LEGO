DROP DATABASE IF EXISTS lego;
CREATE DATABASE lego;


USE lego;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE l_order(
	id INT AUTO_INCREMENT PRIMARY KEY,
    userid INT NOT NULL,
    height INT NOT NULL,
    length INT NOT NULL,
    width INT NOT NULL,
    o_date DATETIME NOT NULL,
    CONSTRAINT user_order
		FOREIGN KEY (userid)
        REFERENCES `user`(id)
);

CREATE TABLE o_status(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    state VARCHAR(40) NOT NULL
);

CREATE TABLE order_status(
	orderid INT NOT NULL,
    statusid INT NOT NULL,
    s_date DATETIME,
    PRIMARY KEY(orderid, statusid),
    CONSTRAINT order_status_status
		FOREIGN KEY (statusid)
        REFERENCES o_status(id),
	CONSTRAINT order_status_order
		FOREIGN KEY (orderid)
        REFERENCES l_order(id)
);

CREATE TABLE piece(
	id INT AUTO_INCREMENT PRIMARY KEY,
    length INT NOT NULL,
    depth INT NOT NULL
);

INSERT INTO `user` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee');

INSERT INTO o_status VALUES
(1, 'recieved'),
(2, 'shipped'),
(3, 'delivered');
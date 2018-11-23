DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS packet;
DROP TABLE IF EXISTS video;
DROP TABLE IF EXISTS glasses;

CREATE TABLE users (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(50),
    password CHAR(32),
    role INT(1) DEFAULT '1',
    video_count INT(3) DEFAULT '0',
    last_pay_date TIMESTAMP NULL DEFAULT NULL,
    expiration_date TIMESTAMP NULL DEFAULT NULL,
    packet_id INT(6),
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--    ,FOREIGN KEY (packet_id) REFERENCES packet(id)
);

CREATE TABLE packet (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    video_count INT(4)
);

CREATE TABLE video (
    video_name VARCHAR(50),
    packet_id INT(6)
--    ,FOREIGN KEY (packet_id) REFERENCES packet(id)
);

CREATE TABLE glasses (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    rooted TINYINT(1),
    user_id INT(6) DEFAULT NULL,
    merchant_id INT(6) DEFAULT NULL,
    status INT(1)
);
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
    packet_id INT(6) NOT NULL,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE packet (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    video_count INT(4)
);

CREATE TABLE video (
    video_name VARCHAR(50),
    packet_id INT(6) NOT NULL
) ENGINE=INNODB;

CREATE TABLE glasses (
    id VARCHAR(50) PRIMARY KEY NOT NULL,
    rooted TINYINT(1) DEFAULT 0,
    status_virtual INT(2) DEFAULT 0,
    status_physical INT(2) DEFAULT 0,
    user_id INT(6) DEFAULT NULL,
    merchant_id INT(6) DEFAULT NULL
);

--mvn flyway:clean -Dflyway.configFile=application.yml
--mvn flyway:migrate -Dflyway.configFile=application.yml
--mvn flyway:repair -Dflyway.configFile=application.yml

-- мб лучше взять пакет1: видео1, пакет1: видео2, пакет2: видео2?
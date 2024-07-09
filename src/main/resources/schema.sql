create table test(
    id int auto_increment,
    title varchar(55) NOT NULL,
    pages int NOT NULL
);

CREATE TABLE USERS (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       DISPLAYNAME VARCHAR(255),
                       INTEREST_PEANUT BOOLEAN,
                       INTEREST_EGG BOOLEAN,
                       INTEREST_DAIRY BOOLEAN
);

-- src/main/resources/schema.sql

-- Create USERS table
CREATE TABLE USERS (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       DISPLAYNAME VARCHAR(255) NOT NULL UNIQUE,
                       INTEREST_PEANUT BOOLEAN,
                       INTEREST_EGG BOOLEAN,
                       INTEREST_DAIRY BOOLEAN
);

-- Create RESTAURANT table
CREATE TABLE RESTAURANT (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            NAME VARCHAR(255),
                            ADDRESS VARCHAR(255),
                            CITY VARCHAR(255),
                            STATE VARCHAR(255),
                            ZIPCODE VARCHAR(255) -- Adjusted to VARCHAR(255) to match entity definition
);

-- Create RESTAURANT_ALLERGIES table
CREATE TABLE RESTAURANT_ALLERGIES (
                                      restaurant_id BIGINT,
                                      allergy VARCHAR(50),
                                      PRIMARY KEY (restaurant_id, allergy),
                                      FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT(id)
);

-- Create DINING_REVIEWS table
CREATE TABLE DINING_REVIEWS (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                REVIEW_TITLE VARCHAR(255),
                                USER_NAME VARCHAR(255),
                                PEANUT_SCORE INT,
                                EGG_SCORE INT,
                                DAIRY_SCORE INT,
                                COMMENTARY VARCHAR(255), -- Adjusted to VARCHAR(255) to match entity definition
                                restaurant_id BIGINT,
                                user_id BIGINT,
                                CONSTRAINT FK_RESTAURANT FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT(id),
                                CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES USERS(id)
);
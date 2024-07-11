-- src/main/resources/data.sql

-- Insert Users
INSERT INTO USERS (DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES ('John Doe', true, false, true);
INSERT INTO USERS (DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES ('Jane Smith', false, true, false);
INSERT INTO USERS (DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES ('Alice Johnson', true, true, true);
INSERT INTO USERS (DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES ('Bob Brown', false, false, false);
INSERT INTO USERS (DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES ('Charlie Green', true, false, false);

-- Insert Restaurants
INSERT INTO RESTAURANT (NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES ('Good Eats', '123 Main St', 'Townsville', 'TS', '12345');
INSERT INTO RESTAURANT (NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES ('Yummy Place', '456 Side St', 'Villageton', 'VT', '67890');
INSERT INTO RESTAURANT (NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES ('Tasty Corner', '789 Elm St', 'Hamlet', 'HT', '11223');
INSERT INTO RESTAURANT (NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES ('Savory Spot', '101 Pine St', 'Metropolis', 'MP', '33445');
INSERT INTO RESTAURANT (NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES ('Delicious Diner', '202 Oak St', 'Shire', 'SH', '55667');

-- Insert Restaurant Allergies (Adjust as needed based on your data)
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (1, 'PEANUT_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (1, 'DAIRY_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (2, 'EGG_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (3, 'PEANUT_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (4, 'DAIRY_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (4, 'EGG_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (5, 'PEANUT_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (5, 'DAIRY_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (5, 'EGG_FREE');

-- Insert Dining Reviews (Adjust as needed based on your data)
INSERT INTO DINING_REVIEWS (REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES ('Great Place!', 'John Doe', 5, 4, 3, 'Really enjoyed the food, great for peanut allergy.', 1, 1);
INSERT INTO DINING_REVIEWS (REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES ('Not Bad', 'Jane Smith', 3, 5, 2, 'Good food, but not great for dairy allergy.', 2, 2);
INSERT INTO DINING_REVIEWS (REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES ('Excellent!', 'Alice Johnson', 4, 4, 4, 'Wonderful experience, safe for all allergies.', 3, 3);
INSERT INTO DINING_REVIEWS (REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES ('Could be better', 'Bob Brown', 2, 3, 1, 'Food was okay, not very allergy-friendly.', 4, 4);
INSERT INTO DINING_REVIEWS (REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES ('Just Okay', 'Charlie Green', 3, 3, 3, 'Average experience, decent food.', 5, 5);
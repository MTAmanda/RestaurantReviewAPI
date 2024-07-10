-- src/main/resources/data.sql

-- Insert Users
INSERT INTO USERS (id, DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES (1, 'John Doe', true, false, true);
INSERT INTO USERS (id, DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES (2, 'Jane Smith', false, true, false);
INSERT INTO USERS (id, DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES (3, 'Alice Johnson', true, true, true);
INSERT INTO USERS (id, DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES (4, 'Bob Brown', false, false, false);
INSERT INTO USERS (id, DISPLAYNAME, INTEREST_PEANUT, INTEREST_EGG, INTEREST_DAIRY) VALUES (5, 'Charlie Green', true, false, false);

-- Insert Restaurants
INSERT INTO RESTAURANT (id, NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES (1, 'Good Eats', '123 Main St', 'Townsville', 'TS', '12345');
INSERT INTO RESTAURANT (id, NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES (2, 'Yummy Place', '456 Side St', 'Villageton', 'VT', '67890');
INSERT INTO RESTAURANT (id, NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES (3, 'Tasty Corner', '789 Elm St', 'Hamlet', 'HT', '11223');
INSERT INTO RESTAURANT (id, NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES (4, 'Savory Spot', '101 Pine St', 'Metropolis', 'MP', '33445');
INSERT INTO RESTAURANT (id, NAME, ADDRESS, CITY, STATE, ZIPCODE) VALUES (5, 'Delicious Diner', '202 Oak St', 'Shire', 'SH', '55667');

-- Insert Restaurant Allergies
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (1, 'PEANUT_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (1, 'DAIRY_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (2, 'EGG_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (3, 'PEANUT_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (4, 'DAIRY_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (4, 'EGG_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (5, 'PEANUT_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (5, 'DAIRY_FREE');
INSERT INTO RESTAURANT_ALLERGIES (restaurant_id, allergy) VALUES (5, 'EGG_FREE');


-- Insert Dining Reviews
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (1, 'Great Place!', 'John Doe', 5, 4, 3, 'Really enjoyed the food, great for peanut allergy.', 1, 1);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (2, 'Not Bad', 'Jane Smith', 3, 5, 2, 'Good food, but not great for dairy allergy.', 2, 2);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (3, 'Excellent!', 'Alice Johnson', 4, 4, 4, 'Wonderful experience, safe for all allergies.', 3, 3);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (4, 'Could be better', 'Bob Brown', 2, 3, 1, 'Food was okay, not very allergy-friendly.', 4, 4);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (5, 'Just Okay', 'Charlie Green', 3, 3, 3, 'Average experience, decent food.', 5, 5);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (6, 'Loved it!', 'John Doe', 5, 5, 5, 'Amazing food, very allergy-friendly.', 2, 1);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (7, 'Will come again', 'Jane Smith', 4, 4, 4, 'Great food and atmosphere.', 3, 2);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (8, 'Fantastic!', 'Alice Johnson', 5, 5, 5, 'Loved everything about this place.', 4, 3);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (9, 'Not Impressed', 'Bob Brown', 2, 2, 2, 'Not what I expected, could be better.', 5, 4);
INSERT INTO DINING_REVIEWS (id, REVIEW_TITLE, USER_NAME, PEANUT_SCORE, EGG_SCORE, DAIRY_SCORE, COMMENTARY, restaurant_id, user_id)
VALUES (10, 'Good but not great', 'Charlie Green', 3, 3, 3, 'It was fine, but could be improved.', 1, 5);

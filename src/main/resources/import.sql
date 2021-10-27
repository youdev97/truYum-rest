INSERT INTO user(us_id, us_name) VALUES ('1', 'younes');
INSERT INTO user(us_id, us_name) VALUES ('2', 'people1');
INSERT INTO user(us_id, us_name) VALUES ('3', 'people2');

INSERT INTO role(ro_id, ro_name) VALUES ('1', 'admin');
INSERT INTO role(ro_id, ro_name) VALUES ('2', 'user');

INSERT INTO user_role (ur_id, ur_ro_id, ur_us_id) VALUES ('1', '1', '1');
INSERT INTO user_role (ur_id, ur_ro_id, ur_us_id) VALUES ('2', '2', '2');
INSERT INTO user_role (ur_id, ur_ro_id, ur_us_id) VALUES ('3', '2', '3');

INSERT INTO menu_item(me_id, me_active, me_category, me_date_of_launch, me_free_delivery, me_name, me_price) VALUES (1, 1, 'Dessert', '2020-02-12', 1, 'Cheesecake', '99.00');
INSERT INTO menu_item(me_id, me_active, me_category, me_date_of_launch, me_free_delivery, me_name, me_price) VALUES (2, 1, 'Main Course', '2021-06-06', 0, 'Burger', '129.00');
INSERT INTO menu_item(me_id, me_active, me_category, me_date_of_launch, me_free_delivery, me_name, me_price) VALUES (3, 0, 'Sides', '2021-06-06', 1, 'Fries', '68.00');

INSERT INTO cart(ct_id, ct_pr_id, ct_us_id) VALUES (3, 2, 1);
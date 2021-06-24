USE `lch_marketplace`;

INSERT into
    menu_item(
        me_id,
        me_name,
        me_price,
        me_active,
        me_date_of_launch,
        me_category,
        me_free_delivery
    )
VALUES
    (
        1,
        'Sandwich',
        99.00,
        1,
        '2017-03-15',
        'Main Course',
        1
    ),
    (
        2,
        'Burger',
        129.00,
        1,
        '2017-12-23',
        'Main Course',
        0
    ),
    (
        3,
        'Pizza',
        149.00,
        1,
        '2018-08-21',
        'Main Course',
        0
    ),
    (
        4,
        'French Fries',
        57.00,
        0,
        '2017-07-02',
        'Starters',
        1
    ),
    (
        5,
        'Chocolate Brownie',
        32.00,
        1,
        '2022-11-02',
        'Dessert',
        0
    );

INSERT into
    user(us_id, us_name)
VALUES
    ('1', 'younes');

INSERT into
    role(ro_id, ro_name)
VALUES
    ('1', 'admin');

INSERT into
    user_role(ur_role_id, ur_us_id, _ur_ro_id)
VALUES
    ('1', '1', '1');

INSERT into
    cart(ct_us_id, ct_pr_id)
VALUES
    ('2', '1', '3'),
    ('3', '1', '2');
-- Step 2: SQL DML and basic queries. Execute in order after step 1.

-- Exercise 1: Insert Ana into customers, relying on the default fields.

INSERT INTO customers (name, email)
VALUES ('Ana Souza', 'ana@example.com');

-- Exercise 2: Attempt to insert a duplicate email to observe the UNIQUE constraint. Keep this INSERT commented out afterward.

/*
INSERT INTO customers (name, email)
VALUES ('Duplicate Ana', 'ana@example.com');
*/

-- Exercise 3: Insert three additional example customers, some with phone numbers.

INSERT INTO customers (name, email, phone)
VALUES ('Bruno Lima','bruno@example.com', '85999990001');

INSERT INTO customers (name, email)
VALUES ('Carla Mendes', 'carla@example.com');

INSERT INTO customers (name, email, phone)
VALUES ('Diego Alves', 'diego@example.com', '85999990003');

-- Exercise 4: List customers with phone numbers, ordered by name descending.

SELECT name, email, phone
FROM customers
WHERE phone IS NOT NULL
ORDER BY name DESC;

-- Exercise 5: Deactivate the example customer identified by email.

UPDATE customers
SET active = false
WHERE email = 'diego@example.com';

-- Exercise 6: Delete only deactivated customers.

DELETE FROM customers
WHERE active = false;

-- Exercise 7: Insert four sample products.

INSERT INTO products (name, category, price, stock)
VALUES ('Mechanical Keyboard', 'Peripherals', 250.00, 10);

INSERT INTO products (name, category, price, stock)
VALUES ('Wireless Mouse', 'Peripherals', 120.00, 20);

INSERT INTO products (name, category, price, stock)
VALUES ('24-inch Monitor', 'Monitors', 900.00, 8);

INSERT INTO products (name, category, price, stock)
VALUES ('Desk Stand', 'Accessories', 150.00, 12);

-- Exercise 8: Create three orders, allowing one to use the default PENDING status.

INSERT INTO orders (customer_id, status)
VALUES (1, 'PAID');

INSERT INTO orders (customer_id)
VALUES (1);

INSERT INTO orders (customer_id, status)
VALUES (3, 'PAID');

-- Exercise 9: Insert five order items with quantities and unit prices.

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES (1, 1, 1, 250.00);

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES (1, 2, 2, 120.00);

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES (2, 3, 1, 900.00);

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES (3, 2, 1, 120.00);

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES (3, 4, 2, 150.00);

-- Step 3: queries, joins and aggregation. The final UNION is deliberately not solved.

-- Exercise 1: Use INNER JOIN to list the ID, customer name and status of every order.

SELECT orders.id, customers.name, orders.status
FROM orders
INNER JOIN customers
    ON orders.customer_id = customers.id
ORDER BY orders.id;

-- Exercise 2: Use LEFT JOIN to include customers without orders.

SELECT customers.name, orders.id, orders.status
FROM customers
LEFT JOIN orders
    ON customers.id = orders.customer_id
ORDER BY customers.id, orders.id;

-- Exercise 3: Join orders, customers, order_items and products to calculate item subtotals.

SELECT orders.id, customers.name, products.name, order_items.quantity, (order_items.quantity * order_items.unit_price) AS subtotal
FROM orders
INNER JOIN customers
    ON orders.customer_id = customers.id
INNER JOIN order_items
    ON orders.id = order_items.order_id
INNER JOIN products
    ON order_items.product_id = products.id
ORDER BY orders.id, products.id;

-- Exercise 4: Group products by category and report count and average price.

SELECT
    products.category,
    COUNT(*) AS product_count,
    AVG(products.price) AS average_price
FROM products
GROUP BY products.category
ORDER BY products.category;

-- Exercise 5: Use HAVING to keep categories containing at least two products.

SELECT
    products.category,
    COUNT(*) AS product_count,
    AVG(products.price) AS average_price
FROM products
GROUP BY products.category
HAVING COUNT(*) >= 2
ORDER BY products.category;

-- Exercise 6: Calculate each order's total using joins and SUM.

SELECT
    orders.id,
    customers.name,
    SUM(
        order_items.quantity * order_items.unit_price
    ) AS order_total
FROM orders
INNER JOIN customers
    ON orders.customer_id = customers.id
INNER JOIN order_items
    ON orders.id = order_items.order_id
GROUP BY orders.id, customers.name
ORDER BY orders.id;

-- Exercise 7: Use a subquery to select products priced above the average.

SELECT name, price
FROM products
WHERE price > (
    SELECT AVG(price)
    FROM products
)
ORDER BY price DESC;

-- Exercise 8: Exercise left unfinished: use UNION for a combined customer/product name list, labelled by type.

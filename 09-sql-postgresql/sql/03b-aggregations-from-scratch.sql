-- Rebuilding SQL aggregation from scratch. Predictions are preserved as learning evidence.

-- Exercise 1: Predict SUM of all product prices before executing the query.

/* Expected total_prices: 1420.00, the sum of all four product prices. */

SELECT SUM(price) AS total_prices
FROM products;

-- Exercise 2: Filter to the Peripherals category before summing.

/* Only the two Peripherals prices pass the filter; expected total: 370.00. */

SELECT SUM(price) AS total_peripherals
FROM products
WHERE category = 'Peripherals';

-- Exercise 3: Count the products in the Peripherals category.

/* Two rows belong to Peripherals; expected count: 2. */

SELECT COUNT(*) AS peripherals_count
FROM products
WHERE category = 'Peripherals';

-- Exercise 4: Compare COUNT(*) with COUNT(phone) when phone can be NULL.

/* COUNT(*) returns 3 customers, while COUNT(phone) returns 1 because only one phone is non-NULL. */

SELECT
    COUNT(*) AS total_customers,
    COUNT(phone) AS customers_with_phone
FROM customers;

-- Exercise 5: Calculate average price and predict the result first.

/* 1420.00 / 4 = 355.00. */

SELECT AVG(price) AS average_prices
FROM products;

-- Exercise 6: Group by category and calculate average price per category.

/* Three categories; expected averages: 185, 900 and 150. */

SELECT category, AVG(price) AS average_price
FROM products
GROUP BY category;

-- Exercise 7: Combine COUNT and SUM for each category.

/* Peripherals: count 2, sum 370.00; Monitors: count 1, sum 900.00; Accessories: count 1, sum 150.00. */

SELECT 
    category,
    COUNT(*) AS product_count,
    SUM(price) AS total_prices
FROM products
GROUP BY category;

-- Exercise 8: Use HAVING to retain categories with more than one product.

/* Only Peripherals has more than one product: count 2, sum 370.00. */

SELECT 
    category,
    COUNT(*) AS product_count,
    SUM(price) AS total_prices
FROM products
GROUP BY category
HAVING COUNT(*) > 1;

-- Exercise 9: Combine WHERE and HAVING in one aggregation query.

/* The 900.00 product fails WHERE. Peripherals and Accessories remain; only Peripherals passes HAVING. */

SELECT category, COUNT(*) AS product_count
FROM products
WHERE price < 500
GROUP BY category
HAVING COUNT(*) > 1;

-- Exercise 10: Write a new query without a template, filtering by stock, grouping, and ordering the category totals.

/* Stock >= 10 excludes the monitor; only Peripherals passes HAVING. Expected category_total: 370.00. */

SELECT category, SUM(price) AS category_total
FROM products
WHERE stock >= 10
GROUP BY category
HAVING SUM(price) > 200
ORDER BY category_total DESC;

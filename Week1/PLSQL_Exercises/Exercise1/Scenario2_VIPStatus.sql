-- Scenario2_VIPStatus.sql
-- Iterates through all customers and sets IsVIP to TRUE ('Y') for every
-- customer whose balance is over $10,000.

SET SERVEROUTPUT ON;

BEGIN
    FOR cust_rec IN (
        SELECT customer_id, name, balance
        FROM   customers
    )
    LOOP
        IF cust_rec.balance > 10000 THEN
            UPDATE customers
            SET    isvip = 'Y'
            WHERE  customer_id = cust_rec.customer_id;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || cust_rec.name ||
                ' (Balance: $' || cust_rec.balance ||
                ') upgraded to VIP status.');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update completed.');
END;
/

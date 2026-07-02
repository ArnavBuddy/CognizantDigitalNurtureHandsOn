-- Scenario1_LoanDiscount.sql
-- Loops through all customers and applies a 1% discount to the current
-- loan interest rate of every customer older than 60.

SET SERVEROUTPUT ON;

DECLARE
    v_new_rate LOANS.INTEREST_RATE%TYPE;
BEGIN
    FOR cust_rec IN (
        SELECT c.customer_id,
               c.name,
               c.age,
               l.loan_id,
               l.interest_rate
        FROM   customers c
        JOIN   loans l ON l.customer_id = c.customer_id
    )
    LOOP
        IF cust_rec.age > 60 THEN
            v_new_rate := ROUND(cust_rec.interest_rate * (1 - 0.01), 3);

            UPDATE loans
            SET    interest_rate = v_new_rate
            WHERE  loan_id = cust_rec.loan_id;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || cust_rec.name ||
                ' (Age: ' || cust_rec.age || ') - Interest rate reduced from ' ||
                cust_rec.interest_rate || '% to ' || v_new_rate || '%');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior citizen loan discount applied successfully.');
END;
/

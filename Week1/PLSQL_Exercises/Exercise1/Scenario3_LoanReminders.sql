-- Scenario3_LoanReminders.sql
-- Fetches all loans due within the next 30 days and prints a reminder
-- message for each customer.

SET SERVEROUTPUT ON;

DECLARE
    v_days_left NUMBER;
BEGIN
    FOR loan_rec IN (
        SELECT c.name,
               l.loan_id,
               l.due_date
        FROM   loans l
        JOIN   customers c ON c.customer_id = l.customer_id
        WHERE  l.due_date BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.due_date
    )
    LOOP
        v_days_left := TRUNC(loan_rec.due_date - SYSDATE);

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan #' || loan_rec.loan_id ||
            ' for customer ' || loan_rec.name ||
            ' is due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY') ||
            ' (' || v_days_left || ' day(s) remaining).');
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Loan due reminders generated successfully.');
END;
/

-- Scenario1_ProcessMonthlyInterest.sql
-- Stored procedure that applies 1% monthly interest to every savings
-- account's current balance.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    v_interest_rate CONSTANT NUMBER := 0.01;   -- 1% monthly interest
    v_new_balance   accounts.balance%TYPE;
BEGIN
    FOR acc_rec IN (
        SELECT account_id, balance
        FROM   accounts
        WHERE  account_type = 'SAVINGS'
    )
    LOOP
        v_new_balance := ROUND(acc_rec.balance * (1 + v_interest_rate), 2);

        UPDATE accounts
        SET    balance = v_new_balance
        WHERE  account_id = acc_rec.account_id;

        DBMS_OUTPUT.PUT_LINE(
            'Account #' || acc_rec.account_id ||
            ' - Balance updated from $' || acc_rec.balance ||
            ' to $' || v_new_balance);
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
END ProcessMonthlyInterest;
/

-- Test call
SET SERVEROUTPUT ON;
BEGIN
    ProcessMonthlyInterest;
END;
/

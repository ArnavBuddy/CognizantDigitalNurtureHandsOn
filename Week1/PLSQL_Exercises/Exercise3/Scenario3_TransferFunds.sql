-- Scenario3_TransferFunds.sql
-- Stored procedure that transfers a specified amount from one account to
-- another, first checking that the source account has sufficient balance.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account  IN accounts.account_id%TYPE,
    p_to_account    IN accounts.account_id%TYPE,
    p_amount        IN NUMBER
)
IS
    v_from_balance accounts.balance%TYPE;
    v_insufficient_funds EXCEPTION;
BEGIN
    SELECT balance INTO v_from_balance
    FROM   accounts
    WHERE  account_id = p_from_account
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        RAISE v_insufficient_funds;
    END IF;

    UPDATE accounts
    SET    balance = balance - p_amount
    WHERE  account_id = p_from_account;

    UPDATE accounts
    SET    balance = balance + p_amount
    WHERE  account_id = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Transferred $' || p_amount || ' from account #' || p_from_account ||
        ' to account #' || p_to_account || '.');

EXCEPTION
    WHEN v_insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
            'Transfer failed: account #' || p_from_account ||
            ' has insufficient balance ($' || v_from_balance ||
            ') for a transfer of $' || p_amount || '.');
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: one of the account numbers does not exist.');
END TransferFunds;
/

-- Test calls: one successful transfer, one that fails due to insufficient funds
SET SERVEROUTPUT ON;
BEGIN
    TransferFunds(p_from_account => 1001, p_to_account => 1003, p_amount => 5000);
    TransferFunds(p_from_account => 1005, p_to_account => 1002, p_amount => 10000);
END;
/

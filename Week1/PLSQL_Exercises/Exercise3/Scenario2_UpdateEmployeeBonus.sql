-- Scenario2_UpdateEmployeeBonus.sql
-- Stored procedure that adds a bonus percentage (passed as a parameter)
-- to the salary of every employee in a given department.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department  IN employees.department%TYPE,
    p_bonus_pct   IN NUMBER
)
IS
    v_new_salary employees.salary%TYPE;
BEGIN
    FOR emp_rec IN (
        SELECT employee_id, name, salary
        FROM   employees
        WHERE  department = p_department
    )
    LOOP
        v_new_salary := ROUND(emp_rec.salary * (1 + p_bonus_pct / 100), 2);

        UPDATE employees
        SET    salary = v_new_salary
        WHERE  employee_id = emp_rec.employee_id;

        DBMS_OUTPUT.PUT_LINE(
            'Employee ' || emp_rec.name ||
            ' - Salary updated from $' || emp_rec.salary ||
            ' to $' || v_new_salary ||
            ' (' || p_bonus_pct || '% bonus)');
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus applied to all employees in ' || p_department || ' department.');
END UpdateEmployeeBonus;
/

-- Test call
SET SERVEROUTPUT ON;
BEGIN
    UpdateEmployeeBonus(p_department => 'SALES', p_bonus_pct => 5);
END;
/

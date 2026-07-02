-- schema.sql
-- Sample tables and data used by all three stored procedures.
-- Run this once (fresh) before testing each procedure below.

CREATE TABLE accounts (
    account_id     NUMBER PRIMARY KEY,
    customer_id    NUMBER,
    account_type   VARCHAR2(10),   -- 'SAVINGS' or 'CURRENT'
    balance        NUMBER(12,2)
);

CREATE TABLE employees (
    employee_id    NUMBER PRIMARY KEY,
    name           VARCHAR2(50),
    department     VARCHAR2(20),
    salary         NUMBER(12,2)
);

INSERT INTO accounts VALUES (1001, 1, 'SAVINGS', 20000);
INSERT INTO accounts VALUES (1002, 2, 'SAVINGS', 15500);
INSERT INTO accounts VALUES (1003, 3, 'CURRENT',  8000);
INSERT INTO accounts VALUES (1004, 4, 'SAVINGS', 42000);
INSERT INTO accounts VALUES (1005, 5, 'CURRENT',  3000);
INSERT INTO accounts VALUES (1006, 6, 'SAVINGS',  9800);

INSERT INTO employees VALUES (201, 'Meera Pillai',       'SALES', 45000);
INSERT INTO employees VALUES (202, 'Rohan Kulkarni',     'SALES', 52000);
INSERT INTO employees VALUES (203, 'Ishaan Verma',       'IT',    60000);
INSERT INTO employees VALUES (204, 'Divya Subramaniam',  'SALES', 48000);
INSERT INTO employees VALUES (205, 'Karan Bhatt',        'IT',    71000);

COMMIT;

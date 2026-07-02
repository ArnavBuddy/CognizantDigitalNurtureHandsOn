-- schema.sql
-- Sample tables and data used by Scenario 1, Scenario 2 and Scenario 3.
-- Run this once before running the individual scenario scripts.

CREATE TABLE customers (
    customer_id   NUMBER PRIMARY KEY,
    name          VARCHAR2(50),
    age           NUMBER,
    balance       NUMBER(12,2),
    isvip         CHAR(1) DEFAULT 'N'
);

CREATE TABLE loans (
    loan_id        NUMBER PRIMARY KEY,
    customer_id    NUMBER REFERENCES customers(customer_id),
    interest_rate  NUMBER(5,3),
    due_date       DATE
);

INSERT INTO customers VALUES (1, 'Ramesh Iyer',     65, 15000, 'N');
INSERT INTO customers VALUES (2, 'Ananya Rao',      45, 25000, 'N');
INSERT INTO customers VALUES (3, 'Vikram Shah',     72,  8000, 'N');
INSERT INTO customers VALUES (4, 'Priya Nair',      58, 12000, 'N');
INSERT INTO customers VALUES (5, 'Suresh Menon',    61,  5000, 'N');
INSERT INTO customers VALUES (6, 'Kavita Desai',    39, 11000, 'N');
INSERT INTO customers VALUES (7, 'Arjun Malhotra',  68,  9500, 'N');
INSERT INTO customers VALUES (8, 'Neha Kapoor',     55, 30000, 'N');

INSERT INTO loans VALUES (101, 1,  9.5, DATE '2026-07-10');
INSERT INTO loans VALUES (102, 2,  8.0, DATE '2026-09-01');
INSERT INTO loans VALUES (103, 3, 10.0, DATE '2026-07-20');
INSERT INTO loans VALUES (104, 4,  9.0, DATE '2026-08-15');
INSERT INTO loans VALUES (105, 5,  7.5, DATE '2026-07-15');
INSERT INTO loans VALUES (106, 6,  8.5, DATE '2026-12-01');
INSERT INTO loans VALUES (107, 7,  9.8, DATE '2026-07-30');
INSERT INTO loans VALUES (108, 8,  6.5, DATE '2026-07-05');

COMMIT;

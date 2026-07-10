INSERT INTO bank_account (account_no, bank_name, balance) VALUES ('ACC001', 'SBI', 5000);
INSERT INTO bank_account (account_no, bank_name, balance) VALUES ('ACC002', 'HDFC', 3000);
INSERT INTO bank_account (account_no, bank_name, balance) VALUES ('ACC003', 'ICICI', 7000);

INSERT INTO bank_transaction (type, amount, account_no) VALUES ('CREDIT', 1000, 'ACC001');
INSERT INTO bank_transaction (type, amount, account_no) VALUES ('DEBIT', 500, 'ACC001');
INSERT INTO bank_transaction (type, amount, account_no) VALUES ('CREDIT', 2000, 'ACC002');
INSERT INTO bank_transaction (type, amount, account_no) VALUES ('CREDIT', 3000, 'ACC003');
INSERT INTO bank_transaction (type, amount, account_no) VALUES ('DEBIT', 1000, 'ACC003');
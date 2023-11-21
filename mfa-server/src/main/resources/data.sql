INSERT INTO role_type(role, description) VALUES ('ROLE_USER', 'Normal User Role' );
INSERT INTO role_type(role, description) VALUES ('ROLE_ADMIN', 'Admin User Role' );

INSERT INTO user_account(username, email, password, first_name, last_name, active, totp_code)
VALUES ('admin', 'admin@retrospect.com', '{noop}Password1', 'Mfaserver', 'Admin', true, '123456');
INSERT INTO user_account(username, email, password, first_name, last_name, active, totp_code, mfa_enabled)
VALUES ('wpfeiffe', 'bill.pfeiffer@retrospect.com', '{noop}Password1', 'Bill', 'Pfeiffer', true, '123456', true);
INSERT INTO user_account(username, email, password, first_name, last_name, active, totp_code, mfa_enabled)
VALUES ('tsmith', 'tom.smith@retrospect.com', '{noop}Password1', 'Tom', 'Smith', true, '123456', true);

INSERT INTO user_role(user_id, role) VALUES ((SELECT id FROM user_account WHERE username = 'wpfeiffe'), 'ROLE_USER');
INSERT INTO user_role(user_id, role) VALUES ((SELECT id FROM user_account WHERE username = 'tsmith'), 'ROLE_USER');
INSERT INTO user_role(user_id, role) VALUES ((SELECT id FROM user_account WHERE username = 'admin'), 'ROLE_ADMIN');

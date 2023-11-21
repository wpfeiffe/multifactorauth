
DROP TABLE IF EXISTS user_role;
DROP SEQUENCE IF EXISTS user_role_seq;
DROP TABLE IF EXISTS role_type;
DROP TABLE IF EXISTS user_account;
DROP SEQUENCE IF EXISTS user_account_seq;

CREATE TABLE role_type
(
    role VARCHAR(20) PRIMARY KEY,
    description VARCHAR(60) NOT NULL UNIQUE
);

CREATE SEQUENCE user_account_seq START WITH 10000;
CREATE TABLE user_account
(
    id BIGINT DEFAULT nextval('user_account_seq') PRIMARY KEY,
    version SMALLINT DEFAULT 0,
    userName VARCHAR(60) UNIQUE NOT NULL ,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(120),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT false,
    mfa_enabled BOOLEAN NOT NULL DEFAULT false,
    totp_code VARCHAR(200) NOT NULL 
);

CREATE SEQUENCE user_role_seq START WITH 10000;
CREATE TABLE user_role
(
    id BIGINT DEFAULT nextval('user_role_seq') PRIMARY KEY,
    version SMALLINT DEFAULT 0,
    user_id INTEGER NOT NULL,
    role VARCHAR(20) NOT NULL,
    CONSTRAINT fk_role_user FOREIGN KEY (user_id) REFERENCES user_account(id),
    CONSTRAINT fk_role_role FOREIGN KEY (role) REFERENCES role_type(role),

    CONSTRAINT uc_user_role UNIQUE (user_id, role)
);


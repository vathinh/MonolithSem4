-- liquibase formatted sql

-- changeset vanthinh:add-users-table.sql

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       title varchar(255),
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       email VARCHAR(255),
                       phone VARCHAR(255),
                       user_type varchar(255),
                       keycloak_id VARCHAR(255) UNIQUE,
                       created_by VARCHAR(255),
                       created_date TIMESTAMPTZ,
                       modified_date TIMESTAMPTZ,
                       delete_flag BOOLEAN,
                       version BIGINT
);

CREATE INDEX idx_users_email ON users (email);
CREATE INDEX idx_users_id ON users (id);
CREATE INDEX idx_users_keycloak_id ON users (keycloak_id);
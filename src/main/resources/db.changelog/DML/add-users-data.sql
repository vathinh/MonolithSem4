-- liquibase formatted sql

-- changeset vanthinh:add-users-data.sql


INSERT INTO users (title, first_name, last_name, email, phone, keycloak_id, created_by, user_type, created_date, modified_date, delete_flag, version)
VALUES
    ('Mr.', 'John', 'Doe', 'john.doe@example.com', '123-456-7890', 'johndoe', 'Admin', 'CUSTOMER',NOW(), NOW(), false, 1),
    ('Ms.', 'Alice', 'Smith', 'alice.smith@example.com', '987-654-3210', 'alicesmith', 'Admin', 'CUSTOMER',NOW(), NOW(), false, 2),
    ('Mr.', 'Bob', 'Johnson', 'bob.johnson@example.com', '555-123-4567', 'bobjohnson', 'Admin', 'CUSTOMER',NOW(), NOW(), false, 3),
    ('Ms.', 'Eve', 'Davis', 'eve.davis@example.com', '111-222-3333', 'evedavis', 'Admin', 'EMPLOYEE',NOW(), NOW(), false, 4),
    ('Mr.', 'Charlie', 'Brown', 'charlie.brown@example.com', '444-555-6666', 'charliebrown', 'Admin', 'EMPLOYEE',NOW(), NOW(), false, 5);
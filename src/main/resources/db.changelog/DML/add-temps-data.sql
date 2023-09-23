-- liquibase formatted sql

-- changeset vanthinh:add-temps-data.sql

INSERT INTO temps (temp_name, temp_des, created_by, created_date, modified_date, version)
VALUES
    ('Temp1', 'Description 1', 'User1', NOW(), NOW(), 1),
    ('Temp2', 'Description 2', 'User2', NOW(), NOW(), 1),
    ('Temp3', 'Description 3', 'User3', NOW(), NOW(), 1),
    ('Temp4', 'Description 4', 'User4', NOW(), NOW(), 1),
    ('Temp5', 'Description 5', 'User5', NOW(), NOW(), 1),
    ('Temp6', 'Description 6', 'User6', NOW(), NOW(), 1),
    ('Temp7', 'Description 7', 'User7', NOW(), NOW(), 1),
    ('Temp8', 'Description 8', 'User8', NOW(), NOW(), 1),
    ('Temp9', 'Description 9', 'User9', NOW(), NOW(), 1),
    ('Temp10', 'Description 10', 'User10', NOW(), NOW(), 1);

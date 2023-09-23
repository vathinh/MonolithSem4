-- liquibase formatted sql

-- changeset vanthinh:add-temps-to-table.sql

CREATE TABLE temps (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       temp_name VARCHAR(255),
                       temp_des VARCHAR(255),
                       created_by VARCHAR(255),
                       created_date DATETIME,
                       modified_date DATETIME,
                       delete_flag BOOLEAN DEFAULT false,
                       version BIGINT
);

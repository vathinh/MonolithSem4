-- liquibase formatted sql

-- changeset vanthinh:add-files-table.sql

CREATE TABLE files (
                       id VARCHAR(36) NOT NULL,
                       name VARCHAR(255),
                       type VARCHAR(255),
                       data LONGBLOB,
                       PRIMARY KEY (id)
);
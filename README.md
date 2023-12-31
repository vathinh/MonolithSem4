# MonolithSem4

# For a test run
- Open Docker Desktop
- Navigate to the project directory using the `cd` command:
    
    ```bash
  cd monolithInfras
  docker-compose up -d
- This will init docker mysql8 data server for you.

- Import the `postMan/temp/` in the PostMan App to Test.
- Run the project 
- Test with PostMan

# Project Setup and Testing Guide

## Overview
This guide will help you set up your project and test your API. Follow these steps to ensure a smooth development process.

## Project Setup

### Git Clone
- Create a new branch

    ```bash
  cd git checkout -b [feature/tenbranch]

### Step 1: Create Model
- Develop your data models (entities) under the `src/main/java/com/yourpackage/model` package.

### Step 2: Create DTO (Data Transfer Object)
- Implement DTOs for data transfer between different layers (e.g., controller, service, repository).
- Place your DTOs in the `src/main/java/com/yourpackage/dto` directory.

### Step 3: Implement MapStruct Mappings
- Utilize MapStruct to simplify entity-to-DTO mappings.
- Develop your mapping interfaces under `src/main/java/com/yourpackage/mapper`.

## Step 4: Building with Maven

To clean and compile your project, allowing MapStruct to auto-generate code, follow these steps:

1. Open your terminal or command prompt.

2. Navigate to the project directory using the `cd` command:

   ```bash
   cd your-project-directory
   mvn clean compile

### Step 5: Create Repository
- Develop data repositories under `src/main/java/com/yourpackage/repository`.
- You can extend `JpaRepository` or other Spring Data JPA repositories as needed.

### Step 6: Create Service Interfaces
- Define service interfaces under `src/main/java/com/yourpackage/service`.
- These interfaces should declare methods for interacting with your data.

### Step 7: Implement Service Implementations
- Implement the service interfaces created in Step 6.
- Place your service implementations under `src/main/java/com/yourpackage/service/impl`.

### Step 8: Create Specifications
- Develop specifications for querying your data in `src/main/java/com/yourpackage/specification`.
- These specifications can be used in your service layer to filter data.

### Step 9: Create Controllers
- Build your RESTful API endpoints by creating controllers.
- Controllers should handle incoming requests and call the corresponding service methods.
- Place controllers in `src/main/java/com/yourpackage/controller`.

## Testing Your API

### Creating SQL Scripts
- Prepare SQL scripts to create database tables and insert test data.
- Save table creation scripts in `resource/db.changelog/DDL` using the following format:
- `liquibase format SQL` 
- `Changeset [name]: file-name.sql`
- Insert test data in `resource/db.changelog/DML` using the same format:
- Liquibase format SQL
- Changeset [name]: file-name.sql
- To configure your IDE to recognize these scripts, add `<include file="file/path">` inside `db.changelog-master.xml`.

### Running Your IDE
- Launch your Integrated Development Environment (IDE) to start working on your project.

### Testing with Postman
- Open Postman, a popular API testing tool.
- Use Postman to test your API endpoints and verify their functionality.

### Git
- After everything is running smoothly

- Navigate to the project directory using the `cd` command:

   ```bash
   cd your-project-directory
   git add .
  git commit -m "message"
  git push --set-upstream origin feature/[branchName]


- And then Open https://github.com/vathinh/MonolithSem4
- Click into Pull Request and create a Pull Request to Master branch and wait for approval
# Banking Application REST API

## Description
This project is a REST API for a basic banking application developed using Spring Boot, Spring Data JPA, Hibernate, MySQL, Maven, Java, and REST API principles. It allows users to perform CRUD operations related to banking functions such as creating an account, depositing amount, withdrawing amount, deleting account, and retrieving account details.

## Features
- **Create Account**: Allows users to create a new bank account with basic details.
- **Deposit Amount**: Enables users to deposit a specified amount into their bank account.
- **Withdraw Amount**: Allows users to withdraw a specified amount from their bank account.
- **Get Account Details**: Retrieves detailed information about a bank account.
- **Delete Account**: Deletes a bank account.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Java

## Installation
1. Clone the repository: `git clone <repository_url>`
2. Navigate to the project directory: `cd <project_directory>`
3. Configure the MySQL database connection in `application.properties`.
4. Run the application using Maven: `mvn spring-boot:run`

## API Endpoints
- `POST /api/accounts`: Create a new bank account.
- `PUT /api/accounts/{id}/deposit`: Deposit amount into a bank account.
- `PUT /api/accounts/{id}/withdraw`: Withdraw amount from a bank account.
- `GET /api/accounts/{id}`: Get details of a bank account by ID.
- `GET /api/accounts/`: Get list of all the bank accounts.
- `DELETE /api/accounts/{id}`: Delete a bank account by ID.

## Usage
- Ensure the application is running.
- Use an API testing tool like Postman to send requests to the defined endpoints.
- Refer to the API Endpoints section for details on request formats and examples.

## Contributors
- Taniksh Mahajan [Profile](https://github.com/TanikshMahajan)

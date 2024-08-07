# Submission Form RESTful API

This is a Spring Boot application providing RESTful API endpoints for managing customer submissions. It uses an H2 in-memory database for data storage.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/SubmissionFormDemo.git
   cd SubmissionFormDemo
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

   The application will start on port `8084`.

## Usage

### Accessing the Application

The application runs on `http://localhost:8084`. You can use Postman or any other HTTP client to interact with the API.

### API Endpoints

#### Create a Customer

- **URL:** `/api/customers`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Body:**
  ```json
  {
      "cid": 1,
      "cname": "John Doe",
      "cmail": "john.doe@example.com",
      "mobile": 1234567890,
      "address": "123 Main St"
  }
  ```

#### Retrieve All Customers

- **URL:** `/api/customers`
- **Method:** `GET`

#### Retrieve a Specific Customer by ID

- **URL:** `/api/customers/{cid}`
- **Method:** `GET`

#### Update a Customer

- **URL:** `/api/customers`
- **Method:** `PUT`
- **Headers:** `Content-Type: application/json`
- **Body:**
  ```json
  {
      "cid": 1,
      "cname": "John Doe",
      "cmail": "john.doe@newexample.com",
      "mobile": 1234567890,
      "address": "456 Main St"
  }
  ```

#### Delete a Customer

- **URL:** `/api/customers/{cid}`
- **Method:** `DELETE`

## Database

The application uses an H2 in-memory database. You can access the H2 database console at `http://localhost:8084/h2-console`.

### H2 Console Configuration

- **Driver Class:** `org.h2.Driver`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** 

Make sure the H2 console is enabled in `src/main/resources/application.properties`:
```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

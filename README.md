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
      "cmail": "john.doe@example.com"
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
      "cmail": "john.doe@newexample.com"
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
![Screenshot 2024-09-27 232406](https://github.com/user-attachments/assets/4867b822-cc7e-4b79-8f57-da2644bfa0c0)
![Screenshot 2024-09-27 232609](https://github.com/user-attachments/assets/59174718-cb29-4457-a1a9-28a59a6d32cf)
![Screenshot 2024-09-27 232636](https://github.com/user-attachments/assets/c2b0d15f-95b9-4ac7-9369-8fa8824b392b)
![Screenshot 2024-09-27 234139](https://github.com/user-attachments/assets/4eb97168-da90-4480-b0ce-24716aac49d0)

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

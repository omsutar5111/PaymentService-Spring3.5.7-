# Payment Service (Spring Boot 3.5.7 / Spring Framework 6.2.12)

This service is built to validate and work with **Spring Boot 3.5.7** using **Spring Framework 6.2.12**, and to provide **payment-related APIs** implemented via controllers.  
It also includes **Swagger/OpenAPI configuration** for interactive API documentation and testing.

---

## Tech Stack

- **Java**: 17
- **Spring Boot**: **3.5.7**
- **Spring Framework**: **6.2.12**
- **Build Tool**: Maven
- **Database**: H2 (In-Memory)
- **ORM**: Spring Data JPA / Hibernate 6
- **API Docs**: Swagger / OpenAPI (via springdoc-openapi 2.6.0)
- **Utilities**: Lombok, Jakarta Validation

---

## Features

- Verifies compatibility and behavior with:
  - Spring Boot **3.5.7**
  - Spring Framework **6.2.12**
- RESTful endpoints for **payment operations**
- Controller-based API design (Payment Controllers)
- Swagger/OpenAPI enabled for:
  - Endpoint discovery
  - Request/response testing from browser UI
  - Clear API contract visibility

---

## Project Structure

```
org.payment
├── Main.java                              # Spring Boot Application Entry Point
├── config/
│   └── SwaggerConfig.java                 # OpenAPI / Swagger Configuration
├── controller/
│   └── PaymentController.java             # Payment REST Controller
├── dto/
│   ├── PaymentRequest.java                # Request DTO
│   └── PaymentResponse.java               # Response DTO
├── exception/
│   ├── ErrorResponse.java                 # Standard Error Response Body
│   ├── GlobalExceptionHandler.java        # @RestControllerAdvice
│   ├── PaymentNotFoundException.java      # 404 Exception
│   └── PaymentProcessingException.java    # 422 Exception
├── model/
│   ├── Payment.java                       # JPA Entity
│   ├── PaymentMethod.java                 # Enum (CREDIT_CARD, DEBIT_CARD, UPI, NET_BANKING, WALLET)
│   └── PaymentStatus.java                 # Enum (PENDING, COMPLETED, FAILED, REFUNDED, CANCELLED)
├── repository/
│   └── PaymentRepository.java             # DAO Layer (JpaRepository)
└── service/
    ├── PaymentService.java                # Service Interface
    └── PaymentServiceImpl.java            # Service Implementation
```

---

## API Documentation (Swagger)

Once the application is running, open Swagger UI:

- **Swagger UI**: `http://localhost:8080/swagger-ui/index.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

> If your app uses a different port or context-path, adjust the URLs accordingly.

---

## Payment APIs

### Base Path: `/api/payments`

| Method   | Endpoint                  | Description                          | Status Code |
|----------|---------------------------|--------------------------------------|-------------|
| `POST`   | `/api/payments`           | Create / Initiate a new payment      | 201 Created |
| `GET`    | `/api/payments`           | List / Fetch all payments            | 200 OK      |
| `GET`    | `/api/payments/{id}`      | Get payment details by ID            | 200 OK      |
| `GET`    | `/api/payments/status/{status}` | Filter payments by status      | 200 OK      |
| `PATCH`  | `/api/payments/{id}/status?status=` | Update payment status       | 200 OK      |
| `DELETE` | `/api/payments/{id}`      | Cancel / Delete a payment            | 204 No Content |

### Payment Status Values
`PENDING` | `COMPLETED` | `FAILED` | `REFUNDED` | `CANCELLED`

### Payment Method Values
`CREDIT_CARD` | `DEBIT_CARD` | `UPI` | `NET_BANKING` | `WALLET`

> For the complete and always up-to-date list of endpoints, use Swagger UI.

---

## Running the Application

### Prerequisites
- Java 17+ installed
- Maven installed (or use IDE built-in Maven)

### Run (Maven)
```bash
mvn spring-boot:run
```

### Run as JAR
```bash
# Build
mvn clean package

# Run
java -jar target/Payment_Service-1.0-SNAPSHOT.jar
```

---

## Configuration

### `application.properties`

| Property                             | Value                    | Description            |
|--------------------------------------|--------------------------|------------------------|
| `server.port`                        | `8080`                   | Application port       |
| `spring.datasource.url`             | `jdbc:h2:mem:paymentdb`  | H2 in-memory database  |
| `spring.h2.console.enabled`         | `true`                   | Enable H2 web console  |
| `spring.h2.console.path`            | `/h2-console`            | H2 console URL path    |
| `spring.jpa.hibernate.ddl-auto`     | `update`                 | Auto-create/update schema |
| `spring.jpa.show-sql`               | `true`                   | Log SQL queries        |

### H2 Console
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:paymentdb`
- **Username**: `sa`
- **Password**: *(empty)*

> Avoid committing real secrets. Use environment variables or a secrets manager.

---

## Notes

- This service is primarily created to ensure stable operation with **Spring Boot 3.5.7** and **Spring 6.2.12** while implementing payment APIs.
- Swagger/OpenAPI configuration is included to simplify testing and documentation.
- All source code uses the `jakarta.*` namespace (Jakarta EE 10), compatible with Spring Boot 3.x and Java 17.

---

## Author

- **GitHub**: [https://github.com/omsutar5111](https://github.com/omsutar5111)


# 🛒 Product Management System

A **Spring Boot REST API** project to manage products and categories with full CRUD operations, DTO mapping, authentication, and centralized exception handling.

---

## 🚀 Features
- **Category Management**
    - Add, view, update, and delete categories
    - Prevents duplicate category creation
    - Custom exception handling

- **Product Management**
    - CRUD operations for products
    - Products linked with categories via JPA relationships
    - DTO-based clean request/response layer

- **Security & Documentation**
    - **Spring Security (Basic Auth)** for API access
    - **Swagger UI / OpenAPI** for interactive API testing
    - **Global Exception Handling** with meaningful error messages

---

## 🛠️ Tech Stack
- **Java 21**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA (Hibernate)**
- **Spring Security (Basic Auth)**
- **Swagger UI & OpenAPI**
- **MySQL / H2**

---

## 📂 Project Structure
```
product-management-system/
│── .gitignore
│── README.md
│── pom.xml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── productManagementSystem/
│   │   │           ├── ProductManagementSystemApplication.java
│   │   │           │
│   │   │           ├── controller/
│   │   │           │   ├── CategoryController.java
│   │   │           │   └── ProductController.java
│   │   │           │
│   │   │           ├── dto/
│   │   │           │   ├── CategoryDto.java
│   │   │           │   ├── ExceptionResponseDto.java
│   │   │           │   └── ProductDto.java
│   │   │           │
│   │   │           ├── entity/
│   │   │           │   ├── Category.java
│   │   │           │   └── Product.java
│   │   │           │
│   │   │           ├── exceptions/
│   │   │           │   ├── CategoryAlreadyExists.java
│   │   │           │   ├── CategoryNotFoundException.java
│   │   │           │   ├── ProductNotFoundException.java
│   │   │           │   └── GlobalExceptionHandler.java
│   │   │           │
│   │   │           ├── mapper/
│   │   │           │   ├── CategoryMapper.java
│   │   │           │   └── ProductMapper.java
│   │   │           │
│   │   │           ├── repository/
│   │   │           │   ├── CategoryRepository.java
│   │   │           │   └── ProductRepository.java
│   │   │           │
│   │   │           └── service/
│   │   │               ├── CategoryService.java
│   │   │               └── ProductService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── productManagementSystem/
│                   ├── CategoryServiceTest.java
│                   ├── ProductServiceTest.java
│                   └── ProductManagementSystemApplicationTests.java
│
└── docs/
    └── architecture.md

```  

---

## 📌 API Endpoints

### 🔹 Category APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/category/add` | Add a new category |
| GET    | `/category/all` | Get all categories |
| GET    | `/category/{id}` | Get category by ID |
| DELETE | `/category/delete/{id}` | Delete category |

### 🔹 Product APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/product/add` | Add a new product |
| GET    | `/product/all` | Get all products |
| GET    | `/product/{id}` | Get product by ID |
| PUT    | `/product/update/{id}` | Update product |
| DELETE | `/product/delete/{id}` | Delete product |

---

## 🔑 Authentication (Spring Security)
All APIs are protected with **Basic Authentication**.

**Default credentials (can be configured in `application.properties`):**
```properties
spring.security.user.name=admin
spring.security.user.password=admin123
```  

Use these credentials in **Swagger UI** or **Postman** to access endpoints.

---

## 📖 API Documentation (Swagger / OpenAPI)

Once the application is running, access the docs at:

- Swagger UI → `http://localhost:8080/swagger-ui/index.html`
- OpenAPI Spec → `http://localhost:8080/v3/api-docs`

---

## ⚡ Exception Handling

Example error response when a category is not found:
```json
{
  "timestamp": "2025-09-05T12:30:45.123",
  "message": "Category with ID 10 not found",
  "details": "uri=/category/10"
}
```  

---

## ▶️ Running the Project

### 1. Clone the repo
```bash
git clone https://github.com/mrityunjay0/product-management-system.git
cd product-management-system
```

### 2. Configure Database
In `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

### 4. Open Swagger UI
Go to:  
👉 `http://localhost:8080/swagger-ui/index.html`

---

## 🏗️ Future Enhancements
- Implement role-based authorization (ADMIN, USER)
- Add pagination & sorting in API responses
- Deploy with Docker & CI/CD pipeline
- Integration tests with JUnit & Mockito

---

## 👨‍💻 Author
**Mrityunjay Kumar**
- 💼 Aspiring Java Backend Developer
- 🔗 [LinkedIn](https://www.linkedin.com/in/mrityunjay-kumar-7340062a1/)
- 📂 [GitHub](https://github.com/mrityunjay0)  

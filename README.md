# Student Management API - Interview Assignment

A scalable Spring Boot application demonstrating best practices in Java development with a single, comprehensive REST endpoint for student management.

## 📋 Project Overview

This is a production-ready Spring Boot application showcasing:
- **Clean Architecture**: Separation of concerns with layered design (Controller → Service → Repository)
- **H2 In-Memory Database**: No external database setup required
- **RESTful API**: Professional REST endpoint design
- **Input Validation**: Comprehensive data validation
- **Exception Handling**: Global exception handler with custom error responses
- **Logging**: Structured logging across all layers
- **Scalability**: Architecture designed for easy feature expansion

## 🏗️ Architecture

```
Controller Layer (REST API)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (Data Access)
        ↓
Entity/Database Layer (H2)
```

### Project Structure

```
src/
├── main/
│   ├── java/com/interview/assignment/
│   │   ├── StudentManagementApplication.java    # Main entry point
│   │   ├── controller/
│   │   │   └── StudentController.java           # REST endpoints
│   │   ├── service/
│   │   │   └── StudentService.java              # Business logic
│   │   ├── repository/
│   │   │   └── StudentRepository.java           # Data access
│   │   ├── entity/
│   │   │   └── Student.java                     # Database entity
│   │   ├── dto/
│   │   │   └── StudentDTO.java                  # Data transfer object
│   │   └── exception/
│   │       ├── ResourceNotFoundException.java   # Custom exceptions
│   │       ├── DuplicateResourceException.java
│   │       ├── ErrorResponse.java
│   │       └── GlobalExceptionHandler.java      # Exception handling
│   └── resources/
│       └── application.yml                      # Configuration
└── test/                                        # (Ready for tests)
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone <your-git-repo-url>
   cd SpringBoot_Interview_Assignment
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   Or use your IDE to run `StudentManagementApplication.java`

4. **Access the application**
   - Application starts on: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:studentdb`
     - Username: `sa`
     - Password: (leave blank)

## 📚 API Documentation

### Main Endpoint: Student Management

#### 1. Register a New Student (POST)
```
POST /api/v1/students

Request Body:
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "grade": "A"
}

Response: 201 Created
{
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "grade": "A",
    "createdAt": "2026-06-03T10:15:30",
    "updatedAt": "2026-06-03T10:15:30"
}
```

#### 2. Get Student by ID (GET)
```
GET /api/v1/students/{id}

Response: 200 OK
{
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "grade": "A",
    "createdAt": "2026-06-03T10:15:30",
    "updatedAt": "2026-06-03T10:15:30"
}
```

#### 3. Get Student by Email (GET)
```
GET /api/v1/students/email/{email}

Response: 200 OK
(Same as above)
```

#### 4. Update Student (PUT)
```
PUT /api/v1/students/{id}

Request Body:
{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com",
    "age": 21,
    "grade": "B"
}

Response: 200 OK
(Updated student data)
```

#### 5. Delete Student (DELETE)
```
DELETE /api/v1/students/{id}

Response: 204 No Content
```

#### 6. Health Check (GET)
```
GET /api/v1/students/health

Response: 200 OK
"Student Management API is up and running!"
```

## ✅ Validation Rules

| Field | Rules |
|-------|-------|
| firstName | Required, 2-100 characters |
| lastName | Required, 2-100 characters |
| email | Required, valid email format, must be unique |
| age | Required, between 15-100 |
| grade | Required, single character: A, B, C, D, E, or F |

## 🔧 Error Handling

The application provides standardized error responses:

```json
{
    "status": 404,
    "message": "Student not found with id: 1",
    "error": "Not Found",
    "timestamp": "2026-06-03T10:15:30",
    "path": "/api/v1/students/1"
}
```

### Error Codes
- **400 Bad Request**: Validation failed
- **404 Not Found**: Resource not found
- **409 Conflict**: Duplicate resource (e.g., duplicate email)
- **500 Internal Server Error**: Unexpected server error

## 🎯 Key Features Demonstrating Scalability

### 1. **Layered Architecture**
   - Easy to add new services without modifying existing code
   - Clear separation of concerns

### 2. **DTOs (Data Transfer Objects)**
   - API contracts independent of database schema
   - Easy to version APIs in the future

### 3. **Service Layer**
   - Business logic separated from HTTP concerns
   - Can be reused for different interfaces (REST, GraphQL, etc.)

### 4. **Global Exception Handling**
   - Consistent error responses across all endpoints
   - Easy to add new exception types

### 5. **Repository Pattern**
   - Easy to switch databases (PostgreSQL, MySQL, etc.)
   - Easy to add caching strategies

### 6. **Logging**
   - Comprehensive logging for debugging and monitoring
   - Ready for integration with log aggregation tools

## 🔮 Future Enhancement Ideas

Demonstrate scalability by planning these additions:

1. **Authentication & Authorization**
   - Add Spring Security
   - Implement JWT tokens
   - Role-based access control

2. **More Features**
   - Add multiple endpoints (Courses, Enrollments)
   - Add pagination and filtering
   - Add search capabilities

3. **Advanced Features**
   - Caching with @Cacheable
   - Email notifications
   - Event-driven architecture with message queues

4. **Documentation**
   - Swagger/OpenAPI integration
   - Detailed API documentation

5. **Testing**
   - Unit tests for Service layer
   - Integration tests for Controller layer
   - End-to-end tests

6. **DevOps**
   - Docker containerization
   - CI/CD pipeline setup
   - Kubernetes deployment manifests

7. **Monitoring**
   - Spring Boot Actuator integration
   - Metrics collection
   - Health checks and alerts

## 📦 Dependencies

- **Spring Boot 3.1.5**: Web framework
- **Spring Data JPA**: ORM and database operations
- **H2 Database**: In-memory database
- **Lombok**: Reduce boilerplate code
- **Jakarta Validation**: Input validation
- **Log4j2**: Logging framework

## 🧪 Testing the Application

### Using cURL

```bash
# Register a student
curl -X POST http://localhost:8080/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@example.com",
    "age": 20,
    "grade": "A"
  }'

# Get student by ID
curl http://localhost:8080/api/v1/students/1

# Update student
curl -X PUT http://localhost:8080/api/v1/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane@example.com",
    "age": 21,
    "grade": "B"
  }'

# Delete student
curl -X DELETE http://localhost:8080/api/v1/students/1

# Health check
curl http://localhost:8080/api/v1/students/health
```

### Using Postman

1. Import the API endpoints into Postman
2. Create a request for each endpoint
3. Save as a collection for easy reuse

## 📁 Git Repository Setup

### Initial Setup

```bash
# Initialize git repository
git init

# Add all files
git add .

# Create initial commit
git commit -m "Initial commit: Student Management API with scalable architecture"

# Add remote repository
git remote add origin https://github.com/your-username/your-repo-name.git

# Push to GitHub
git branch -M main
git push -u origin main
```

### Create .gitignore

```
# Maven
target/
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties

# IDE
.idea/
*.iml
*.iws
*.ipr
.vscode/
.classpath
.c9/
*.launch
.project
.pydevproject

# OS
.DS_Store
Thumbs.db

# Application
*.log
```

## 📝 Configuration Details

### application.yml

- **Spring Datasource**: H2 in-memory database configuration
- **JPA Hibernate**: Auto schema creation/drop
- **Logging**: DEBUG level for application classes
- **Server Port**: 8080
- **H2 Console**: Enabled for development debugging

## 🎓 Learning Points for Interview

Be prepared to discuss:

1. **Layered Architecture**: Why separation of concerns matters
2. **DTOs vs Entities**: Why they're different and when to use each
3. **Exception Handling**: How global exception handlers improve code quality
4. **Scalability**: How the architecture supports future features
5. **Repository Pattern**: Benefits for data access abstraction
6. **Validation**: Input validation best practices
7. **Logging**: Importance in production systems

## 📄 License

This project is created for educational purposes.

## ✉️ Support

For questions or issues, feel free to reach out or create an issue in the repository.

---

**Remember**: The real value of this application lies not just in the code, but in demonstrating your understanding of software architecture, design patterns, and best practices. Be ready to explain your design decisions to your interviewer!


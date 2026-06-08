# API Testing & Examples

Use this guide to test all endpoints and prepare examples for your interview.

## Testing Tools

### Option 1: cURL (Command Line)
```bash
curl -X METHOD http://localhost:8080/endpoint \
  -H "Content-Type: application/json" \
  -d '{"data": "value"}'
```

### Option 2: Postman
- Download from: https://www.postman.com/downloads/
- Import the endpoints and test them
- Save as collection for easy sharing

### Option 3: VS Code REST Client Extension
- Install extension: REST Client
- Create requests.http file
- Send requests directly from the editor

## Sample API Requests & Responses

### 1. Health Check Endpoint

**Request:**
```
GET /api/v1/students/health HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl http://localhost:8080/api/v1/students/health
```

**Response:**
```
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8

Student Management API is up and running!
```

---

### 2. Register New Student (POST)

**Request:**
```
POST /api/v1/students HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "grade": "A"
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "grade": "A"
  }'
```

**Response:**
```
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "grade": "A",
  "createdAt": "2026-06-03T10:15:30.123456",
  "updatedAt": "2026-06-03T10:15:30.123456"
}
```

---

### 3. Get Student by ID (GET)

**Request:**
```
GET /api/v1/students/1 HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl http://localhost:8080/api/v1/students/1
```

**Response:**
```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "grade": "A",
  "createdAt": "2026-06-03T10:15:30.123456",
  "updatedAt": "2026-06-03T10:15:30.123456"
}
```

---

### 4. Get Student by Email (GET)

**Request:**
```
GET /api/v1/students/email/john.doe@example.com HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl "http://localhost:8080/api/v1/students/email/john.doe@example.com"
```

**Response:**
```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "grade": "A",
  "createdAt": "2026-06-03T10:15:30.123456",
  "updatedAt": "2026-06-03T10:15:30.123456"
}
```

---

### 5. Update Student (PUT)

**Request:**
```
PUT /api/v1/students/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com",
  "age": 21,
  "grade": "B"
}
```

**cURL:**
```bash
curl -X PUT http://localhost:8080/api/v1/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com",
    "age": 21,
    "grade": "B"
  }'
```

**Response:**
```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com",
  "age": 21,
  "grade": "B",
  "createdAt": "2026-06-03T10:15:30.123456",
  "updatedAt": "2026-06-03T10:15:45.654321"
}
```

---

### 6. Delete Student (DELETE)

**Request:**
```
DELETE /api/v1/students/1 HTTP/1.1
Host: localhost:8080
```

**cURL:**
```bash
curl -X DELETE http://localhost:8080/api/v1/students/1
```

**Response:**
```
HTTP/1.1 204 No Content
```

---

## Error Responses

### Invalid Input (Validation Error)

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "A",
    "lastName": "B",
    "email": "invalid-email",
    "age": 10,
    "grade": "X"
  }'
```

**Response:**
```
HTTP/1.1 400 Bad Request
Content-Type: application/json

{
  "status": 400,
  "message": "Validation failed",
  "error": "firstName: First name must be between 2 and 100 characters, email: Email should be valid, age: Age must be at least 15, grade: Grade must be A, B, C, D, E, or F",
  "timestamp": "2026-06-03T10:15:30.123456",
  "path": "/api/v1/students"
}
```

### Resource Not Found

**Request:**
```bash
curl http://localhost:8080/api/v1/students/999
```

**Response:**
```
HTTP/1.1 404 Not Found
Content-Type: application/json

{
  "status": 404,
  "message": "Student not found with id: 999",
  "error": "Not Found",
  "timestamp": "2026-06-03T10:15:30.123456",
  "path": "/api/v1/students/999"
}
```

### Duplicate Email (Conflict)

**Request:**
```bash
# First, register a student
curl -X POST http://localhost:8080/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@example.com",
    "age": 20,
    "grade": "A"
  }'

# Then try to register with same email
curl -X POST http://localhost:8080/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "john@example.com",
    "age": 21,
    "grade": "B"
  }'
```

**Response:**
```
HTTP/1.1 409 Conflict
Content-Type: application/json

{
  "status": 409,
  "message": "Email already exists: john@example.com",
  "error": "Conflict",
  "timestamp": "2026-06-03T10:15:30.123456",
  "path": "/api/v1/students"
}
```

---

## Testing Checklist

Run through this checklist to fully test the application:

- [ ] **Health Check**: GET /api/v1/students/health
- [ ] **Create Student**: POST /api/v1/students (with valid data)
- [ ] **Get by ID**: GET /api/v1/students/1
- [ ] **Get by Email**: GET /api/v1/students/email/{email}
- [ ] **Update Student**: PUT /api/v1/students/1
- [ ] **Delete Student**: DELETE /api/v1/students/1
- [ ] **Validation Error**: POST with invalid data (short firstName, invalid email, etc.)
- [ ] **Not Found Error**: GET /api/v1/students/999
- [ ] **Duplicate Email**: POST with existing email
- [ ] **H2 Console**: Login at http://localhost:8080/h2-console
- [ ] **Verify Data**: Query the STUDENTS table in H2 console

---

## Postman Request Template

Save this content as `requests.http` in VS Code with REST Client extension:

```http
### Variables
@baseUrl = http://localhost:8080
@studentId = 1
@email = john.doe@example.com

### Health Check
GET {{baseUrl}}/api/v1/students/health

### Create Student
POST {{baseUrl}}/api/v1/students
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "{{email}}",
  "age": 20,
  "grade": "A"
}

### Get Student by ID
GET {{baseUrl}}/api/v1/students/{{studentId}}

### Get Student by Email
GET {{baseUrl}}/api/v1/students/email/{{email}}

### Update Student
PUT {{baseUrl}}/api/v1/students/{{studentId}}
Content-Type: application/json

{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com",
  "age": 21,
  "grade": "B"
}

### Delete Student
DELETE {{baseUrl}}/api/v1/students/{{studentId}}

### Test Validation - Invalid Email
POST {{baseUrl}}/api/v1/students
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "invalid-email",
  "age": 20,
  "grade": "A"
}

### Test Validation - Age too young
POST {{baseUrl}}/api/v1/students
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john2@example.com",
  "age": 10,
  "grade": "A"
}

### Test Not Found
GET {{baseUrl}}/api/v1/students/999
```

---

## Tips for Interview Demo

1. **Start with Health Check**: Shows the app is running
2. **Register a Sample Student**: Demonstrate data creation
3. **Retrieve the Student**: Show that data was saved
4. **Update the Student**: Demonstrate modification
5. **Show H2 Console**: Prove the data is in the database
6. **Show an Error Case**: Demonstrate error handling
7. **Walk Through Code**: Explain the architecture
8. **Discuss Scalability**: Explain how to add features

---

## Performance Considerations

For future optimizations:

```java
// Add pagination for large datasets
@GetMapping
public Page<StudentDTO> getAllStudents(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size) {
    return studentService.getAllStudents(
        PageRequest.of(page, size)
    );
}

// Add caching for read operations
@GetMapping("/{id}")
@Cacheable(value = "students", key = "#id")
public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
    return ResponseEntity.ok(studentService.getStudent(id));
}

// Add indexes in database for frequently queried fields
@Index(name = "idx_email", columnList = "email")
public class Student { ... }
```

---

Good luck with your interview demo! 🚀


# Quick Start Guide

Get the Student Management API up and running in 5 minutes!

## Prerequisites

✅ Java 17+ installed
✅ Maven 3.6+ installed
✅ Git installed

## Steps to Run

### 1. Build the Project
```bash
cd SpringBoot_Interview_Assignment
mvn clean install
```

### 2. Run the Application
```bash
mvn spring-boot:run
```

**Application will start at**: `http://localhost:8080`

### 3. Test the Main Endpoint

**Register a Student** (POST):
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

Expected Response (201 Created):
```json
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

**Get Student by ID** (GET):
```bash
curl http://localhost:8080/api/v1/students/1
```

**Health Check**:
```bash
curl http://localhost:8080/api/v1/students/health
```

## View H2 Database (Browser)

Open: `http://localhost:8080/h2-console`

- **JDBC URL**: `jdbc:h2:mem:studentdb`
- **Username**: `sa`
- **Password**: (leave blank)

Click Connect to see the tables and data!

## All Available Endpoints

| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/v1/students` | Register a new student |
| GET | `/api/v1/students/{id}` | Get student by ID |
| GET | `/api/v1/students/email/{email}` | Get student by email |
| PUT | `/api/v1/students/{id}` | Update student |
| DELETE | `/api/v1/students/{id}` | Delete student |
| GET | `/api/v1/students/health` | Health check |

## Validation Rules

All fields are required. See table below:

| Field | Rule |
|-------|------|
| firstName | 2-100 characters, required |
| lastName | 2-100 characters, required |
| email | Valid email, unique, required |
| age | 15-100, required |
| grade | A-F only, required |

## Troubleshooting

**Port 8080 already in use?**
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Mac/Linux
lsof -i :8080
kill -9 <PID>
```

**Maven issues?**
```bash
mvn clean install -U
```

**Need to reset the database?**
Just restart the application (database is in-memory, so it resets on restart)

## Next Steps

1. Read the full [README.md](README.md) for architecture details
2. Explore the source code structure
3. Try all the API endpoints
4. Think about how to extend with new features
5. Push to your Git repository

**Good luck with your interview! 🚀**


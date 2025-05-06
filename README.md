# Spring Boot Bus Server Project

This project support server api and database for project POS app [bus-pos-app-provider](https://github.com/huyhuynh1905/bus-pos-app-provider).

## Resources:
- [database - PostgreSQL](https://github.com/huyhuynh1905/bus-server/blob/develop/support_data/database.sql).
- [Postman - jsonCollection](https://github.com/huyhuynh1905/bus-server/blob/develop/support_data/POS-BUS.postman_collection.json).
- [GPX - RouteFile](https://github.com/huyhuynh1905/bus-server/blob/develop/support_data/OCP1Test.gpx).


## 📂 Project Structure

```
/bus-server
│── src
│   ├── main
│   │   ├── java/com/huyhuynh/busserver
│   │   │   ├── config                          # Application configuration (Security, CORS, JWTAuthen, etc.)
│   │   │   ├── controller                      # Handles HTTP requests
│   │   │   ├── dto                             # Data Transfer Objects
│   │   │   ├── exception                       # Custom exception handling
│   │   │   ├── model                           # Defines model for request and response
│   │   │   ├── entity                          # Defines entities
│   │   │   ├── repository                      # JPA repositories (or DAO layer)
│   │   │   ├── service                         # Business logic
│   │   │   ├── security                        # Security custom and cryption
│   │   │   ├── utils                           # Utility classes
│   │   │   ├── BusServerApplication.java       # Main entry point
│   │   ├── resources
│   │   │   ├── static                          # Static files (CSS, JS, images)
│   │   │   ├── templates                       # Template files (Thymeleaf, FreeMarker)
│   │   │   ├── application.properties          # Application configuration
│── build.gradle                                # Gradle build configuration
│── settings.gradle                             # Gradle project settings
│── gradlew, gradlew.bat                        # Gradle wrapper scripts
│── README.md                                   # Project documentation
```

## 🛠️ Technologies Used
- **Spring Boot** (REST API, Security, JPA, etc.)
- **Gradle** (Dependency management & build automation)
- **PostgreSQL** (Database integration)
- **Thymeleaf** (For template-based views, optional)
- **JUnit & Mockito** (For testing)

## 🚀 Getting Started
### 1. Clone the repository:
```sh
git clone https://github.com/huyhuynh1905/bus-server.git
cd bus-server
```

### 2. Build & Run the application:
```sh
./gradlew bootRun
```

### 3. Running Tests:
```sh
./gradlew test
```

## 📌 Notes
- Modify `application.properties` for database and environment configurations.
- Follow the folder structure for better maintainability.

---
📌 *Feel free to contribute or suggest improvements!*


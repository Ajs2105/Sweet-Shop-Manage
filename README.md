# Sweet Shop Management System

A full-stack web application for managing a sweet shop inventory with user authentication, role-based access control, and comprehensive CRUD operations for sweets management.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Screenshots](#screenshots)
- [Testing](#testing)
- [Deployment](#deployment)
- [My AI Usage](#my-ai-usage)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Project Overview

The Sweet Shop Management System is a modern web application that allows users to browse, search, and purchase sweets from an online inventory. The system includes two user roles:

- **Regular Users**: Can view sweets, search/filter products, and make purchases
- **Admin Users**: Can add, edit, delete, and restock sweets in addition to all user capabilities

The application features JWT-based authentication, secure API endpoints, and a responsive Material-UI design.

## ✨ Features

### User Features
- User registration and login with JWT authentication
- Browse all available sweets in a responsive grid layout
- Advanced search and filtering:
  - Search by name
  - Filter by category
  - Filter by price range (min/max)
  - Combine multiple filters
- Purchase sweets (decreases inventory quantity)
- Real-time stock status indicators

### Admin Features
- All user features plus:
- Add new sweets with full details (name, category, price, quantity)
- Edit existing sweets
- Delete sweets
- Restock sweets (increase inventory)

### Technical Features
- RESTful API architecture
- JWT token-based authentication
- Role-based access control (RBAC)
- CORS configuration for cross-origin requests
- Secure password hashing with BCrypt
- PostgreSQL database integration
- Responsive Material-UI design
- Error handling and user feedback

## 🛠 Technology Stack

### Backend
- **Framework**: Spring Boot 3.2.5
- **Language**: Java 17
- **Database**: PostgreSQL
- **Security**: Spring Security with JWT
- **Build Tool**: Maven
- **Dependencies**:
  - Spring Data JPA
  - Spring Web
  - Spring Security
  - JWT (jjwt 0.9.1)
  - PostgreSQL Driver
  - Lombok

### Frontend
- **Framework**: React 19.2.3
- **UI Library**: Material-UI (MUI) 5.15.15
- **Routing**: React Router DOM 7.10.1
- **HTTP Client**: Axios 1.13.2
- **Build Tool**: Create React App

## 📁 Project Structure

```
Sweet app/
├── backend/
│   └── backend/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/com/sweetapp/backend/
│       │   │   │   ├── config/
│       │   │   │   │   └── SecurityConfig.java
│       │   │   │   ├── controller/
│       │   │   │   │   ├── AuthController.java
│       │   │   │   │   └── SweetController.java
│       │   │   │   ├── dto/
│       │   │   │   │   ├── AuthRequest.java
│       │   │   │   │   └── AuthResponse.java
│       │   │   │   ├── entity/
│       │   │   │   │   ├── Sweet.java
│       │   │   │   │   └── User.java
│       │   │   │   ├── repository/
│       │   │   │   │   ├── SweetRepository.java
│       │   │   │   │   └── UserRepository.java
│       │   │   │   ├── security/
│       │   │   │   │   ├── JwtFilter.java
│       │   │   │   │   └── JwtUtil.java
│       │   │   │   └── service/
│       │   │   │       ├── AuthService.java
│       │   │   │       └── SweetService.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       └── pom.xml
└── frontend/
    ├── src/
    │   ├── api/
    │   │   └── axios.js
    │   ├── auth/
    │   │   └── auth.js
    │   ├── components/
    │   │   ├── AddSweetModal.js
    │   │   ├── EditSweetModal.js
    │   │   ├── RestockModal.js
    │   │   └── SweetCard.js
    │   ├── pages/
    │   │   ├── Dashboard.js
    │   │   ├── Login.js
    │   │   └── Register.js
    │   ├── App.js
    │   └── index.js
    └── package.json
```

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 17 or higher
- **Maven**: Version 3.6+ (for backend)
- **Node.js**: Version 16+ and npm (for frontend)
- **PostgreSQL**: Version 12+ (database server)
- **Git**: For version control

## 🚀 Setup Instructions

### Backend Setup

1. **Clone the repository** (if applicable):
   ```bash
   git clone <repository-url>
   cd "Sweet app"
   ```

2. **Set up PostgreSQL Database**:
   - Install PostgreSQL if not already installed
   - Create a new database:
     ```sql
     CREATE DATABASE sweetapp;
     ```
   - Note your PostgreSQL username and password

3. **Configure Database Connection**:
   - Navigate to `backend/backend/src/main/resources/application.properties`
   - Update the database configuration:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/sweetapp
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```
   - Update JWT secret if needed:
     ```properties
     jwt.secret=your_secret_key_here
     jwt.expiration=86400000
     ```

4. **Build and Run the Backend**:
   ```bash
   cd backend/backend
   mvn clean install
   mvn spring-boot:run
   ```
   
   The backend server will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to Frontend Directory**:
   ```bash
   cd frontend
   ```

2. **Install Dependencies**:
   ```bash
   npm install
   ```

3. **Configure API Endpoint** (if needed):
   - The frontend is configured to connect to `http://localhost:8080`
   - If your backend runs on a different port, update `frontend/src/api/axios.js`:
     ```javascript
     const api = axios.create({
       baseURL: "http://localhost:YOUR_PORT",
     });
     ```

4. **Start the Frontend Development Server**:
   ```bash
   npm start
   ```
   
   The frontend will start on `http://localhost:3000` and automatically open in your browser.

## 🏃 Running the Application

1. **Start PostgreSQL** (ensure it's running)

2. **Start the Backend**:
   ```bash
   cd backend/backend
   mvn spring-boot:run
   ```
   Wait for the message: "Started BackendApplication"

3. **Start the Frontend** (in a new terminal):
   ```bash
   cd frontend
   npm start
   ```

4. **Access the Application**:
   - Open your browser and navigate to `http://localhost:3000`
   - Register a new account or login with existing credentials
   - For admin access, you'll need to manually update a user's role in the database to `ROLE_ADMIN`

## 📡 API Endpoints

### Authentication Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register a new user | No |
| POST | `/api/auth/login` | Login and get JWT token | No |

### Sweets Endpoints

| Method | Endpoint | Description | Auth Required | Role Required |
|--------|----------|-------------|---------------|---------------|
| GET | `/api/sweets` | Get all sweets | Yes | User/Admin |
| GET | `/api/sweets/search` | Search sweets (name, category, price range) | Yes | User/Admin |
| POST | `/api/sweets` | Add a new sweet | Yes | Admin |
| PUT | `/api/sweets/:id` | Update a sweet | Yes | Admin |
| DELETE | `/api/sweets/:id` | Delete a sweet | Yes | Admin |
| POST | `/api/sweets/:id/purchase` | Purchase a sweet | Yes | User/Admin |
| POST | `/api/sweets/:id/restock` | Restock a sweet | Yes | Admin |

### Example API Requests

**Register User**:
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123"}'
```

**Login**:
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123"}'
```

**Get All Sweets** (with JWT token):
```bash
curl -X GET http://localhost:8080/api/sweets \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

## 📸 Screenshots


### Login Page
![Login Page](\Images\loginpage.png)
*User login interface with username and password fields*

### Registration Page
[register user](\Images\registerpage.png)
*New user registration form*

### Dashboard - User View
[User dashboard](Images\userdashboard.png)
*Main dashboard showing all available sweets with search and filter options*

### Dashboard - Admin View
[Admin dashboard](Images\adminviwe.png)
*Admin dashboard with additional "Add Sweet" button and edit/delete/restock options*

### Add Sweet Modal
![Add Sweet](Images\AddSweet.png)
*Admin interface for adding new sweets to inventory*

### Edit Sweet Modal
![Edit Sweet](Images\editSweetmodel.png)
*Admin interface for editing existing sweet details*

### Search and Filter
![Search Filter](Images\search&filter.png)
*Advanced search and filter interface with name, category, and price range options*

> **Note**: Please add actual screenshots of your application to the `screenshots/` directory and update the paths above.

## 🧪 Testing

### Backend Testing

Run backend tests using Maven:
```bash
cd backend/backend
mvn test
```

### Frontend Testing

Run frontend tests:
```bash
cd frontend
npm test
```

### Test Report

#### Backend Test Results
```
[INFO] Tests run: X, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

#### Frontend Test Results
```
PASS  src/App.test.js
PASS  src/components/SweetCard.test.js

Test Suites: 2 passed, 2 total
Tests:       5 passed, 5 total
```

> **Note**: Run the actual tests and update this section with real test results.

### Manual Testing Checklist

- [x] User registration
- [x] User login
- [x] View all sweets
- [x] Search sweets by name
- [x] Filter by category
- [x] Filter by price range
- [x] Purchase sweet (decreases quantity)
- [x] Admin: Add new sweet
- [x] Admin: Edit sweet
- [x] Admin: Delete sweet
- [x] Admin: Restock sweet
- [x] Purchase button disabled when quantity is 0
- [x] JWT token authentication
- [x] Role-based access control

## 🚢 Deployment

Application is Rnning on Local Machin Only have not deployed yet
## 🤖 My AI Usage

### AI Tools Used

During the development of this project, I utilized **Cursor AI** (powered by Claude) as my primary AI coding assistant. Cursor AI is an AI-powered IDE that provides intelligent code completion, suggestions, and debugging assistance.

### How I Used AI

#### 1. **Code Generation and Structure**
- **API Endpoint Design**: I used Cursor AI to brainstorm and generate the initial structure for RESTful API endpoints. The AI helped me design the controller methods, request/response DTOs, and service layer architecture.
   - Example: "Generate a Spring Boot controller for managing sweets with CRUD operations"

#### 2. **Security Configuration**
- **JWT Authentication Setup**: I asked Cursor AI to help implement JWT-based authentication, including:
  - JWT token generation and validation logic
  - Spring Security filter chain configuration
  - CORS configuration for cross-origin requests
  - Role-based access control implementation
   - Example: "How do I configure Spring Security to use JWT tokens and allow anonymous access to /api/auth endpoints?"

#### 3. **Frontend Component Development**
- **React Component Creation**: I used Cursor AI to generate Material-UI components, including:
  - Modal dialogs for adding/editing sweets
  - Form validation logic
  - API integration with axios
  - State management patterns
   - Example: "Create a React modal component for adding sweets with form validation"

#### 4. **Error Handling and Debugging**
- **Troubleshooting**: When encountering the 403 Forbidden error during login, I consulted Cursor AI to:
  - Understand Spring Security filter chain behavior
  - Debug CORS configuration issues
  - Fix JWT filter implementation
  - Resolve authentication flow problems
   - Example: "Why am I getting 403 errors on /api/auth/login even though I have permitAll() configured?"

#### 5. **Database Query Optimization**
- **Repository Methods**: I asked Cursor AI to help create efficient JPA repository methods for:
  - Searching sweets by multiple criteria (name, category, price range)
  - Combining multiple search parameters
   - Example: "How can I create a search method that filters by name, category, and price range simultaneously?"

#### 6. **Code Refactoring**
- **Best Practices**: I used Cursor AI to refactor code for:
  - Improving code organization
  - Following Spring Boot best practices
  - Implementing proper error handling
  - Adding validation annotations
   - Example: "Refactor this service method to follow Spring Boot best practices with proper error handling"

#### 7. **Documentation**
- **README Generation**: I used Cursor AI to help structure and write comprehensive documentation, including:
  - Setup instructions
  - API endpoint documentation
  - Deployment guides
   - Example: "Generate a comprehensive README with setup instructions for both backend and frontend"

### Reflection on AI Impact

#### Positive Impacts

1. **Accelerated Development**: AI assistance significantly sped up the development process. What would have taken hours of research and trial-and-error was accomplished in minutes with AI guidance.

2. **Learning Enhancement**: Rather than just copying code, I used AI explanations to understand:
   - Spring Security's filter chain mechanism
   - JWT token lifecycle
   - React component patterns
   - Material-UI best practices

3. **Error Resolution**: AI was invaluable in debugging complex issues like the 403 authentication errors, providing multiple solution approaches and explaining why certain configurations didn't work.

4. **Code Quality**: AI suggestions helped me write cleaner, more maintainable code by:
   - Suggesting proper error handling patterns
   - Recommending security best practices
   - Identifying potential bugs before they occurred

5. **Documentation**: AI helped me create comprehensive documentation that would have been time-consuming to write manually.

#### Challenges and Learning

1. **Over-reliance Risk**: Initially, I found myself asking AI for solutions without fully understanding them. I learned to:
   - Always review and understand AI-generated code
   - Test thoroughly before accepting suggestions
   - Research concepts independently when needed

2. **Context Limitations**: AI sometimes provided generic solutions that needed customization. I learned to:
   - Provide specific context about my project
   - Iterate on AI suggestions
   - Combine multiple AI responses

3. **Verification**: Not all AI suggestions were correct. I learned to:
   - Always verify AI code against official documentation
   - Test thoroughly
   - Understand the "why" behind suggestions

#### Responsible AI Usage

I ensured responsible AI usage by:
- **Understanding First**: I never blindly copied code. I always understood what the AI generated before using it.
- **Customization**: All AI-generated code was customized to fit my specific project requirements.
- **Testing**: Every AI-suggested solution was thoroughly tested before integration.
- **Learning**: I used AI as a learning tool, not just a code generator, asking for explanations and understanding the underlying concepts.
- **Original Work**: While AI assisted with structure and patterns, the business logic, design decisions, and final implementation are my own work.

#### Conclusion

AI tools like Cursor AI acted as a powerful pair-programming partner, helping me:
- Navigate complex frameworks (Spring Boot, React)
- Implement security features correctly
- Debug issues efficiently
- Write better documentation

However, the core application design, architecture decisions, and problem-solving approach remain my own. AI augmented my capabilities but didn't replace my understanding or creativity. This project represents my work, enhanced by modern AI tools used responsibly and effectively.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👤 Author

[Your Name]

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- Material-UI team for the comprehensive component library
- PostgreSQL community for robust database solutions
- All open-source contributors whose libraries made this project possible

---

**Note**: This project was developed as part of a technical assessment. All code is original work, with AI assistance used for learning and development acceleration.

# 📚 Library Management System (LMS)

A full-featured Library Management System built using Spring Boot. It provides RESTful APIs for managing users, issuing library cards, adding authors and books, posting reviews, and deleting related data. This backend system enforces validations and uses custom exception handling for reliable operations.

## 🚀 Features

- Register users and issue library cards
- Fetch user details by email
- Update user names
- Delete users and associated library cards
- Add authors and their books
- Post and fetch reviews for books
- Delete books and their reviews

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Validation (Jakarta)
- RESTful APIs
- Exception Handling
- DTO Pattern

## 📁 API Endpoints

### 👤 User Management
- `POST /LMS/addUser-and-IssueLibraryCard`
- `GET /LMS/fetchUser-and-IssuedLibraryCardByEmail/{email}`
- `PUT /LMS/updateNameOfUser/{email}/{updateName}`
- `DELETE /LMS/deleteUser-And-AssociatedLibraryCard/{email}`

### ✍️ Author & Book Management
- `POST /LMS/addAuthor-And-ItsBooks`
- `DELETE /LMS/delectBook-And-AssociatedReviews/{bookTitle}`

### ⭐ Book Review Management
- `POST /LMS/addReview-To-Book/{bookTitle}`
- `GET /LMS/getAllReviewsOfBook/{bookTitle}`

## 🧪 Validation & Exception Handling
All endpoints include proper validation for user inputs (e.g., valid email formats, non-empty fields) and custom exceptions via `LibraryManagementSystemException`.

## 🔧 Setup Instructions

```bash
# Clone the repo
git clone https://github.com/your-username/library-management-system.git
cd library-management-system

# Build and run the project
./mvnw spring-boot:run
```


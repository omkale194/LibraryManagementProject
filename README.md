# 📚 Digital Library Management Platform

A web-based Library Management System built with **Spring Boot**, **JSP/HTML**, and **MySQL**. An admin can log in and manage the library's books, staff, and members, and view audit records of book additions and deletions.

## ✨ Features

**Admin**
- Secure admin login with session handling and a logout option

**Books**
- Add a new book (duplicate books are rejected)
- View the full book list
- Search books by **genre**
- Find a book's **ISBN** number
- Update a book's **price**
- Delete a book
- Audit trail: records of **added books** and **deleted books**

**Staff**
- View all staff, add new staff, update salary, delete staff

**Members**
- View all members, add new members, delete members

**Extras**
- ER diagram page and an "About" page

## 🛠️ Tech Stack

| Layer      | Technology                                  |
|------------|---------------------------------------------|
| Backend    | Java 17, Spring Boot 3.3.3, Spring Data JPA |
| Frontend   | JSP, JSTL, HTML, CSS                        |
| Database   | MySQL                                       |
| Build tool | Maven (Maven Wrapper included)              |
| Server     | Embedded Tomcat (with Jasper for JSP)       |

## 🗂️ Project Structure

```
LibraryManagementProject/
├── src/main/java/com/mini/LibraryManagementProject/
│   ├── BookController.java      # login, book and audit routes
│   ├── MemberController.java    # member routes
│   ├── StaffController.java     # staff routes
│   ├── Entities/                # Books, Members, Staff, Books_audit, Delete_Book_Audit
│   └── Repository/              # Spring Data JPA repositories
├── src/main/webapp/             # JSP + HTML pages, CSS, images
├── src/main/resources/
│   └── application.properties   # DB configuration (see setup)
└── pom.xml
```

## 🗃️ Database Tables

| Table          | Purpose                                                                    |
|----------------|----------------------------------------------------------------------------|
| `books`        | bookid, isbn, title, author, publisher, publicationyear, genre, description, pages, price, language |
| `members`      | mid, name, age, email, mobile, joinat                                      |
| `staff`        | staffid, name, email, phone, position, salary                              |
| `book_audit`   | log of added books (bookid, title, author, addedAt)                        |
| `delete_audit` | log of deleted books (bookid, deletedat)                                   |

> `spring.jpa.hibernate.ddl-auto` is set to `none`, so the tables above must exist in your database before the app starts.

## 🚀 Getting Started

### Prerequisites
- JDK 17+
- MySQL 8+
- Maven (or use the included `mvnw`)

### 1. Clone the repository
```bash
git clone https://github.com/omkale194/Digital-Library-Management-Platform.git
cd Digital-Library-Management-Platform
```

### 2. Create the database
```sql
CREATE DATABASE librarydb;
```
Then create the tables listed above (or switch `ddl-auto` to `update` to let Hibernate create them).

### 3. Configure the database
Edit `src/main/resources/application.properties`:

```properties
spring.application.name=LibraryManagementProject
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### 4. Run the application
```bash
./mvnw spring-boot:run
```
On Windows: `mvnw.cmd spring-boot:run`

### 5. Open in your browser
```
http://localhost:8080
```

## 🔗 Main Routes

| Route                                  | Description                      |
|----------------------------------------|----------------------------------|
| `/`                                    | Admin login page                 |
| `/admin`                               | Admin dashboard                  |
| `/adbook`, `/allbook`                  | Add book, list all books         |
| `/searchbygen`, `/isbnno`              | Search by genre, find ISBN       |
| `/upprice`, `/delbook`                 | Update price, delete book        |
| `/addrecord`, `/delrecord`             | Added / deleted book audit logs  |
| `/allstaff`, `/addstaff`, `/updatestaffsal`, `/deletestaff` | Staff management |
| `/allmembers`, `/newmem`, `/deletemem` | Member management                |
| `/erdiagram`, `/moreinfo`              | ER diagram, About page           |

## 🔒 Security Notes

- Never commit real database credentials. Keep `application.properties` out of version control (it is listed in `.gitignore`) and use environment variables or a local file.
- The admin login is currently hardcoded in `BookController.java`. Change it before any real deployment, ideally with Spring Security and hashed passwords.

## 🔮 Future Improvements
- Book issue / return tracking for members
- Spring Security with hashed passwords
- Pagination and better search
- REST API and a modern frontend

## 👤 Author

**Om Kale** – [GitHub](https://github.com/omkale194)

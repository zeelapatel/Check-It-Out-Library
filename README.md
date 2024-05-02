# final-project-final-group-12
final-project-final-group-12 created by GitHub Classroom
# Library Management System
!!!!!!!!  Front end is in react branch and backend is in main branch !!!!!!!!!!!!
video : https://github.com/CSYE6200-Object-Oriented-DesignFall2023/final-project-final-group-12/blob/main/Team_12_OOD_Final_Project.mp4
## Team members
- Zeel Patel
- Yash Zaveri
- Smit Patel
- Sparsh Sanghavi
- Sandeep Kumar
- Shubham Mangaonkar
--
## Tech Stack
- SpringBoot (A Java Framework for backend)
- React (A JavaScript Framework for frontend)
- MySQL (Database)

## Description
Husky Gujju Library is a Library Management System that allows seamless management of the book inventory. The system has two kinds of users:
1. Administrator
2. Student

The prime difference between the two users is the set of privileges they hold.

### Administrator
An administrator is the most privileged user of the system. They can only be registered manually by entering the appropriate credentials in the database. The administrator can add books to the system and assign books to a student, ensuring that assignments occur only if the student and book are present in the database, and the available quantity of the book is non-zero. Appropriate errors are thrown if the criteria are not fulfilled.

### Student
A student is the least privileged user of the system. They can only view their own profile, which shows their first name, last name, email, and ID, along with the books assigned to them by an administrator.

## Implementation and Project Structure

### Package: `edu.neu.csye6200`

- **Demo1Application.java:** This class serves as the entry point for the Spring Boot application. It contains the main method, which is the starting point for the application.

### Directory: `edu.neu.csye6200.controller`

- **AdminController.java:** Handles login functionality for Administrators. Leverages an `AdminServiceFactory` inner class, which interacts with the database to fetch credentials.

- **BookController.java:** Provides features to add a book to the database and assign books to a student. Utilizes Stream API, Lambda Functions, `BooksServiceFactory`, and Comparator for sorting available books.

- **StudentController.java:** Handles student registration and login functionality. Relies on `BooksServiceFactory` to fetch essential student information.

### Directory: `edu.neu.csye6200.entity`

- **Admin.java:** Responsible for creating the 'admin_table' in the Database.

- **AssignBooks.java:** Responsible for creating the 'assigned_book_table' in the Database.

- **Book.java:** Responsible for creating the 'book_table' in the Database.

- **Student.java:** Responsible for creating the 'student_table' in the Database.

### Directory: `edu.neu.csye6200.Factory`

- **BooksServiceFactory.java:** Incorporates Lazy Singleton Factory Pattern. Provides methods such as `getBook()`, `assignBook()`, and `findAllBook()`.

- **StudentServiceFactory.java:** Incorporates Lazy Singleton Factory Pattern. Provides methods such as `createStudentObj()` and incorporates exception handling.

### Directory: `edu.neu.csye6200.repo`

- **AdminRepo.java:** Provides an interface `AdminRepo` for the method `findByAdminemail()`, extending `JpaRepository` for ORM functionalities.

- **AssignBooksRepo.java:** Provides an interface `AssignBooksRepo` for the method `findByStudentId()`, extending `JpaRepository`.

- **BookRepo.java:** Provides an interface `BookRepo`, extending `JpaRepository`.

- **StudentRepo.java:** Provides an interface `StudentRepo` for the method `findByEmail()`, extending `JpaRepository`.

### Directory: `edu.neu.csye6200.services`

- **AdminService.java:** Provides functionality to add an admin and verify admin credentials, indirectly used by `AdminController`.

- **BooksService.java:** Provides functionality to add a book, assign a book by establishing necessary checks, and throwing errors if necessary. Indirectly used by `BookController`.

- **StudentService.java:** Provides functionality to add a student and verify student credentials, indirectly used by `StudentController`.

## Steps to run the project

1. Download and install Eclipse.
2. Launch Eclipse, click on the Help tab, then Eclipse Marketplace. Search for Spring Tools 4 (aka Spring Tool Suite 4) and install it.
3. Download node.js from [here](https://nodejs.org/en/download/). Run the installer with default settings.
4. Download and install MySQL workbench with default settings. When prompted to create a user, use 'root' for username and 'root' for password. Port is set to 3306.
5. Launch MySQL workbench, double click on 'local instance' under MySQL Connections, enter root for username and password. In the Navigator, right-click and select 'Create Schema'. Name the schema as 'library'.
6. For cloning the project repo, there are two branches: 
   - The main branch contains the SpringBoot code.
   - The react branch contains the Frontend code.
7. Clone the main branch, create a new folder named frontend, clone the react branch in the frontend folder, and move it to the location `final-project-final-group-12\src\main\`.
8. Open the project in Eclipse, navigate to `final-project-final-group-12\src\main\java\edu\neu\csye6200\Demo1Application.java`, and click on the Run button. If prompted, select Run as a SpringBoot Application.
9. Open the terminal and navigate to `final-project-final-group-12\src\main\frontend\`.
10. Run `npm start`.
11. The project is now up and running!

## Individual contributions

- Zeel Patel: assignBook API ,studentBook API, addBook API, factory implementation, sorting using strean api
- Yash Zaveri: adminVerify API,searchStudentBook API, testing
- Sparsh Sanghavi: addStudent API, loginstudent API, studentProfile API, inner class ,lambda
- Smit Patel: ForntEnd in React and integration of frontend and backend and FindAllBook API
- Sandeep Kumar: addAdmin API , testing , readmeFile 
- Shubham Mangaonkar: Fornt End, exception handling




 



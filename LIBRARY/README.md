Managing a library is a very difficult task as we need to keep track of lots of things, we need to keep track of all books, how many copies there are and we also need to keep track whether they are available for students to borrow or not.

In this article, we will build a basic library management system in Java using switch statement. In this project, we will add various functionality such as adding new books, searching for books, and registering students.

Why Build this Library Management System?

While learning Java, exploring how to design and manage small applications makes our concepts more strong, with the help of this project we will understand the working of lots of things which are listed below:

We get to know how to use switch statements for menu-driven applications
We get to know how to manage data with classes and objects.
We get to know how to implement core features like search, add, and update in a real-world scenario.
Features of the Project
The library management system will support the following operations which are listed below:

Exit Application
Add a New Book
Upgrade Quantity of a Book
Search a Book
Show All Books
Register Student
Show All Registered Students
Check Out Book
Check-In Book
Let's now understand the project structure of this project.

Project Structure
Our mini-project will be split into five Java files and each will handle a specific part of the system. The table below demonstrates the file name with their responsibilty.
Project Implementation
Now, let's look at each file and see how it help the whole system work.

1. book.java:

This file will hold the detail about each book including their serial number, Book name, Author name, total quantity and available quantity and the constructor will asks the
user to enter these details whenever a new book is added.
3. Student.java:


This class represents a student in the library system. Each student has a name, registration number and each student can borrow upto 3 books at a time which are stored in an 
array and whenver a new student is added into the system, the program will asks for detials with the help of a constructor.
4.students.java:

This class will keep track of all the student registered in the library. It adds new students only when the registration number is unique. We can see a list of registered 
students as well, before a student borrow or returned a book this class will always check that this particular student is registered in the system or not. It also handles 
the process of student borrowing and returning book.
5. Library.java:

This is the main class of our project where everything comes together. This class shows a welcome message and a menu of options to the user. Using a do-while loop and a
switch statement, it lets the user choose what they want to do and then runs the right actions based on their choice. This class calls methods from the books and students 
classes to handle tasks like adding books, registering students, or checking out books. It even has a nested switch to let users search for books by either serial number or author name.

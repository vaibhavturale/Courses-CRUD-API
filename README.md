This is a simple RESTful API built using Java, Spring Boot, JPA Hibernate, and MySQL to manage a list of courses. The API provides endpoints to perform basic CRUD (Create, Read, Update, Delete) operations on courses.

Features:
Create a Course: Add a new course with details such as title, description, and duration.
Retrieve All Courses: Fetch the list of all available courses from the database.
Retrieve Course by ID: Fetch the details of a specific course using its ID.
Update a Course: Update the details (title, description, duration) of an existing course.
Delete a Course: Remove a course from the system by its ID.

Endpoints:
POST /courses/createCourse: Add a new course.
GET /courses/getAllCourse: Retrieve a list of all courses.
GET /courses/getCourseById/{id}: Retrieve a specific course by its ID.
PUT /courses/updateCourseById/{id}: Update an existing course by its ID.
DELETE /courses/deleteCourseById/{id}: Delete a course by its ID.

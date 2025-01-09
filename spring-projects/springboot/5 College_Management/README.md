Develop a Spring Boot application that manages College and Student data considering a one-to-many association between College and Students.

A College has a collegeId and a name.
A Student has an id, name, courseTaken, and marks.
A College can have multiple Students, but each Student can only be associated with one College.

**Service layer**

1. createCollege(College college): Creates a new College object and saves it to the database.

2. createStudent(Long collegeId, Student student): Creates a new Student object and assigns it to an existing College identified by collegeId, which is passed as a path variable.

3. getAllColleges(): Retrieves all colleges along with their corresponding student data.

4. getStudentsByCollegeName(String collegeName): Retrieves all students for a particular college based on the college name, sorted by the students' names in descending order.

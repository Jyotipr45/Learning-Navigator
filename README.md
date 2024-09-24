# 🎓 Learning Navigator: Exam Enrollment Service

Welcome to the **Learning Navigator**! This is a RESTful API service designed to manage the exam enrollment process for a Learning Management System (LMS). With a focus on efficiency and ease of use, this service allows students to register for exams after enrolling in their respective subjects.

## 📚 Features

- **CRUD Operations**: Manage Students, Subjects, and Exams effortlessly.
- **Foreign Key Relationships**: Ensuring data integrity across entities.
- **Error Handling**: Graceful error management with meaningful HTTP status codes.
- **Global Exception Handling**: Streamlined exception management using `@ControllerAdvice`.

## 🛠️ Endpoints

### Students

- **POST** `/students` - Register a new student.
- **GET** `/students/{studentId}` - Retrieve student details.
- **PUT** `/students/{studentId}/subject/{subjectId}` - Enroll student in a subject.
- **PUT** `/students/{studentId}/exam/{examId}` - Register student for an exam.
- **GET** `/students` - Retrieve all students.
- **DELETE** `/students/{studentId}` - Deregister a student.

### Subjects

- **POST** `/subjects` - Create a new subject.
- **GET** `/subjects/{subjectId}` - Retrieve subject details.
- **GET** `/subjects` - Retrieve all subjects.
- **DELETE** `/subjects/{subjectId}` - Remove a subject.

### Exams

- **POST** `/exams` - Schedule a new exam.
- **GET** `/exams/{examId}` - Retrieve exam details.
- **GET** `/exams` - Retrieve all exams.
- **DELETE** `/exams/{examId}` - Delete an exam.

### 🤫 Easter Egg Feature

- **GET** `/hidden-feature/{number}` - Generate a random fact about the specified number using the Numbers API! 🤩

## 🚀 Getting Started

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Jyotipr45/learning-navigator.git
   cd learning-navigator  
   ``` 

2. **🗄️Set Up the Database**:

   ✨ **Ensure you have MySQL installed and running.**

   🔧 **Configure your `application.properties` file** with the following database settings to get started:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/learning_navigator
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **🚀 Run the Application**:

    💻 **Launch the application** using the following command:

    ```bash
    ./gradlew bootRun
    ```

4. **🧪 Explore the API**:


    🔍 **Interact with the API endpoints** using tools like **Postman** or **Swagger UI**:

    - **Postman**: A powerful tool for testing APIs. Simply import the collection and start making requests!
    - **Swagger UI**: Access the interactive documentation by navigating to `http://localhost:8080/swagger-ui.html` once your application is running. Here, you can view all available endpoints and test them directly in your browser!

    🚀 Start exploring and see how the Learning Navigator can simplify exam enrollment!  

## 🧪 Testing:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ensure the reliability of the **Learning Navigator**! Basic unit tests have been implemented using **MockMvc** and **Mockito** to validate the functionality of the API. Run the tests with:

```bash
./gradlew test
```
🛠️ Code Coverage: The tests aim for high code coverage to ensure the stability of the service. Make sure to check the reports to see how well your code is covered!

## 🌟 Contribution

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We welcome contributions! 🤝

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Here’s how you can contribute:

- **Fork the Repository**: Create your own copy of the project.
- **Make Changes**: Implement features or fix bugs.
- **Submit Pull Requests**: Share your changes with me for review.
- **Report Issues**: Help improve the project by reporting bugs or suggesting enhancements.
- **Documentation**: Contribute to improving the project documentation.

Let’s collaborate to make this Learning Management System even better!


## 📜 License

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This project is licensed under the [MIT License](https://opensource.org/licenses/MIT). For more details, please refer to the LICENSE file.



## 📧 Contact

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Have questions or feedback? Don’t hesitate to reach out! 📬

- Email: paridajyotiprakash35@gmail.com
- GitHub: https://github.com/Jyotipr45

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Let's connect and enhance this project together! 🌍


    

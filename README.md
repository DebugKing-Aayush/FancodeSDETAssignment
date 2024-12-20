This project demonstrates an API automation scenario, where we validate that all users in the "FanCode" city (based on geographic coordinates) have more than 50% of their todo tasks completed.

**The project is implemented using Java with RestAssured for API testing.**

**Project Structure:**

**api.endpoints:** Contains classes for interacting with the APIs (FancodeRoutes.java)

**api.payloads:** Contains data models for POJOs (Todo.java and Users.java)

**api.test:** Contains main test class (CityUserTaskValidationTest.java)

**Requirements:**
Java 8+,
Maven for dependency management and building the project,
RestAssured for API testing,
TestNG for running tests

**Follow the steps below to set up and run the project on your local machine:**

Step 1: Clone the repository

Step 2: Navigate to the project directory

Step 3: Set up dependencies

Step 4: Run the tests

**How the Code Works**

**FancodeRoutes.java (API Endpoints) -**
This class contains methods for interacting with the APIs (GET requests to fetch users and todos). It uses RestAssured to make HTTP requests to the API.

**Todo.java and Users.java (Data Models) -**
These are POJO classes used to represent the response data structures. The Todo class holds details of the todo tasks and the Users class holds user information like id, name, city, and the geographical coordinates (geo).

**CityUserTaskValidationTest.java (Functional Test) -**
This is the core test that:
Fetches all users from the API,
Filters the users belonging to the "FanCode" city based on latitude and longitude,
Fetches all todo tasks for those users and calculates the percentage of completed tasks,
Asserts that the percentage of completed tasks is greater than 50%.

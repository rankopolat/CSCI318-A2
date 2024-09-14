
# CSCI318 Group Project Part B

## Instructions to Run

### Prerequisites

To run the project, ensure the following components are installed on your machine:

- **JDK (Java Development Kit)**: Ensure that JDK 21 is installed. Verify it by running:
  ```bash
  java --version
  ```
- **Maven**: Maven should be installed to manage dependencies and build the project. Verify it by running:
  ```bash
  mvn --version
  ```
- **IDE**: You can use any Java IDE such as Visual Studio Code, IntelliJ IDEA, or Eclipse. The instructions below are demonstrated with Visual Studio Code.

### Method 1: VSCode (using `launch.json`)

#### Steps

1. **Clone the Project**:  
   Clone the project from the GitHub repository.
   
2. **Open the Project in VSCode**:  
   Open the downloaded folder in Visual Studio Code.

3. **Select Run and Debug**:  
   On the left-hand side of VSCode, navigate to the **Run and Debug** tab in the sidebar.

4. **Run All Services**:  
   In the drop-down menu, select **Run all services** and press the play button to start all services.

5. **Access the Application**:  
   After starting the services, the application will run on ports `8080`, `8081`, and `8083`. You can test the RESTful endpoints using tools like `curl`, Postman, or a web browser.

---

### Method 2: Manually Running Each Service

#### Steps

1. **Clone the Project**:  
   Clone the project from the GitHub repository.

2. **Open the Project in Your IDE**:  
   Open the downloaded folder in your IDE (e.g., Visual Studio Code).

3. **Build the Project**:  
   In the terminal, navigate to the root directory where the `pom.xml` file is located, and run:
   ```bash
   mvn clean install
   ```
   This command compiles the code, runs any tests, and packages the application into a JAR file.

4. **Open Terminals for Each Service**:  
   After a successful build, open two additional terminals and navigate to the root directory in each.

5. **Run the Spring Boot Applications**:  
   In each terminal, run the following commands to start each service:
   ```bash
   mvn spring-boot:run -pl user-service
   mvn spring-boot:run -pl product-service
   mvn spring-boot:run -pl cart-service
   ```

6. **Access the Application**:  
   After starting all services, the application will be running on ports `8080`, `8081`, and `8083`. You can test the RESTful endpoints using `curl`, Postman, or a web browser.

---

### RESTful API Commands

#### Register Customer

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X POST -H "Content-Type:application/json" -d '{"name":"Poh", "email":"poh@uowmail.edu.au", "password":"password", "address": {"city":"Wollongong", "state":"NSW", "country":"Australia"}, "age":25, "gender":"female"}' http://localhost:8080/api/users` |
| **Windows**  | `curl -X POST -H "Content-Type:application/json" -d "{"name":"Poh", "email":"poh@uowmail.edu.au", "password":"password", "address": {"city":"Wollongong", "state":"NSW", "country":"Australia"}, "age":25, "gender":"female"}" http://localhost:8080/api/users` |

#### Fetch All Customers

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X GET http://localhost:8080/api/users`                                                                                                                                    |
| **Windows**  | `curl -X GET http://localhost:8080/api/users`                                                                                                                                         |

#### Fetch Customer by ID

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X GET http://localhost:8080/api/users/1`                                                                                                                                   |
| **Windows**  | `curl -X GET http://localhost:8080/api/users/1`                                                                                                                                       |

#### Login Customer

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X POST -H "Content-Type:application/json" -d '{ "email":"poh@uowmail.edu.au", "password":"password"}' http://localhost:8080/api/users/login`                                  |
| **Windows**  | `curl -X POST -H "Content-Type:application/json" -d "{ "email":"poh@uowmail.edu.au", "password":"password"}" http://localhost:8080/api/users/login`                            |

#### Create Cart for Customer

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X POST http://localhost:8080/api/users/1/carts`                                                                                                                            |
| **Windows**  | `curl -X POST http://localhost:8080/api/users/1/carts`                                                                                                                                |

#### Fetch Customer’s Carts

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X GET http://localhost:8080/api/users/1/carts`                                                                                                                             |
| **Windows**  | `curl -X GET http://localhost:8080/api/users/1/carts`                                                                                                                                 |

#### Add Product to Cart

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X PUT -H "Content-Type:application/json" -d '{ "productId":1, "quantity":5}' http://localhost:8080/api/users/1/carts/1/products`                                            |
| **Windows**  | `curl -X PUT -H "Content-Type:application/json" -d "{ "productId":1, "quantity":5}" http://localhost:8080/api/users/1/carts/1/products`                                           |

#### Fetch Products in Cart

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X GET http://localhost:8080/api/users/1/carts/1/products`                                                                                                                  |
| **Windows**  | `curl -X GET http://localhost:8080/api/users/1/carts/1/products`                                                                                                                      |

#### Remove Product from Cart

| OS           | Command                                                                                                                                                                              |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **MacOS/Linux**  | `curl -X DELETE http://localhost:8080/api/users/1/carts/1/products/1`                                                                                                             |
| **Windows**  | `curl -X DELETE http://localhost:8080/api/users/1/carts/1/products/1`                                                                                                                 |

---

### Conclusion

Follow these steps and commands to run our CSCI318 Group Project Part B and interact with the services via the provided RESTful endpoints. You can use tools like `curl`, Postman, or a web browser to test and verify the services.

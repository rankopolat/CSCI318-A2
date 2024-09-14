# CSCI318 Part B

## Instructions To Run

### Prerequisites

- To run the project, we need three components installed on the computer.
JDK(Java Development Kit):Ensure that JDK 21 is installed on your system. You can verify this by running (java --version) in the terminal.
- Maven:Maven should be installed to manage dependencies and build the project. You can check if Maven is already installed by running (maven --version) in the terminal
- IDE: As an IDE you can use any java IDE such as visual studio code, intelliJ or Eclipse etc.

If you have already installed the above three, go to the Spring Initializr to download a Spring project template. 
Choose Maven in Project, Choose Java in Language. Choose a version of Spring Boot, for example 3.3.2. 
Choose Jar in Packaging and Java 21. In Dependencies, add Web, JPA and H2.
Click "GENERATE", download and extract the zip file. Open the project folder in the IDE of your choice. 
Since we are using VSC, we would like to demonstrate with vscode instructions.

### Method 1 : VSCODE ONLY (launch.json)
### Steps

#### Step 1: Clone the Project
Clone the project from the github repository.

#### Step 2: Open the Project in Vscode
Open the downloaded folder in vscode.

#### Step 3: Select Run and Debug
On the lefthand side of vscode in the tab bar goto Run and Debug

#### Step 3: Select Run and Debug
On the lefthand side of vscode in the tab bar goto Run and Debug

#### Step 4: Select Run all Services and run
selecting the drop down choose Run all services and press the play button to start all services


### Method 2
### Steps

#### Step 1: Clone the Project
Clone the project from the github repository.

#### Step 2: Open the Project in Your IDE( in this case Vscode)
Open the downloaded folder in vscode.

#### Step 3: Build the Project
In the terminal, navigate to the root directory of the project where pom.xml is located and run 
mvn clean install >> this command will compile the code, and run any tests, and package the application into a JAR file. 

#### Step 4: Open a new terminal for each individual service
Following successful build of the project, 2 new terminals needs to be opened navigating to the root directory

#### Step 5: Run the Spring Boot Application

In each terminal enter the following command

mvn spring-boot:run -pl user-service
mvn spring-boot:run -pl product-service
mvn spring-boot:run -pl cart-service

#### Step 6: Access the Application
After starting the application, it should be running on ports 8080, 8081 and 8083.
You can test the RESTful endpoints using tools like curl, Postman, or your web browser.



| Register Customer    | Command/Response      |
|--------------|--------------------------------------|
| MacOS/Linux  | `{ curl -X POST -H "Content-Type:application/json" -d '{"name":"Poh", "email":"poh@uowmail.edu.au","password":"password", "address": {"city":"Wollongong", "state":"NSW", "country":"Australia"}, "age":25, "gender":"female"}' http://localhost:8080/api/users}`|
| Windows      | `{ curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"Poh\", \"email\":\"poh@uowmail.edu.au\", \"password\":\"password\", \"address\": {\"city\":\"Wollongong\", \"state\":\"NSW\", \"country\":\"Australia\"}, \"age\":25, \"gender\":\"female\"}" http://localhost:8080/api/users }`  |


| Fetch Customers    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users `                                                                                                                                    |


| Fetch Customer by ID   | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/1`                                                                                                                                    |
| Windows      | `curl -X GET http://localhost:8080/api/users/1`                                                                                                                                    |


| Login Customer    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X POST -H "Content-Type:application/json" -d '{ "email":"poh@uowmail.edu.au","password":"password"}' http://localhost:8080/api/users/login`  |
| Windows      | `curl -X POST -H "Content-Type:application/json" -d "{ \"email\":\"poh@uowmail.edu.au\",\"password\":\"password\"}" http://localhost:8080/api/users/login`   |


| Create Cart   | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X POST http://localhost:8080/api/users/1/carts` |
| Windows      | `curl -X POST http://localhost:8080/api/users/1/carts`   |


| Fetch Customers Carts   | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/1/carts` |
| Windows      | `curl -X GET http://localhost:8080/api/users/1/carts`   |


| Add Product to cart    | Command/Response                                                                                                                                         |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X PUT -H "Content-Type:application/json" -d '{ "productId":1,"quantity":5}' http://localhost:8080/api/users/1/carts/1/products` |
| Windows      | `curl -X PUT -H "Content-Type:application/json" -d "{ \"productId\":1,\"quantity\":5}" http://localhost:8080/api/users/1/carts/1/products`   |


| Fetch Products in Cart    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/1/carts/1/products` |
| Windows      | `curl -X GET http://localhost:8080/api/users/1/carts/1/products`   |



| Remove Product From Cart    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X DELETE http://localhost:8080/api/users/1/carts/1/products/1` |
| Windows      | `curl -X DELETE http://localhost:8080/api/users/1/carts/1/products/1`   |


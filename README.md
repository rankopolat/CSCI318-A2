# CSCI318 Part B




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


| Add Product to cart    | Command/Response                                                                                                                                                                     |
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


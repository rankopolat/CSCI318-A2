| Request 1    | Command/Response      |
|--------------|--------------------------------------|
| MacOS/Linux  | `{ curl -X POST -H "Content-Type:application/json" -d '{"name":"Poh", "email":"poh@uowmail.edu.au","password":"password", "address": {"city":"Wollongong", "state":"NSW", "country":"Australia"}, "age":25, "gender":"female"}' http://localhost:8080/api/users}`|
| Windows      | `{ curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"Poh\", \"email\":\"poh@uowmail.edu.au\", \"password\":\"password\", \"address\": {\"city\":\"Wollongong\", \"state\":\"NSW\", \"country\":\"Australia\"}, \"age\":25, \"gender\":\"female\"}" http://localhost:8080/api/users }`  |


| Request 2    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users `                                                                                                                                    |


| Request 3    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/1`                                                                                                                                    |
| Windows      | `curl -X GET http://localhost:8080/api/users/1`                                                                                                                                    |


| Request 4    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X POST -H "Content-Type:application/json" -d '{ "email":"poh@uowmail.edu.au","password":"password"}' http://localhost:8080/api/users/login`  |
| Windows      | `curl -X POST -H "Content-Type:application/json" -d "{ \"email\":\"poh@uowmail.edu.au\",\"password\":\"password\"}" http://localhost:8080/api/users/login`   |


| Request 5    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X POST http://localhost:8080/api/users/1/carts` |
| Windows      | `curl -X POST http://localhost:8080/api/users/1/carts`   |


| Request 6    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/1/carts` |
| Windows      | `curl -X GET http://localhost:8080/api/users/1/carts`   |


| Request 7    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X PUT -H "Content-Type:application/json" -d '{ "productId":1,"quantity":5}' http://localhost:8080/api/users/1/carts/1/products` |
| Windows      | `curl -X PUT -H "Content-Type:application/json" -d "{ \"productId\":1,\"quantity\":5}" http://localhost:8080/api/users/1/carts/1/products`   |


| Request 8    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/1/carts/1/products` |
| Windows      | `curl -X GET http://localhost:8080/api/users/1/carts/1/products`   |



| Request 9    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X DELETE http://localhost:8080/api/users/1/carts/1/products/1` |
| Windows      | `curl -X DELETE http://localhost:8080/api/users/1/carts/1/products/1`   |


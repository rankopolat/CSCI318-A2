| Request 1    | Command/Response      |
|--------------|--------------------------------------|
| MacOS/Linux  | `{ curl -X POST -H "Content-Type:application/json" -d '{"name":"Poh", "email":"poh@uowmail.edu.au","password":"password", "address":"Wollongong", "age":25, "gender":"female"}' http://localhost:8080/api/users }`|
| Windows      | `{ curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"Poh\", \"email\":\"poh@uowmail.edu.au\",\"password\":\"password\", \"address\":\"Wollongong\", \"age\":25, \"gender\":\"female\"}" http://localhost:8080/api/users }`  |
| Returns      | `{ "id": 4, "name": "Poh", "email": "poh@uowmail.edu.au", "password": "password", "address": "Wollongong", "age": 25, "gender": "female" }`|


| Request 2    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users `                                                                                                                                    |
| Windows      | `curl -X GET http://localhost:8080/api/users `                                                                                                                                    |
| Returns      | `[ ]`                                  |


| Request 3    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/4`                                                                                                                                    |
| Windows      | `curl -X GET http://localhost:8080/api/users/4`                                                                                                                                    |
| Returns      | `[ { "id": 4, "name": "Poh", "email": "poh@uowmail.edu.au", "password": "password", "address": "Wollongong", "age": 25, "gender": "female" } ]`                                  |


| Request 4    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X POST -H "Content-Type:application/json" -d '{ "email":"poh@uowmail.edu.au","password":"password"}' http://localhost:8080/api/users/login`  |
| Windows      | `curl -X POST -H "Content-Type:application/json" -d "{ \"email\":\"poh@uowmail.edu.au\",\"password\":\"password\"}" http://localhost:8080/api/users/login`   |
| Returns      | `[ { "id": 4, "name": "Poh", "email": "poh@uowmail.edu.au", "password": "password", "address": "Wollongong", "age": 25, "gender": "female" } ]`                                  |


| Request 5    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X POST http://localhost:8080/api/users/4/carts` |
| Windows      | `curl -X POST http://localhost:8080/api/users/4/carts`   |
| Returns      | `{ "id": 1, "customerId": 4, "date": "2024-09-12T06:23:05.054+00:00" }`                                  |


| Request 6    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/4/carts` |
| Windows      | `curl -X GET http://localhost:8080/api/users/4/carts`   |
| Returns      | `[ { "id": 1, "customerId": 4, "date": "2024-09-12T06:23:05.054+00:00" } ]`                                  |


| Request 7    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X PUT -H "Content-Type:application/json" -d '{ "productId":1,"quantity":5}' http://localhost:8080/api/users/carts/1/products` |
| Windows      | `curl -X PUT -H "Content-Type:application/json" -d "{ \"productId\":1,\"quantity\":5}" http://localhost:8080/api/users/carts/1/products`   |
| Returns      | `1` |


| Request 8    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X GET http://localhost:8080/api/users/carts/1/products` |
| Windows      | `curl -X GET http://localhost:8080/api/users/carts/1/products`   |
| Returns      | `{"id": 3, "productId": 1, "quantity": 5, "name": "Apple" }`     |



| Request 9    | Command/Response                                                                                                                                                                     |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MacOS/Linux  | `curl -X DELETE http://localhost:8080/api/users/carts/1/products/1` |
| Windows      | `curl -X DELETE http://localhost:8080/api/users/carts/1/products/1`   |
| Returns      | `1`     |



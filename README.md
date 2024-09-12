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




POST:http://localhost:8080/api/users/

GET:http://localhost:8080/api/users/


POST:http://localhost:8080/api/users/login

GET:http://localhost:8080/api/users/1


GET: http://localhost:8080/api/users/1/carts

POST: http://localhost:8080/api/users/1/carts


GET: http://localhost:8080/api/users/1/carts/1


GET: http://localhost:8080/api/users/carts/1/products


PUT: http://localhost:8080/api/users/carts/1/products

body:
{
  "productId":1,
  "quantity":5
}


DELETE: http://localhost:8080/api/users/carts/1/products/1


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


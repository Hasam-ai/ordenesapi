#!/bin/bash

echo "=============================="
echo "1. Crear usuario"
echo "=============================="

curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Antonio",
  "email": "antonio@mail.com",
  "telefono": "123456789"
}'

echo -e "\n\n=============================="
echo "2. Obtener usuarios"
echo "=============================="

curl http://localhost:8080/users


echo -e "\n\n=============================="
echo "3. Crear productos"
echo "=============================="

curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Laptop",
  "precio": 15000,
  "stock": 10
}'

curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Mouse",
  "precio": 300,
  "stock": 50
}'

echo -e "\n\n=============================="
echo "4. Obtener productos"
echo "=============================="

curl http://localhost:8080/products


echo -e "\n\n=============================="
echo "5. Crear orden válida"
echo "=============================="

curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{
  "userId": 1,
  "items": [
    {
      "productId": 1,
      "cantidad": 2
    },
    {
      "productId": 2,
      "cantidad": 3
    }
  ]
}'


echo -e "\n\n=============================="
echo "6. Obtener órdenes"
echo "=============================="

curl http://localhost:8080/orders


echo -e "\n\n=============================="
echo "7. Prueba de error (stock insuficiente)"
echo "=============================="

curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{
  "userId": 1,
  "items": [
    {
      "productId": 1,
      "cantidad": 999
    }
  ]
}'
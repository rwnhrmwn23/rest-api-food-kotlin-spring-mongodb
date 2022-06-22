# Food REST API

## Tech Stack

1. Kotlin Language
2. Spring Framework
3. MongoDB

## Deploy Heroku

```
Deploy : 
Using GitHub Action

Log    :
heroku logs --tail -a rest-api-food-kotlin-spring

Note   : 
rest-api-food-kotlin-spring is app name heroku
```

## Base url

```
https://rest-api-food-kotlin-spring.herokuapp.com/
```

## Table Endpoints

### Food

| Name        | Endpoint       | Method   | Bearer token | Body and response         |
|-------------|----------------|----------|--------------|---------------------------|
| Get Food    | `v1/food`      | `GET`    | no           | [example](#food---get)    |
| Add Food    | `v1/food`      | `POST`   | no           | [example](#food---post)   |
| Update Food | `v1/food/{id}` | `PUT`    | no           | [example](#food---put)    |
| Delete Food | `v1/food/{id}` | `DELETE` | no           | [example](#food---delete) |

### Food - GET

```
GET v1/food
```

Body

```
none
```

Response Success

```json
{
  "message": "Retrieve Food Success",
  "status": true,
  "data": [
    {
      "id": "e7ba2ac9-5d67-4eef-abc9-56e4495db68a",
      "name": "Gadp-gado",
      "description": "Gado-gado adalah makanan khas Jakarta berisi sayur-sayuran yang direbus, irisan telur dan tahu, serta ditaburi bawang goreng dan kerupuk."
    }
  ]
}
```

Response Failed

```json
{
  "message": "Food is Empty",
  "status": false,
  "data": null
}
```

### Food - POST

```
POST v1/food
```

Body

```json
{
  "name": "Gado-gado",
  "description": "Gado-gado adalah makanan khas Jakarta berisi sayur-sayuran yang direbus, irisan telur dan tahu, serta ditaburi bawang goreng dan kerupuk."
}
```

Response Success

```json
{
  "message": "Add Food Data Success",
  "status": true,
  "data": [
    {
      "id": "a7a0a3ed-f069-4768-8dc2-263e6724ec93",
      "name": "Gadp-gado",
      "description": "Gado-gado adalah makanan khas Jakarta berisi sayur-sayuran yang direbus, irisan telur dan tahu, serta ditaburi bawang goreng dan kerupuk."
    }
  ]
}
```

### Food - PUT

```
PUT v1/food/{id}
```

Params

```
path id
```

Body

```json
{
  "name": "Toprak",
  "description": "Toprak adalah makanan khas Jakarta berisi sayur-sayuran yang direbus, irisan telur dan tahu, serta ditaburi bawang goreng dan kerupuk."
}
```

Response Success

```json
{
  "message": "Update Food Data Success",
  "status": true,
  "data": [
    {
      "id": "a7a0a3ed-f069-4768-8dc2-263e6724ec93",
      "name": "Toprak",
      "description": "oprak adalah makanan khas Jakarta berisi sayur-sayuran yang direbus, irisan telur dan tahu, serta ditaburi bawang goreng dan kerupuk."
    }
  ]
}
```

### Food - DELETE

```
DELETE v1/food/{id}
```

Params

```
path id
```

Body

```
none
```

Response Success

```json
{
  "message": "Delete Food Data Success",
  "status": true,
  "data": [
    {
      "id": "823eba02-555b-4f27-8980-8eaf35a3000c",
      "name": "Toprak",
      "description": "Toprak adalah makanan khas Jakarta berisi sayur-sayuran yang direbus, irisan telur dan tahu, serta ditaburi bawang goreng dan kerupuk."
    }
  ]
}
```
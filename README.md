# API Spec

## Authentication

All API must use this authentication

Request:
- Header:
    - X-Api-Key: "your secret api key"

## Create Employee
**Request:**
- Method    : POST
- Endpoint  : `/api/employees`
- Header    :
    - Content-Type: application/json
    - Accept: application/json
- Body      :
```json
{
  "id": "string, unique",
  "name":  "string",
  "position": "string"
}
```
**Response:**
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "string, unique",
    "name":  "string",
    "position": "string",
    "createdAt":  "date",
    "updatedAt": "date"
  }
}
```

## Get Employee
**Request:**
- Method    : GET
- Endpoint  : `/api/employees/{id_employee}`
- Header    :
    - Accept: application/json

**Response:**
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "string, unique",
    "name":  "string",
    "position": "string",
    "createdAt":  "date",
    "updatedAt": "date"
  }
}
```

## Update Employee
**Request:**
- Method    : PUT
- Endpoint  : `/api/employees/{id_employee}`
- Header    :
    - Content-Type: application/json
    - Accept: application/json
- Body      :
```json
{
  "name":  "string",
  "position": "string"
}
```
**Response:**
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "string, unique",
    "name":  "string",
    "position": "string",
    "createdAt":  "date",
    "updatedAt": "date"
  }
}
```


## List Employees
**Request:**
- Method    : GET
- Endpoint  : `/api/employees`
- Header    :
    - Accept: application/json
- Query Param:
    - page : number
    - size : number

**Response:**
```json
{
  "code": "number",
  "status": "string",
  "data": [
      {
          "id": "string, unique",
          "name":  "string",
          "position": "string",
          "createdAt":  "date",
          "updatedAt": "date"
      },
      {
          "id": "string, unique",
          "name":  "string",
          "position": "string",
          "createdAt":  "date",
          "updatedAt": "date"
      }      
  ] 
}
```

## Delete Employee
**Request:**
- Method    : DELETE
- Endpoint  : `/api/employees/{id_employee}`
- Header    :
    - Accept: application/json
- Body      :

**Response:**
```json
{
  "code": "number",
  "status": "string"
}
```

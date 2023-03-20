# Spring trading app demo API

A little project of a REST API in Spring.

It uses authentication via JWT, so each endpoint is protected except `login` and `signup` obviously that will respond with a JWT token.

For every other endpoint you'll need an `Authorization` header in your request, like so :

```http request
Authorization: Bearer MY.JWT.TOKEN
```

So in the following table each secured endpoint must have this header to work. 

This is a demo project, a lot of things need to be improved (pagination for index endpoints, etc.)

## Endpoints API

| Method | Secured | Route                        | Description                                                                                  |
|--------|---------|------------------------------|----------------------------------------------------------------------------------------------|
| GET    | ❌       | /api/v1/auth/login           | Login                                                                                        |
| POST   | ❌       | /api/v1/auth/signup          | Signup                                                                                       |
| PUT    | ✅       | /api/v1/user/update          | Update user's profile (except balance)                                                       |
| GET    | ✅       | /api/v1/user/currentBalance  | Return current balance (all the money that is NOT in an open position)                       |
| GET    | ✅       | /api/v1/profile              | Fetch all the profile data, including the user's balance                                     |
| POST   | ✅       | /api/v1/wire                 | Make a wire (deposit OR withdraw money)                                                      |
| GET    | ✅       | /api/v1/trades/index         | Fetch all our trades                                                                         |
| GET    | ✅       | /api/v1/trade/:id            | Fetch one trade info                                                                         |
| GET    | ✅       | /api/v1/trade/index/open     | Fetch all our open trades                                                                    |
| GET    | ✅       | /api/v1/trade/index/closed   | Fetch all our closed trades                                                                  |
| POST   | ✅       | /api/v1/trade/openTrade/     | Open a long position (buy), the amount and the stock is specified in the body of the request |
| POST   | ✅       | /api/v1/trade/closeTrade/:id | Close the position                                                                           |
| GET    | ✅       | /api/v1/trade/closedPNL      | Return the total closed PNL (all closed trades)                                              |
| GET    | ✅       | /api/v1/trade/openPNL        | Return the total open PNL (all open trades)                                                  |

### Requests and responses format

#### GET /api/v1/auth/login
Request:
```json
{
	"email": "hello@gmail.com",
	"password": "123456"
}
```

Response :
```json
{
	"token": "JWT_TOKEN"
}
```
### POST /api/v1/auth/signup

Request:
```json
{
  "email": "john@wayne.com",
  "password" : "123456",
  "first_name": "John",
  "last_name": "Wayne",
  "address": "Far in the West",
  "phone_number": "1-111-111-111"
}
```

Response :
```json
{
	"token": "JWT_TOKEN"
}
``` 

### PUT /api/v1/user/update

Request's body :
```json
{
  "email": "john@wayne.com",
  "password" : "123456",
  "first_name": "John",
  "last_name": "Wayne",
  "address": "Far in the West",
  "phone_number": "1-111-111-111"
}
```

Response : 200

### GET /api/v1/user/currentBalance


Request:
```json
{
  "user_id": "1234"
}
```

Response :
```json
{
	"current_balance_in_cent": 12345
}
``` 


### GET /api/v1/profile

Request :

```json
{
  "user_id": "1234"
}
```

Response :

```json
{
  "email": "john@wayne.com",
  "first_name": "John",
  "last_name": "Wayne",
  "address": "Far in the West",
  "phone_number": "1-111-111-111"
}
```


### POST /api/v1/wire

Request : 

```json
{
  "amount_in_cent": 12345,
  "withdrawal" : false
}
```
Response : 201

### GET /api/v1/trades/index

Request :

```json
{
  "user_id": "1234"
}
```

Response : 

```json
{
  "trades": [
    {
      "id": 1,
      "close_date_time": "2022-04-19T22:18:19.650972",
      "close_price_in_cent": 8004,
      "open": false,
      "open_date_time": "2022-03-19T22:18:19.650787",
      "open_price_in_cent": 1318,
      "quantity": 17.0,
      "symbol": "TDW"
    },
    {
      "id": 2,
      "close_date_time": "2022-04-19T22:18:19.656258",
      "close_price_in_cent": 6061,
      "open": true,
      "open_date_time": "2022-03-19T22:18:19.656244",
      "open_price_in_cent": 5880,
      "quantity": 13.0,
      "symbol": "ARNC"
    },
    {
      "id": 3,
      "close_date_time": "2022-04-19T22:18:19.658076",
      "close_price_in_cent": 8978,
      "open": false,
      "open_date_time": "2022-03-19T22:18:19.658067",
      "open_price_in_cent": 7254,
      "quantity": 44.0,
      "symbol": "UHS"
    }
  ]
}
```
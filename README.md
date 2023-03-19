# Spring trading app demo API

A little project of a REST API in Spring.

It uses authentication via JWT, so each endpoint is protected except `login` and `signup` obviously that will respond with a JWT token.

For every other endpoint you'll need an `Authorization` header in your request, like so :

```http request
Authorization: Bearer MY.JWT.TOKEN
```


## Endpoints API

| Method | route                        |                                                                                              |
|--------|------------------------------|----------------------------------------------------------------------------------------------|
| GET    | /api/v1/auth/login           | Login                                                                                        |
| POST   | /api/v1/auth/signup          | Signup                                                                                       |
| PATCH  | /api/v1/user/update          | Update user's profile (except balance)                                                       |
| GET    | /api/v1/user/currentBalance  | Return current balance (all the money that is NOT in an open position)                       |
| GET    | /api/v1/profile              | Fetch all the profile data, including the user's balance                                     |
| POST   | /api/v1/wire                 | Make a wire (deposit OR withdraw money)                                                      |
| GET    | /api/v1/trades/index         | Fetch all our trades                                                                         |
| GET    | /api/v1/trade/:id            | Fetch one trade info                                                                         |
| GET    | /api/v1/trade/index/open     | Fetch all our open trades                                                                    |
| GET    | /api/v1/trade/index/closed   | Fetch all our closed trades                                                                  |
| POST   | /api/v1/trade/openTrade/     | Open a long position (buy), the amount and the stock is specified in the body of the request |
| POST   | /api/v1/trade/closeTrade/:id | Close the position                                                                           |
| GET    | /api/v1/trade/closedPNL      | Return the total closed PNL (all closed trades)                                              |
| GET    | /api/v1/trade/openPNL        | Return the total open PNL (all open trades)                                                  |


### Signup's request body

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

(Note that this is not safe to send the password in plaint text but this is a demo) 

### Login's request body

```json
{
  "email": "john@wayne.com",
  "password" : "123456"
}
```

(Same remark as for the Signup) 
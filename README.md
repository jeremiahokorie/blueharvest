# Blue Harvest Back-end Assignment
The assessment consists of an API to be used for opening a new “current account” of
already existing customers.

### Requirements
- The API will expose an endpoint which accepts the user information (customerID,
initialCredit).
- Once the endpoint is called, a new account will be opened connected to the user
whose ID is customerID.
- Also, if initialCredit is not 0, a transaction will be sent to the new account.
- Another Endpoint will output the user information showing Name, Surname,
balance, and transactions of the accounts.

### Bonuses
- Accounts and Transactions are different services.
- Frontend (simple one is OK).
- Attention to CI/CD

### Constraints
- Feel free to use any open source tool or framework.
- For storing the information, the data can be saved in memory and not actually persisted to
an external database, so that we can test the solution easier. However, remember this is a
backend assignment and consider layers, abstractions, testability and enterprise-level
architecture carefully.
- The programming language by default is Java / C# but we are flexible if you let us know
which other language you prefer.

### Expectations
- The expected deliverable is the source code published on github or gitlab and instructions
on how to execute and test it.
- We hope to see demonstration of good git practice and workflow; show us how you work in
a team. Testability will be also assessed.
- Show your knowledge beyond boilerplate endpoints!

### What is already configured for you
> Bear in mind you do not have to stick with the predefined code and configurations,
> you can make changes as you wish. Those are only intended to facilitate your work and save time.
- Controllers with their base endpoints, but their methods are not implemented.
- DTO and entity classes that are **not fully implemented**.
- JPA based repositories without any methods.
- An in-memory H2 database.

## Testing the API
- SwaggerDoc Url -- http://localhost:8080/swagger-ui/
- Using Postman
- Sample Request for Opening Account: 
- Url: http://localhost:8080/api/v1/account/create
- {
  "customerId":1,
  "initialCredit":50
  }
- Sample Response for Opening Account

- {
  "message": "Successful",
  "status": "200",
  "data": {
  "accountId": 1,
  "accountNumber": "ACC--248513252",
  "balance": 50,
  "type": "current",
  "createdAt": "2024-02-20T06:03:36.130+00:00",
  "ownerId": 1,
  "transactions": [
  {
  "transactionId": 1,
  "amount": 50,
  "balance": 50,
  "createdAt": "2024-02-20T06:03:36.147+00:00",
  "description": "Initial credit"
  }
  ]
  }
  }
## How to set up on local machine
- install intelliJ IDE
- JAVA 17 and Above
- Install Maven on System
- clone the source code from https://github.com/jeremiahokorie/blueharvest into your IDE or local directory and open from the IDE
- select the JDK version and build project


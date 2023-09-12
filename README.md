# PlayerReevoo
A Platform to Rate and Review your Favourite Athletes (in Spring Boot)
From Football to Volleyball and Beyond, with Friends and Foes.

## Current Features
* CRUD functionality:
  * Allows users to create and manage an account.
  * Ability to create player profile and review them.
* Authentication and Authorization (Spring Security):
  * Authenticates users to determine authorization status.
  * Utilizes role-based authorization to determine which users can access which pages and alter db data.
  
## API Documentation
  You can get the documentation for this API [here](https://documenter.getpostman.com/view/28804282/2s9YC1XaFJ)

## HTTP Requests
All API requests are made by sending a secure HTTPS request using one of the following methods:

* POST Create a resource

* GET Get a resource or list of resources

* PUT updates a resource or list of resources

* DELETE deletes a resource or list of resources

  For POST, the body of your request must be a JSON payload.

## HTTP Response Codes

Each response will be returned with one of the following HTTP status codes:


* 200 OK Successful request

* 400 Bad Request There was a problem with the request

* 500 Server Error Server error


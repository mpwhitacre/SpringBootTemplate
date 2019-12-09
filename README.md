# Onboarding

### Description:
Create a restful web service to manage employees for a new company.

The information required to accurately track and manage employees is:
* First Name
* Last Name
* Middle Name
* Age
* Office location (location choices are "VA", "DC", "MD")
* Employee Title
* Start Date
* Whether or not they are currently working at the company ("True/False", "0/1")
* End Date (if they are not currently working with the company) 

This service should provide the following features:
* Add new employee
* Bulk add of new employees (Set<Employee> employees)
* Delete existing employee
* Edit existing employee
* List all employees
* List employees meeting a specific criteria
* List a specific employee

This service should handle errors properly and gracefully fail without disrupting the entire operation.

### Tasks:
* Use Liquibase to provision a mysql or postgreSQL database to fit an employee entity.
* Use Spring JPA to create a controller, model, repository, and service to fit the requested features.
* Write tests with Mockito to cover feature requirements

### Resources:
* https://www.petrikainulainen.net/spring-data-jpa-tutorial/
* https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
* https://www.liquibase.org/documentation/index.html


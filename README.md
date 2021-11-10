# Blog API

This project is my learning project for Spring boot.

### Main Components
- authentication apis 
  - registration
  - login
  
- blogs api
  - Blog Write (new blog)
  - blogs list
  - blog detail


Registration api is used for creating the account for the new user. 
User needs to send a name, email and password. 
Registration api validates the given email, if the email is in correct format and not an existing user then stores these details to the database as a new user.


Login api is used to authenticate the user. 
User sends email and password. Login api checks the user details to the database, if its a valid request then sends a Jwt token in return. 

### Project Demonstrates
- JWT Based Stateless Authentication



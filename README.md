# Maven Project Sample Java REST API
Implements a Java Sample Rest API using Jax-rs

# An Example of Java Rest API using Property file.
*All Responses are in "APPLICATION_JSON"
* Some EndPoints of this Api are:

[Root] :: http://localhost:8080/JavaRest/demo/


// Returns All Members from Database

[GET] :: /getMembers

// Returns Members by Mobile from Database

[GET] :: /getMembers/{mobile}

// Return a specific member Profile from Database

[GET] :: /getMembersProfile/{mobile}

// Response Object which will be boolean in case of invalid user and an Object of data in case of valid

[POST] :: /login

// Member Data Update Method with POST URL

[POST] :: /setMember

and so on..

Used Db3 for Database. CORSFilter are already Implemented.

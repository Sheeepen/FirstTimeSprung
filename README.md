A web application powered by Springboot to help athletes track their runs. 
It uses RESTful API, separated into three layers: Controller, Logic, and Database.
The rest-service directory uses a embedded h2 server as the database, using JDBC API to connect the web app to the database.
Future iteration will attempt to use JPA and Hibernate to connect to an Oracle database.

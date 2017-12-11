# spring-restapi

this is a demo app that displays the use of restcontroller for CRUD operation in MYSQL database

#included dependencies

1. spring-boot-starter-data-jpa
2. spring-boot-starter-web
3. mysql-connector-java
4. jackson-databind


#CRUD for "article" table

1. Create : 
HTTP Method: POST, URL: /user/article 

2. Read : 
HTTP Method: GET, URL: /user/article/{id} 
HTTP Method: GET, URL: /user/articles 

3. Update : 
HTTP Method: PUT, URL: /user/article 

4. Delete : 
HTTP Method: DELETE, URL: /user/article/{id}


#CRUD for "note" table

BASE RequestMapping: "/noteapi"
2. "/ping"          :   GET     :   checks if the link works
3. "/notes"         :   GET     :   list all notes
4. "/notes"         :   POST    :   add a note (include "title" and "content" in request body)
5. "/notes/{id}"    :   GET     :   get a specific note
6. "/notes/{id}"    :   PUT     :   update note (include "title" and "content" in request body)
7. "/notes/{id}"    :   DELETE  :   delete a note

# notworking
A spring boot jpa project that has lots of issues to be fixed
This app should be able to pass all tests and respond to these endpoints:

localhost:8080/book

localhost:8080/book/1

localhost:8080/book/save  ->  with request body {"name":"book1", "year":2022, "author":{"id":1}}

localhost:8080/book/delete

localhost:8080/author/save

localhost:8080/author/1

localhost:8080/actuator/env

localhost:8080/actuator/env/spring.jpa.hibernate.ddl-auto

localhost:8080/actuator/mappings

localhost:8080/actuator/httptrace

localhost:8080/actuator/metrics

localhost:8080/actuator/metrics/hikaricp.connections.min

localhost:8080/actuator/beans

localhost:8080/actuator/health

localhost:8080/actuator/health/db

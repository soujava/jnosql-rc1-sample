# Jakarta NoSQL Miliestone Version

Eclipse JNoSQL is a Java framework that streamlines the integration of Java applications with NoSQL databases. It defines a set of APIs and provides a standard implementation for most NoSQL databases. This clearly helps achieve very low coupling with the underlying NoSQL technologies used in applications. The objective of this session is to show how to use the Eclipse JNoSQL framework to connect with a NoSQL database and perform operations to manipulate and extract information.

## Requirements

* [Git](https://git-scm.com/book/en/v1/Getting-Started-Installing-Git)
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3 or higher Configured](https://maven.apache.org/download.cgi)
* [Docker 17.12.1-ce or higher](https://docs.docker.com/install/#next-release)
* [Docker Compose 1.21.2 or higher](https://docs.docker.com/v17.09/compose/install/)
* Any IDE that supports maven and Java 8
  * [Eclipse](https://www.eclipse.org/downloads/)
  * [NetBeans](https://netbeans.org/)
  * [IntelliJ](https://www.jetbrains.com/idea/download/)

## Servers

* Helidon

## Run the code

* `git clone https://github.com/JNOSQL/oc1-hands-on-2018.git`
* `cd oc1-hands-on-2018`
* `mvn clean install`
* Run databases
  * Run Docker Compose

### Run as Docker-Compose

#### Start fresh environment

`docker-compose -f docker-compose.yml up -d`

#### Stop and Remove

`docker-compose -f docker-compose.yml down`

####  List services
`docker-compose -f docker-compose.yml ps`


## Helidon and Column API (Cassandra)

`mvn -DskipTests clean package`
`java -jar -Xmx512m -Dserver.port=$PORT target/column.jar`

### Insert Data

`curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/heroes --data '{"id": "iron_man", "name": "Iron man", "powers": ["Rich", "Armor"]}'`

### Returning Data

`curl -X GET -i http://localhost:8080/heroes`
`curl -X GET -i http://localhost:8080/heroes/iron_man`
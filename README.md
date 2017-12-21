# Spring Boot,Spring Data and Elasticsearch

In this example, we will discuss about How to create a Spring Boot, Spring Data and Elasticsearch Example.

## Tools/libraries used

1. Spring Boot
2. Spring Boot Starter Data Elasticsearch
3. Elasticsearch 2.4
5. Kibana 4.6

>**SpringBoot 1.5.*.RELEASE supports only ElasticSearch 2.4.0. They don’t support the latest version of ElasticSearch 5.x version. Read this – [Spring Data Elasticsearch Spring Boot version matrix](https://github.com/spring-projects/spring-data-elasticsearch/wiki/Spring-Data-Elasticsearch---Spring-Boot---version-matrix) and [ELK Compatibility](https://www.elastic.co/support/matrix#matrix_compatibility)**


## Elastic and kibana installation

Run this command in the docker container to install elastic search

``docker run -d -it --name kuldeep -p 9200:9200 -p 9300:9300 -e ES_JAVA_OPTS="-Xms1g -Xmx1g" -m 1500m elasticsearch:2.4``

Run this command in the docker container to install kibana

``docker run -d -it --name kibanak --link kuldeep:elasticsearch -p 5601:5601 kibana:4.6``

Checking with docker ps command, all their container should be running

## Code Flow

1. Download the code and import it to Eclipse or any Id

2. Run the project and make sure Java Container is able to connect Elastic Search

3. Call the SaveContact URL (http://localhost:8080/user/savecontact) to create a record

>POST /user/savecontact HTTP/1.1
>Host: localhost:8080
>Content-Type: application/json
>Cache-Control: no-cache
>Postman-Token: 1d8e66f0-ea57-5ea5-4b6a-d9be1c751812
>
>{
>"id":"4",
>"contactId":"104", 
>"name": "hello4", 
>"email":"hello4@123.com",
>"company":"xcompany",
>"contactType":"3"
>} 

4. Access the Kibana URL http://192.168.99.100:5601/app/kibana and go to Settings -> Indices

![alt text](https://github.com/kuldeepsingh99/springboot-elasticsearch/blob/master/images/1.PNG)

5. Next Step is to create Index, type contacts in the textbox and uncheck the "Index contains time based events" 

![alt text](https://github.com/kuldeepsingh99/springboot-elasticsearch/blob/master/images/2.PNG)

6. Once Index is created we can check all the fields mentioned in bean has been created

![alt text](https://github.com/kuldeepsingh99/springboot-elasticsearch/blob/master/images/3.PNG)

7. Finally we can go to discover tab to check the data

![alt text](https://github.com/kuldeepsingh99/springboot-elasticsearch/blob/master/images/4.PNG)

## Summary

We can do all the CRUD Operation here.














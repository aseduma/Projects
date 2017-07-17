# Projects
Spring MVC, Jasper(Dev Pending) , Hibernate, JPA, MySQL and Thymeleaf 

#
install maven & jdk 8

#
IntelliJ

#
Click Run->Edit Configuration->+->Maven->
Command line -> spring-boot:run

#
create database project;
//optional
create database efas;
create database pmt;

#
Run the project
Hibernate will create tables for you
INSERT INTO `project`.`role` (`role`, `description`) VALUES ('ADMIN', 'Administrator');
INSERT INTO `project`.`role` (`role`, `description`) VALUES ('USER', 'User');

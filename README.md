Welcome to Chef's Directory. To run the application you will need the following:
1. PostgreSQL database installed on your system
2. Eclipse/IntelliJ IDE

Setting up Postgres
- Create a database "chefs"
- Create a schema "chefs1" in "chefs"
- Create tables "ChefsInfo" and "Dish"

To set up postgres, on the psql command line execute the following commands:
- CREATE DATABASE chefs WITH OWNER = postgres ENCODING = 'UTF8' CONNECTION LIMIT = -1;
- \c chefs
- CREATE SCHEMA chefs1  AUTHORIZATION postgres;
- [optional] \dn to see all schemas
- CREATE TABLE chefs1."ChefsInfo"
(
    id integer NOT NULL,
    cname character varying(60)[] NOT NULL,
    address character varying(60)[] NOT NULL,
    phone character varying(10)[] NOT NULL,
    PRIMARY KEY (id)
);
- ALTER TABLE chefs1."ChefsInfo"
    OWNER to postgres;
- CREATE TABLE chefs1."Dish"
(
    id integer NOT NULL,
    dname character varying(60)[] NOT NULL,
    ddetail character varying(60)[] NOT NULL,
    cid integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT chef_id FOREIGN KEY (cid)
        REFERENCES chefs1."ChefsInfo" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);
- ALTER TABLE chefs1."Dish"
    OWNER to postgres;

For Eclipse:
- File > Import > Existing Gradle Project > Select Project  Directory
Once it opens the project
Compile and run
Open localhost:8080 to view your application

For IntelliJ:
- File > Open > Select Project Directory
Once it opens, it will automatically build
After it compiles, just run the app
Open localhost:8080 to view your application

- Open the Application
- Add a few chefs and then a few dishes


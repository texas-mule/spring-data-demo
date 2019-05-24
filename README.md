# Hibernate
The Hibernate framework is a ORM (Object-Relational Mapping) implementation which is built around JDBC.

ORM refers to the long-standing problem of setting up a relationship between a program's objects and rows in a SQL table.

```
class Customer {
    int id;
    String name;
    List<Account>;
}
```
```sql
Create Table Customer(
    id integer primary key,
    name varchar2(50),
    account_id foreign key references Account(id)
    --The above is an issue for mapping
);
```

Map our Java objects to database entities through Hibernate, built on top of JDBC, which will abstract for us all the persistence and transactions that we would normally do ourselves. Hibernate can use interfaces to abstract several different database connections, but can also generate SQL.

## Packages
- org.hibernate
- javax.persistence
    - JPA (Java Persistence API)
    - Generic annotations for ORMs

## Exceptions
- HibernateException
    - RuntimeException which wraps SQLException

## Dependencies
- hibernate-core
- hibernate-entityManager

## JDBC Interfaces vs Hibernate Interfaces
### JDBC
- DriverManager
- Connection
- Statement
- PreparedStatement
- CallableStatement
- ResultSet

### Hibernate
- **Configuration** creates session factories through a specified configuration file or class
- **SessionFactory** is a singleton which generates session objects using a factory design pattern.
    - >SessionFactory sf = new Configuration().configure("file").buildSessionFactory();
- **Session** represents the database connection
    - >Session s = sf.openSession();
    - >s.close();
- **Query** is used to write complex CRUD operations using HQL (Hibernate Query Language)
- **Criteria** is for programmatically writing Select queries
    ```java
    List<Animal> a = session.createCriteria(Animal.class)
        .addOrder(Order.asc("age"))
        .add(Restriction.between("age", 3, 7))
        .list();
    ```
- **Transaction** is an interface for managing ACID-complient transactions
    > Transaction tx = session.beginTransation();
    > //some inserts here
    > tx.commit();

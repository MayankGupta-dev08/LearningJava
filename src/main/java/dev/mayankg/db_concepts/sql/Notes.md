# SQL Notes

- SQL: Structured Query Language (MsSQL, Oracle, PostgresSQL, DB2, MySQL) --> aka RDBMS (Relational)
- NoSql: Non-Structured Query Language (MongoDB, Cassandra, Neo4J) --> aka DDBMS (Distributed)

---

## SQL vs NoSQL

### Introduction
SQL (Structured Query Language) and NoSQL (Not Only SQL) are two types of database management systems (DBMS) used for storing and retrieving data.

### 1. Data Model
- **SQL:** Relational databases follow a tabular data model where data is structured into rows and columns. Tables have predefined schemas.
- **NoSQL:** NoSQL databases offer a flexible schema design, allowing for various data models like document (MongoDB), key-value (Redis, DynamoDB), graph (Neo4J), wide-column stores (Cassandra), realtime (Firebase), and time-series (TimeScale).

### 2. Scalability
- **SQL:** Traditionally, scaling SQL databases vertically (adding more resources to a single server) can be costly and has limitations.
- **NoSQL:** Designed for horizontal scalability (pumping more servers), allowing easy distribution of data across multiple servers, thus handling large volumes of data efficiently.

### 3. ACID vs BASE
- **SQL:** Emphasizes ACID (Atomicity, Consistency, Isolation, Durability) properties, ensuring data integrity and reliability.
- **NoSQL:** Focuses on BASE (Basically Available, Soft state, Eventually consistent) principles, prioritizing availability and partition tolerance over strict consistency.

### 4. Query Language
- **SQL:** Uses a standardized query language (SQL) for defining and manipulating data.
- **NoSQL:** Each NoSQL database may have its query language tailored to its data model, though some support SQL-like languages.

### 5. Use Cases
- **SQL:** Best suited for applications requiring complex queries, transactions, and strict consistency, such as banking systems, ERP, and traditional RDBMS applications.
- **NoSQL:** Ideal for handling large volumes of unstructured or semi-structured data, real-time analytics, and applications demanding high scalability and availability, like social media platforms, IoT, and content management systems.

### 6. Schema Flexibility
- **SQL:** Requires a predefined schema, which enforces data consistency and structure but can be restrictive for evolving data models.
- **NoSQL:** Offers schema flexibility, allowing changes to the data structure without downtime or migrations, accommodating agile development and dynamic data requirements.

### 7. Performance
- **SQL:** Typically provides high-performance query processing for structured data, especially with well-indexed tables and optimized queries.
- **NoSQL:** Offers excellent performance for read and write operations on large-scale distributed systems, especially with simple queries and high data volumes.

### Conclusion

Choosing between SQL and NoSQL depends on factors like data structure, scalability requirements, consistency needs, and the nature of the application. Both have strengths and weaknesses suited to different use cases and can even be used together in a hybrid approach for optimal performance and flexibility.

- When to choose SQL:
  - ACID Compliance is mandatory (Complex queries, heavy transaction work)
  - Data is structured and unchanging schema
  - Banking, ERP and traditional RDBMS apps
- When to choose NoSQL:
  - No structure of data, schema may change over period of time
  - High Volume of data is generated with frequent R/W operations (rapid development)
  - Most of the cloud computing and storage.
  - Social media platforms, IoT, and content management systems.
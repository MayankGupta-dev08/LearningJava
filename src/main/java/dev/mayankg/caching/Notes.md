# Caching in System Design

## What is Cache/Caching?
Caching is a technique used to temporarily store copies of data or computational results in a faster storage layer (usually in-memory) to reduce the time it takes to access that data in the future. It works based on the **locality of reference** principle, which suggests that recently requested data is likely to be requested again.

- **Analogy**: Cache is like short-term memory, storing frequently accessed or recent items, offering quicker access compared to querying the original source (like databases or disk).

## Where Can Cache Be Added?
Caching can be applied at various levels in a system, including:

- **Hardware level**: CPU caches data from main memory for faster processing.
- **Operating System level**: OS caches file system operations.
- **Web browsers**: Caching web resources like HTML, CSS, JS files.
- **Web application layer**: Caching API responses, database query results, etc.

Caches are typically placed nearest to the **front-end** or the user interaction layer to improve response times and reduce backend load.

## Types of Cache

### 1. **Application Server Cache**
This type of cache is placed on the request layer of an application, enabling local storage of response data on each node (e.g., a web server). The node will quickly return cached data if available. If the data is not cached, it queries the database or another slow source.

- **Challenge**: When multiple nodes are behind a load balancer, the same request can be routed to different nodes, increasing cache misses.
- **Solution**: Use a **Global Cache** or a **Distributed Cache**.

### 2. **Distributed Cache**
In a distributed cache, the cached data is partitioned among different nodes. Each node owns part of the cache, and a **consistent hashing function** is used to determine which node contains a particular piece of data. This approach improves scalability—adding more nodes increases the cache capacity.

### 3. **Global Cache**
A global cache is shared across all nodes, meaning that any node can query the same cache space, similar to how it would query its local cache.

There are two types of global caches:
- **Cache Responsible for Data Retrieval**: If data is missing in the cache, the cache itself fetches the missing data from the backend.
- **Node Responsible for Data Retrieval**: If data is missing, the request node fetches the missing data from the backend. This approach works well when cache hit rates are low.

### 4. **Content Delivery Network (CDN)**
A **CDN** is used for caching and serving large amounts of static content (e.g., images, videos, CSS). The first request fetches the data from the backend, which is then cached on the CDN for subsequent requests, reducing load on the server.

- For smaller systems, static media can be served from a separate subdomain using lightweight servers like **Nginx**.

## Cache Invalidation
Cache invalidation is crucial to ensure that the cache remains up-to-date and consistent with the underlying data source (e.g., a database). When data is modified, it needs to be invalidated in the cache.

### 1. **Write-Through Cache**
- **Mechanism**: Data is written to both the cache and the database simultaneously.
- **Benefits**: Ensures data consistency between the cache and the database. It minimizes data loss risk, even in case of system crashes.
- **Drawback**: Increased write latency due to the dual write operations.

### 2. **Write-Around Cache**
- **Mechanism**: Data is written directly to the database, bypassing the cache.
- **Benefits**: Reduces cache write load, lowering the risk of flooding the cache with write operations.
- **Drawback**: A subsequent read request for the newly written data results in a cache miss, leading to higher latency.

### 3. **Write-Back Cache**
- **Mechanism**: Data is first written to the cache, and the database is updated after a set interval.
- **Benefits**: Offers low write latency and higher throughput.
- **Drawback**: The risk of data loss in case of system failure before the cache data is written to permanent storage.

## Cache Eviction Policies
When the cache reaches its storage limit, an **eviction policy** determines which data should be removed to make room for new entries. Common eviction policies include:

### 1. **First-In, First-Out (FIFO)**
- Evicts the oldest cached entry, i.e., the first one added.

### 2. **Last-In, First-Out (LIFO)**
- Evicts the most recently added cached entry.

### 3. **Least Recently Used (LRU)**
- Evicts the data that hasn't been accessed for the longest time.
- **Implementation**: Uses a **doubly linked list** and a **hash map** to store references to the nodes in the list.

### 4. **Most Recently Used (MRU)**
- Evicts the data that was most recently accessed.

### 5. **Least Frequently Used (LFU)**
- Evicts the data that has been accessed the least frequently over time.

### 6. **Random Replacement**
- Evicts a randomly selected cache entry.

## Summary
Caching improves performance by storing frequently requested data closer to the user, minimizing the need to access slower back-end systems. There are various caching strategies and eviction policies that help manage cached data efficiently, depending on the system's needs and architecture. Proper cache invalidation and eviction are crucial for maintaining data consistency and optimizing resource use.
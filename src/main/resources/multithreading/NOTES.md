# MULTITHREADING

### Multitasking
- It Allows several activities to occur simultaneously on the computer.
- It is of two types:
  1. Process based multitasking (Multitasking) [Allows process/programs to run concurrently on the computer ]  
  2. Thread based multitasking (Multithreading) [Allows parts of the same program to run concurrently on the computer]

### THREADS VS PROCESSES
1. Two threads share the same address space.
2. Context switching b/w the threads is usually less expensive than between processes.
3. The cost of communication b/w threads is relatively low.

### Why Multithreading??
- To utilize the idle CPU time by running some other thread when one thread is waiting (for some user input or performing some output operation ie. not using the CPU).

### WHAT IS A THREAD?
- A thread is an independent sequential path of execution within a program.
- Many threads can run concurrently within a program.
- At runtime threads in a program exist in a common memory space and can therefore share both data and code (i.e., they are lightweight as compared to the program).

#### Concepts in multithreading?
1. Creating threads and providing the code that gets executed by a thread.
2.  Accessing common data and code through synchronization.
3. Transitioning between thread states.

#### The Main Thread:
- When a standalone application is run, a user thread is automatically created to execute the main() method of application. This thread is called the main thread.
- If no other user thread is spawned, the program terminates when the main() method finishes executing.
- All other threads, known as the child threads, are spawned from the main thread.
- The main() method can finish, but the program will keep running until all user threads have completed.
- The runtime environment distinguishes between the user threads and the daemon threads.
- Calling the setDaemon(boolean) method in the thread class marks the status of the thread as either daemon or user, but this must be done before the thread is started.
- As ong as a user thread is alive, the JVM does not terminate.
- A daemon thread is at the mercy of the runtime system: it is stopped if there are no more user threads running (including the main thread), thus terminating the program.
- When we are using aThread.start(), then it doesn't mean that the thread will run at that instant, but it is at JVM's mercy, so as soon as it is free it will run that thread.

---
### **THREAD CREATION:**
- A Thread in java is represented by the object of the thread class.
    - Creating a thread in java can be achieved by two ways:
      1. Implementing the java.lang.Runnable interface (better option).
      2. Extending the java.lang.Thread class.

### Synchronization:
- Threads share the same memory space, i.e., they can share the resources (objects).
- However, there are critical situations where it is desirable to that only one thread at a time has access to shared resources.

#### Synchronization Methods:
- While a thread is inside a synchronized method of an object, all other threads that wish to execute this synchronized method or any other synchronized method of the object will have to wait.
- This restriction does not apply to the thread that already has the lock and is executing a synchronized method of the object.
- Such a method can invoke other synchronized methods of the object w/o being blocked.
- Any other thread can always call the non-synchronized methods of the object at any time.

#### Rules of Synchronization:
- A thread must acquire the object lock associated with a shared resource before it can enter the shared resource.
- The runtime system ensures that no other thread can enter a shared resource if another thread holds the object lock associated with it.
- If a thread cannot immediately acquire the object lock, it is blocked, i.e., it must wait for the lock to become available.
- When a thread exists a shared resource, the runtime system ensures that the object lock is also relinquished. If another thread is waiting for this object lock, it can try to acquire the lock inorder to gain the access to the shared resource.
- It should be made clear that the programs should not make any assumptions about the order in which threads are granted ownership of a lock.
 
#### Static Synchronization Methods:
- A thread acquiring the lock of a class to execute a static synchronized method has no effect on any thread acquiring the lock on any object of the class to execute a synchronized instance method.
- In other words, synchronization of static methods in a class is independent of the synchronization of instance methods on objects of the class.
- A subclass decides whether the new definition of an inherited synchronized method will remain synchronized in the subclass.
- ***Race Condition:*** It occurs when two or more threads simultaneously update the same value and as a consequence, leave the value in an undefined or inconsistent state.

#### Synchronized Blocks:
- Whereas execution of synchronized methods of an object is synchronized on the lock of the object, the synchronized block allows execution of arbitrary code to be synchronized on the lock of an arbitrary object.
- The general form of the synchronized statement is as follows:
  - synchronized (object ref expression) {<code_block>}
- The object ref expression must evaluate to a non-null reference value, otherwise a NullPointerException is thrown.
 
#### *SUMMARY:*
- A thread can hold a lock on an object:
  - By executing a synchronized instance method of the object. (this)
  - By executing the body of a synchronized block that synchronizes on the object. (this)
  - By executing a synchronized static method of a class or a block inside a static method (in this case, the object is the Class object representing the class in the JVM)

##### Thread Safety: It's the term used to describe the design of classes that ensures that the state of their object is always consistent, even when the objects are used concurrently by multiple threads. E.g., StringBuffer.
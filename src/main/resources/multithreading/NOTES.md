# MULTITHREADING

### Multitasking
- Allows several activities to occur simultaneously on the computer.
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
- At runtime threads in a program exist in a common memory space and can therefore share both data and code (ie. they are lightweight as compared to the program).

#### Concept?
- Creating threads and providing the code that gets executed by a thread.
- Accessing common data and code through synchronization.
- Transitioning between thread states.

#### The Main Thread:
- When a standalone application is run, a user thread is automatically created to execute the main() method of application. This thread is called the main thread.
- If no other user thread is spawned, the program terminates when the main() method finishes executing.
- All other threads, known as the child threads, are spawned from the main thread.
- The main() method can finish, but the program will keep running until all user threads have completed.
- The runtime environment distinguishes between the user threads and the daemon threads.
- Calling the setDaemon(boolean) method in the thread class marks the status of the thread as either daemon or user, but this must be done before the thread is started.
- As ong as a user thread is alive, the JVM does not terminate.
- A daemon thread is at the mercy of the runtime system: it is stopped if their are no more user threads running(including the main thread), thus terminating the program.
- When we are using aThread.start(), then it doesn't mean that the thread will run at that instant, but it is at jvm's mercy, so as soon as it is free it will run that thread.

### Synchronization:
- Threads share the same memory space, i.e., they can share the resources (objects).
- However, there are critical situations where it is desirable to that only one thread at a time has access to shared resources.
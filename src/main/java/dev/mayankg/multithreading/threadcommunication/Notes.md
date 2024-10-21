# Multithreading

## Thread Communication

- **Thread Communication** is a mechanism where two or more threads communicate with each other to perform a task.
- Without proper communication mechanism, threads might end up in inefficient busy-waiting state, leading to wastage of CPU resources and potential deadlock.
- In Java, we can achieve thread communication by using `wait()`, `notify()` and `notifyAll()` methods of `Object` class.
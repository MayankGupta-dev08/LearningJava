package dev.mayankg.multithreading.basic.example06.deadlock;


/**
 * <ul>
 *     <li> Deadlock is a situation where two or more threads are blocked forever, waiting for each other. </li>
 *     <li> Deadlock occurs when multiple threads need the same locks but obtain them in different order. </li>
 *     <li> Deadlock can be avoided by acquiring locks in a fixed order. </li>
 * </ul>
 */
class DeadLockExample {
    public static void main(String[] args) {
        var pen = new Pen();    // shared object among different threads
        var paper = new Paper();    // shared object among different threads

        var t1 = new Thread(new Task1(pen, paper), "Thread-1");
        var t2 = new Thread(new Task2(pen, paper), "Thread-2");

        t1.start();
        t2.start();
    }
}

class Task1 implements Runnable {
    Pen pen;
    Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);    // acquires lock for pen and wants to acquire lock for paper
    }
}

class Task2 implements Runnable {
    Pen pen;
    Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) {    // acquires lock for pen then acquire lock for paper, fixes the deadlock
            paper.writeWithPaperAndPen(pen);    // acquires lock for paper and wants to acquire lock for pen
        }
    }
}

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " to write on paper " + paper);
        paper.finishWriting();  // This will cause a deadlock
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " has finished writing with " + this + " pen.");
    }
}


class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " to write with pen " + pen);
        pen.finishWriting();    // This will cause a deadlock
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " has finished writing on " + this + " paper.");
    }
}

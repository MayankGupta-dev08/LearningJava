package dev.mayankg.multithreading.basic.example06.deadlock;

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
        pen.writeWithPenAndPaper(paper);
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
        paper.writeWithPaperAndPen(pen);
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

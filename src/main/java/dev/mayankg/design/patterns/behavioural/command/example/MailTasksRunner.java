package dev.mayankg.design.patterns.behavioural.command.example;

import java.util.LinkedList;
import java.util.List;

/**
 * ~~~ [POC code DON'T USE in PROD] ~~~ <br>
 * This is the invoker actually used in executing commands. <br>
 * It starts a worker thread which is in charge of executing commands.
 */
class MailTasksRunner implements Runnable {
    private static final MailTasksRunner RUNNER = new MailTasksRunner();
    private Thread runner;
    private List<Command> pendingCommands;
    private volatile boolean stop;

    private MailTasksRunner() {
        pendingCommands = new LinkedList<>();
        runner = new Thread(this);
        runner.start();
    }

    public static final MailTasksRunner getInstance() {
        return RUNNER;
    }

    /**
     * Run method takes pending commands and executes them.
     */
    @Override
    public void run() {
        while (true) {
            Command cmd = null;
            synchronized (pendingCommands) {
                if (pendingCommands.isEmpty()) try {
                    pendingCommands.wait();
                } catch (InterruptedException e) {
                    System.out.println("Runner interrupted");
                    if (stop) {
                        System.out.println("Runner stopping");
                        return;
                    }
                }
                cmd = pendingCommands.isEmpty() ? null : pendingCommands.remove(0);
            }
            if (cmd == null)
                return;
            cmd.execute();
        }
    }

    /**
     * Calling addCommandToQueue method with a command will schedule that command for later execution.
     */
    public void addCommandToQueue(Command cmd) {
        synchronized (pendingCommands) {
            pendingCommands.add(cmd);
            pendingCommands.notifyAll();
        }
    }

    public void shutdown() {
        this.stop = true;
        this.runner.interrupt();
    }
}
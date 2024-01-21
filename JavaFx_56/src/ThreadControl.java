import javafx.scene.control.TextArea;

public class ThreadControl extends Thread {
    private String message;
    private int delay = 1000;
    private volatile boolean stopped = false;
    private volatile boolean pause = false;
    private final Object pauseLock = new Object();
    private TextArea messageFromThread;

    public ThreadControl(String message, int delay, TextArea messageFromThread) {
        this.message = message;
        this.delay = delay * 1000;
        this.messageFromThread = messageFromThread;
    };

    @Override
    public void run() {
        while (!stopped) {
            synchronized (pauseLock) {
                if (stopped) {
                    break;
                }

                if (pause) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        break;
                    }

                    if (stopped) {
                        break;
                    }
                }
            }
            try {
                this.sleep(delay);
                messageFromThread.appendText(message + "\n");
            } catch (InterruptedException ex) {
                break;
            }
        }
        this.interrupt();
    }

    public void pause() {
        pause = true;
    }

    public void stopThread() {
        stopped = true;
        resumeD();
    }

    public String getMessage() {
        return message;
    }

    public String getDelay() {
        return Integer.toString(delay / 1000);
    }

    public void resumeD() {
        synchronized (pauseLock) {
            pause = false;
            pauseLock.notifyAll();
        }
    }

}

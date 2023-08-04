import javax.management.RuntimeErrorException;

public class ThreadCreatorTwo implements Runnable {

    public void run() {
        try {
            System.out.println(SynchronizedSingelton.getSynchronizedInstance().hashCode());
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
    }
}
import javax.management.RuntimeErrorException;

public class ThreadCreator extends Thread {
    public void run() {
        try {
            System.out.println(NonSynchronizedSingelton.getNonSynchronizedInstance().hashCode());
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

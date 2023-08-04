
public class NonSynchronizedSingelton {
    private static NonSynchronizedSingelton NonSynchronizedInstance;

    private NonSynchronizedSingelton() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Occurred");
        }
    }

    public static NonSynchronizedSingelton getNonSynchronizedInstance() throws InterruptedException {
        if (NonSynchronizedInstance == null) {
            NonSynchronizedInstance = new NonSynchronizedSingelton();
        }
        return NonSynchronizedInstance;
    }
}

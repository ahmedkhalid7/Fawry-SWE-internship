
public class SynchronizedSingelton {
    private static SynchronizedSingelton SynchronizedInstance;

    private SynchronizedSingelton() {

    }

    public static SynchronizedSingelton getSynchronizedInstance() {
        if (SynchronizedInstance == null) {
            synchronized (SynchronizedSingelton.class) {
                if (SynchronizedInstance == null) {
                    SynchronizedInstance = new SynchronizedSingelton();
                }
            }
        }
        return SynchronizedInstance;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ThreadCreator thread1 = new ThreadCreator();
        thread1.start();

        ThreadCreator thread2 = new ThreadCreator();
        thread2.start();

        Thread t1 = new Thread(new ThreadCreatorTwo());
        t1.start();
    }
}

public class ThreadIncrement {
    public static void main(String[] args) throws Exception {

        Counter c = new Counter();

        Thread t1 = new Thread(
                () -> {
                    for (int i = 1; i <= 3000; i++) {
                        c.increment();
                    }
                });

        Thread t2 = new Thread(
                () -> {
                    for (int i = 1; i <= 3000; i++) {
                        c.increment();
                    }
                });

        // Calling start() method with t1 and t2
        t1.start();
        t2.start();

        // Calling join method with t1 and t2
        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}

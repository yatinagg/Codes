public class Threads implements Runnable {
    public static void main(String[] args) {
        Threads obj = new Threads();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("outside thread");
    }
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("inside thread");
    }
}
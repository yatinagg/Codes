public class Counter {

    int count=0;

    // for thread safety, we can use Vector, Hashtable, String, final, local variables

    // synchronized for thread-safety
    public synchronized void increment() {
        count++;
    }
}
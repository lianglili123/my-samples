package my.sample.unsafethread;

public class ThreadSafeCounter {

    private  static int num;

    public synchronized static int getNext() {
	return num++;
    }

}

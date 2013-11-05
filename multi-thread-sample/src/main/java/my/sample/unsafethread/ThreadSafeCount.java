package my.sample.unsafethread;

public class ThreadSafeCount implements Runnable {

    public void run() {
	String s = "***Safe***";
	for (int i = 0; i < 20; i++) {
	    s = s + ThreadSafeCounter.getNext() + ",";
	}
	System.out.println(s);

    }
}

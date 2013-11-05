package my.sample.unsafethread;

public class UnThreadSafeCount implements Runnable {

    public void run() {
	String s = "**NoSafe**";
	for (int i = 0; i < 20; i++) {
	    s = s + UnThreadSafeCounter.getNext() + ",";
	}
	System.out.println(s);

    }
}

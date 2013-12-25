package my.sample.unsafethread;

/**
 * Thread型がRunnableを実装する。
 * run()を実装し、Threadがstart()されると、Thread単位で
 * run()内の処理が実行される。
 * @author lll
 *
 */
public class ThreadSafeCount implements Runnable {

    public void run() {
	String s = "***Safe***";
	for (int i = 0; i < 20; i++) {
	    s = s + ThreadSafeCounter.getNext() + ",";
	}
	System.out.println(s);

    }
}

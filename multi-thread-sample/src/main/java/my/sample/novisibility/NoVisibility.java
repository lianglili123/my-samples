package my.sample.novisibility;
/**
 * 可視性：マルチスレッドで動作する場合、変数の最新ステータスが他のスレッドに見えるような性質
 * @author lll
 *
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
	public void run() {
	    // readyの値はいつまでも可視にならない可能性があるため、無限ループになることもある
	    while (!ready)
		// 現在実行中のスレッドを一時休止し、ほかの同じ優先度のスレッドに実行する機会を与える
		Thread.yield();
	    System.out.println(number);

	}
    }

    public static void main(String[] args) {
	new ReaderThread().start();
	number = 42;
	ready = true;
    }

}

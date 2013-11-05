package my.sample.unsafethread;

public class UnThreadSafeCounter {

    private static int num;

    public static int getNext() {
	return num++;
    }

}

package my.sample.unsafethread;

public class Run {

    public static void main(String[] args) {
	
	for(int i=0 ;i<10;i++){
		Thread u = new Thread(new UnThreadSafeCount()); 
		//start()が呼び出される時、run()の処理が実行される。
		u.start();
	}

	for(int i=0 ;i<10;i++){
		Thread s = new Thread(new ThreadSafeCount());
		s.start();
	}
    }

}

package my.sample.unsafethread;

public class Run {

    public static void main(String[] args) {
	
	for(int i=0 ;i<10;i++){
		Thread u = new Thread(new UnThreadSafeCount());    
		u.start();
	}

	for(int i=0 ;i<10;i++){
		Thread s = new Thread(new ThreadSafeCount());
		s.start();
	}
    }

}

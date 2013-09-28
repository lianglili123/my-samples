package my.sample.log4j.first;

import org.apache.log4j.Level;

public class Run {

	public static void main(String[] args){
	    
		FootPrint obj=new FootPrint(Level.TRACE);
		obj.walk();
		obj.run();
		obj.see();
		obj.stop();
		obj.research();
	}
}

package my.sample.log4j.sample;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;




public class FootPrint {
	static Logger logger=Logger.getLogger("smallLogger");
	public FootPrint(){
		ConsoleAppender appender= new ConsoleAppender(new PatternLayout("%m <----%d--%l %n"),ConsoleAppender.SYSTEM_OUT);
		appender.setName("Console");
		logger.setLevel(Level.DEBUG);
		logger.addAppender(appender);
	}

	public void step(){
		logger.debug("debug: one step.");
	}
	public void run(){
		logger.info("info: running.");
	}
	public void see(){
		logger.warn("warn: look out!");
	}
	public void trace(){
		logger.trace("trace: following somebody.");
	}
	public void stop(){
		logger.error("error: Oh, shit!");
	}

}

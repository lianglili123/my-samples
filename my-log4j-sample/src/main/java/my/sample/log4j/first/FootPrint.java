package my.sample.log4j.first;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class FootPrint {
    private static Logger logger = Logger.getLogger("smallLogger");

    /**
     * 1. Initialize a logger with an appender.<br>
     * The appender is set up with simplest layout format<br>
     * and its output target(to system out or err).<br>
     * 
     */
    public FootPrint() {
	init(Level.INFO);
    }

    public FootPrint(Level level) {

	init(level);
    }

    private void init(Level level) {
	ConsoleAppender appender = new ConsoleAppender(new PatternLayout(
		"%m <----%d--%l %n"), ConsoleAppender.SYSTEM_OUT);
	appender.setName("Console");
	logger.setLevel(level);
	logger.addAppender(appender);
    }

    public void walk() {
	logger.debug("debug: one step.");
    }

    public void run() {
	logger.info("info: running.");
    }

    public void see() {
	logger.warn("warn: look out!");
    }

    public void research() {
	logger.trace("trace: researching...");
    }

    public void stop() {
	logger.error("error: Oh, shit!");
    }

}

package my.sample.helloworld.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	Logger logger =Logger.getLogger(this.getClass());
	@Before("execution(* *Mapping(..))")
	private void beforeMapping(){
		logger.info("before mapping.");
	}
	
	@After("execution(* *Mapping(..))")
	private void afterMapping(){
		logger.info("after mapping.");
	}

}

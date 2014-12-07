package my.sample.helloworld;

import my.sample.helloworld.dao.WriterDao;
import my.sample.helloworld.entities.Writer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("spring/application-config.xml");
//		Writer writer=(Writer)context.getBean("writer");
		
//		writer.setName("Lili");
		
//		writer.write();

//		System.out.println("HelloWorld");
		
		WriterDao dao=(WriterDao)context.getBean("writerDao");
		
		System.out.println(dao.getWriterList().size());
		Writer writer=dao.getWriter(1);
		
		writer.write();
		
	}

}

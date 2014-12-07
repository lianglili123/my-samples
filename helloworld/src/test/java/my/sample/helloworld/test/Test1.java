package my.sample.helloworld.test;

import my.sample.helloworld.dao.WriterDao;
import my.sample.helloworld.entities.Writer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/test-application-config.xml"})
public class Test1 {
	@Autowired
	private WriterDao dao;
	

	@Test
	public void testcase01(){

		System.out.println(dao.getWriterList().size());
		Writer writer=dao.getWriter(1);
		
		writer.write();
	}
}

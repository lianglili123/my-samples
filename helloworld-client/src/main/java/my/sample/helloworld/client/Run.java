package my.sample.helloworld.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.sample.helloworld.client.gen.GetWriterResponse;

public class Run {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		WebClient client=(WebClient) context.getBean("webServiceClient");
		GetWriterResponse response=client.getId("2");
		System.out.println(response.getWriter().getEmail());

	}


}

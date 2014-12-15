package my.sample.helloworld.client;

import my.sample.helloworld.client.gen.GetWriterRequest;
import my.sample.helloworld.client.gen.GetWriterResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WebClient extends WebServiceGatewaySupport {
	
	@Autowired
	WebServiceTemplate webServiceTemplate;
	
	
	public GetWriterResponse getId(String id) {
		GetWriterResponse response = new GetWriterResponse();
		GetWriterRequest request = new GetWriterRequest();
		request.setId(id);
		response = (GetWriterResponse) webServiceTemplate.marshalSendAndReceive(
				request,
				new SoapActionCallback(
						"http://localhost:8080/helloworld/ws/"));
		return response;
	}
}
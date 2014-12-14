package my.sample.helloworld.endpoint;

import my.sample.helloworld.dao.WriterDao;
import my.sample.helloworld.entities.Writer;
import my.sample.helloworld.writer.GetWriterRequest;
import my.sample.helloworld.writer.GetWriterResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WriterEndpoint {

	private static final String NAMESPACE = "http://helloworld.sample.my/writer/";
	@Autowired
	private WriterDao dao;
	@PayloadRoot(namespace = NAMESPACE, localPart = "getWriterRequest")
	@ResponsePayload
	public GetWriterResponse getWriter(@RequestPayload GetWriterRequest request) {
		Writer writer = dao.getWriter(Integer.parseInt(request.getId()));
		GetWriterResponse response = new GetWriterResponse();
		response.setWriter(writer.getWsWriter(writer));
		return response;
	}

}

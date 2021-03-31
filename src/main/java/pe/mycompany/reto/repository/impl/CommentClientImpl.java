package pe.mycompany.reto.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.mycompany.reto.model.Comment;
import pe.mycompany.reto.repository.CommentClient;

@Component
public class CommentClientImpl implements CommentClient{

	@Value("${service.url}")
	private String url;
	
	@Value("${service.endpoint.comments}")
	private String endpointComments;

	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public List<Comment> obtenerListComments() {
		ResponseEntity<Comment[]> response = restTemplate.getForEntity(url+endpointComments, Comment[].class);		

		if(response.getStatusCode()==HttpStatus.OK) 
			return  (List<Comment>) Arrays.asList(response.getBody());			
		throw new RuntimeException("El servidor no respondió OK");
		
	}

}

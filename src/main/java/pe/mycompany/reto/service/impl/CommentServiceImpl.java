package pe.mycompany.reto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.mycompany.reto.model.Comment;
import pe.mycompany.reto.model.DataResponseDto;
import pe.mycompany.reto.repository.CommentClient;
import pe.mycompany.reto.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentClient commentClient;
	
	public CommentServiceImpl(CommentClient commentClient) {
		this.commentClient = commentClient;
	}
	
	@Override
	public DataResponseDto obtenerListComments() {
		List<Comment> listComment = commentClient.obtenerListComments();
		
		DataResponseDto result = new DataResponseDto();
		List<String> data = new ArrayList<>();
		if(listComment!=null) {
			data= listComment.stream()
				             .map(x -> x.getPostId() + "|" + x.getId() + "|" + x.getEmail())
					         .collect(Collectors.toList());
		}
		result.setData(data);

		return result;
	}

	

}

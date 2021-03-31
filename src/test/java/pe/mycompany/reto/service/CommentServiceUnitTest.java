package pe.mycompany.reto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.mycompany.reto.model.Comment;
import pe.mycompany.reto.model.DataResponseDto;
import pe.mycompany.reto.repository.CommentClient;
import pe.mycompany.reto.service.impl.CommentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CommentServiceUnitTest {
	
	@Mock
	public CommentClient commentClient;

	@Test
	public void Test01() {
	
		when(commentClient.obtenerListComments()).thenReturn(null);
		
		CommentService commentService = new CommentServiceImpl(commentClient);

		DataResponseDto result = commentService.obtenerListComments();
		
		DataResponseDto expected = new DataResponseDto();		
		List<String> data = new ArrayList<>();		
		expected.setData(data);
		
		assertThat(expected.equals(result));
	}
	
	@Test
	public void Test02() {
		List<Comment> listComment = new ArrayList<>();
		
		when(commentClient.obtenerListComments()).thenReturn(listComment);
		
		CommentService commentService = new CommentServiceImpl(commentClient);

		DataResponseDto result = commentService.obtenerListComments();
		
		DataResponseDto expected = new DataResponseDto();		
		List<String> data = new ArrayList<>();		
		expected.setData(data);
		
		assertThat(expected.equals(result));
	}

	@Test
	public void Test03() {
		List<Comment> listComment = new ArrayList<>();
		listComment.add(new Comment(1,1,"id labore ex et ","Eliseo@gardner.biz","laudantium enim quasi "));
		listComment.add(new Comment(1,2,"quo vero reicien","Jayne_Kuhic@sydney.com","laudantium enim quasi est quid"));
		
		when(commentClient.obtenerListComments()).thenReturn(listComment);
		
		CommentService commentService = new CommentServiceImpl(commentClient);

		DataResponseDto result = commentService.obtenerListComments();
		
		DataResponseDto expected = new DataResponseDto();		
		List<String> data = Arrays.asList("1|1|Eliseo@gardner.biz","1|2|Jayne_Kuhic@sydney.com");		
		expected.setData(data);
		
		assertThat(expected.equals(result));
	}
}

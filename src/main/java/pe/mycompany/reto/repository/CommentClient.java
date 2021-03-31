package pe.mycompany.reto.repository;

import java.util.List;

import pe.mycompany.reto.model.Comment;

public interface CommentClient {
	
	public List<Comment> obtenerListComments();
}

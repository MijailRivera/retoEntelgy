package pe.mycompany.reto.model;

import java.util.ArrayList;
import java.util.List;

public class CommentList {
	private List<Comment> comments;

	public CommentList() {
		comments = new ArrayList<>();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}

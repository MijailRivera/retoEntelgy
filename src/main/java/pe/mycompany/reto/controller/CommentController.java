package pe.mycompany.reto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.mycompany.reto.model.DataResponseDto;
import pe.mycompany.reto.service.CommentService;

@RestController
@RequestMapping("/reto")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@PostMapping
	public DataResponseDto inicio() {
		return commentService.obtenerListComments();
	}
}

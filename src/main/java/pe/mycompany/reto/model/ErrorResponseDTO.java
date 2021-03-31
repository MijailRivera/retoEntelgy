package pe.mycompany.reto.model;

public class ErrorResponseDTO {
	private String message;

	public ErrorResponseDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

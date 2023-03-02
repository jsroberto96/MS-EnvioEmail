package com.microService.email.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
	
	public EmailDTO() {
		
	}
	
	@NotBlank
	private String ownerRef;
	
	@NotBlank
	private String emailFrom;
	
	@NotBlank
	@Email
	private String emailTo;
	
	@NotBlank
	@Email
	private String subject;
	
	@NotBlank
	private String text;
	

}

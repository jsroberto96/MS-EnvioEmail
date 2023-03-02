package com.microService.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.microService.email.dto.EmailDTO;
import com.microService.email.model.EmailModel;
import com.microService.email.services.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired
	EmailService emailService;
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void Listen(@Payload EmailDTO emaildto) {
		
		EmailModel emailModel = new EmailModel();
		
		BeanUtils.copyProperties(emaildto, emailModel);
		
		emailService.sendEmail(emailModel);
		
		System.out.println("EmailStatus " + emailModel.getStatusEmail().toString());
		
		
	}
	
	

}

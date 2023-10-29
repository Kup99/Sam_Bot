package com.sambot.producer;

import com.sambot.constant.ApplicationConstant;
import com.sambot.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@PostMapping ("/message")
	public String sendMessage(@RequestBody Student message) {

		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json message sent succuessfully";
	}
	@PostMapping ("/message/fufel")
	public String sendMessageToFufelTopic(@RequestBody Student message) {

		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_FUFEL_NAME, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json message sent succuessfully";
	}

//	@GetMapping ("/message")
//	public String getMessage() {
//		try {
//			kafkaTemplate.
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "json message sent succuessfully";
//	}
}

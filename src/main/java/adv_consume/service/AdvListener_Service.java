package adv_consume.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import adv_consume.model.AdvMaster_DTO;

@Service("advListenerServ")
public class AdvListener_Service	
{
	private static final Logger logger = LoggerFactory.getLogger(AdvListener_Service.class);
	
	@KafkaListener(topics = "${topic.name.adproducer}", groupId = "group_id")
	public void consume(ConsumerRecord<String, AdvMaster_DTO> payload) 
	{
		logger.info("Ad No :"+payload.value().getAd());
}
}
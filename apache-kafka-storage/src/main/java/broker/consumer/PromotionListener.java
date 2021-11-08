package broker.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pravin.apachekafkastorage.broker.message.DiscountMessage;
import com.pravin.apachekafkastorage.broker.message.PromotionMessage;

@Service
@KafkaListener(topics = "t_commodity.promotion")
public class PromotionListener {

	@KafkaHandler
	public void listenPromotion(PromotionMessage message) {
		System.out.println("listenPromotion "+message);
	}

	@KafkaHandler
	public void listtenDiscount(DiscountMessage message) {
		System.out.println("listtenDiscount "+message);
	}
}

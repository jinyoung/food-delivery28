package food.delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.delivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_StoreDeliveryInfo(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener StoreDeliveryInfo : " + cooked + "\n\n");


        

        // Sample Logic //
        Delivery.storeDeliveryInfo(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_StoreDeliveryInfo(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener StoreDeliveryInfo : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Delivery.storeDeliveryInfo(event);
        

        

    }

}



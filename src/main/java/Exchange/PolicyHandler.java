package Exchange;

import Exchange.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverExchangeCanceled_CancelExchange(@Payload ExchangeCanceled exchangeCanceled){

        if(exchangeCanceled.isMe()){
            System.out.println("##### listener CancelExchange : " + exchangeCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverExchangeApporved_ConfirmExchange(@Payload ExchangeApporved exchangeApporved){

        if(exchangeApporved.isMe()){
            System.out.println("##### listener ConfirmExchange : " + exchangeApporved.toJson());
        }
    }

}

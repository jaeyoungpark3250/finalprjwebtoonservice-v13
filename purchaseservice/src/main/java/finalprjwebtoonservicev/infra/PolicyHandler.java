package finalprjwebtoonservicev.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import finalprjwebtoonservicev.config.kafka.KafkaProcessor;
import finalprjwebtoonservicev.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PurchaseRepository purchaseRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CheckCorrected'"
    )
    public void wheneverCheckCorrected_ApprovePurchaseCancel(
        @Payload CheckCorrected checkCorrected
    ) {
        CheckCorrected event = checkCorrected;
        System.out.println(
            "\n\n##### listener ApprovePurchaseCancel : " +
            checkCorrected +
            "\n\n"
        );

        // Sample Logic //
        Purchase.approvePurchaseCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CheckRejected'"
    )
    public void wheneverCheckRejected_RejectedPurchaseCancel(
        @Payload CheckRejected checkRejected
    ) {
        CheckRejected event = checkRejected;
        System.out.println(
            "\n\n##### listener RejectedPurchaseCancel : " +
            checkRejected +
            "\n\n"
        );

        // Sample Logic //
        Purchase.rejectedPurchaseCancel(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

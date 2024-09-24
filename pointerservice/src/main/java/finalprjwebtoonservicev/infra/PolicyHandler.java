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
    PointerRepository pointerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymenteComplete'"
    )
    public void wheneverPaymenteComplete_PointIncrease(
        @Payload PaymenteComplete paymenteComplete
    ) {
        PaymenteComplete event = paymenteComplete;
        System.out.println(
            "\n\n##### listener PointIncrease : " + paymenteComplete + "\n\n"
        );

        // Sample Logic //
        Pointer.pointIncrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RefundComplete'"
    )
    public void wheneverRefundComplete_PointDecrease(
        @Payload RefundComplete refundComplete
    ) {
        RefundComplete event = refundComplete;
        System.out.println(
            "\n\n##### listener PointDecrease : " + refundComplete + "\n\n"
        );

        // Sample Logic //
        Pointer.pointDecrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CheckCorrected'"
    )
    public void wheneverCheckCorrected_PointDecrease(
        @Payload CheckCorrected checkCorrected
    ) {
        CheckCorrected event = checkCorrected;
        System.out.println(
            "\n\n##### listener PointDecrease : " + checkCorrected + "\n\n"
        );

        // Sample Logic //
        Pointer.pointDecrease(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

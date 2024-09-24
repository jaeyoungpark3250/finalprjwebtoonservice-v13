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
    WebtoonRepository webtoonRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OpenApproved'"
    )
    public void wheneverOpenApproved_OpenApprove(
        @Payload OpenApproved openApproved
    ) {
        OpenApproved event = openApproved;
        System.out.println(
            "\n\n##### listener OpenApprove : " + openApproved + "\n\n"
        );

        // Sample Logic //
        Webtoon.openApprove(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OpenRejected'"
    )
    public void wheneverOpenRejected_OpenReject(
        @Payload OpenRejected openRejected
    ) {
        OpenRejected event = openRejected;
        System.out.println(
            "\n\n##### listener OpenReject : " + openRejected + "\n\n"
        );

        // Sample Logic //
        Webtoon.openReject(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

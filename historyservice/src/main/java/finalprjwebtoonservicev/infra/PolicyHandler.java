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
    HistoryRepository historyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymenteFailed'"
    )
    public void wheneverPaymenteFailed_PaymentHistory(
        @Payload PaymenteFailed paymenteFailed
    ) {
        PaymenteFailed event = paymenteFailed;
        System.out.println(
            "\n\n##### listener PaymentHistory : " + paymenteFailed + "\n\n"
        );

        // Sample Logic //
        History.paymentHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DecreasedComplete'"
    )
    public void wheneverDecreasedComplete_PaymentHistory(
        @Payload DecreasedComplete decreasedComplete
    ) {
        DecreasedComplete event = decreasedComplete;
        System.out.println(
            "\n\n##### listener PaymentHistory : " + decreasedComplete + "\n\n"
        );

        // Sample Logic //
        History.paymentHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Increased'"
    )
    public void wheneverIncreased_PaymentHistory(@Payload Increased increased) {
        Increased event = increased;
        System.out.println(
            "\n\n##### listener PaymentHistory : " + increased + "\n\n"
        );

        // Sample Logic //
        History.paymentHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BuyFailed'"
    )
    public void wheneverBuyFailed_BuyHistory(@Payload BuyFailed buyFailed) {
        BuyFailed event = buyFailed;
        System.out.println(
            "\n\n##### listener BuyHistory : " + buyFailed + "\n\n"
        );

        // Sample Logic //
        History.buyHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PurchaseCancelComplete'"
    )
    public void wheneverPurchaseCancelComplete_BuyHistory(
        @Payload PurchaseCancelComplete purchaseCancelComplete
    ) {
        PurchaseCancelComplete event = purchaseCancelComplete;
        System.out.println(
            "\n\n##### listener BuyHistory : " + purchaseCancelComplete + "\n\n"
        );

        // Sample Logic //
        History.buyHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PurchaseCancelFailed'"
    )
    public void wheneverPurchaseCancelFailed_BuyHistory(
        @Payload PurchaseCancelFailed purchaseCancelFailed
    ) {
        PurchaseCancelFailed event = purchaseCancelFailed;
        System.out.println(
            "\n\n##### listener BuyHistory : " + purchaseCancelFailed + "\n\n"
        );

        // Sample Logic //
        History.buyHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CancelFailed'"
    )
    public void wheneverCancelFailed_BuyHistory(
        @Payload CancelFailed cancelFailed
    ) {
        CancelFailed event = cancelFailed;
        System.out.println(
            "\n\n##### listener BuyHistory : " + cancelFailed + "\n\n"
        );

        // Sample Logic //
        History.buyHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BuyComplete'"
    )
    public void wheneverBuyComplete_UserInfoCheck(
        @Payload BuyComplete buyComplete
    ) {
        BuyComplete event = buyComplete;
        System.out.println(
            "\n\n##### listener UserInfoCheck : " + buyComplete + "\n\n"
        );

        // Comments //
        //고객 포인트 현황. 구매하려는 웹툰 보유 현황 등 조회
        //

        // Sample Logic //
        History.userInfoCheck(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CancelComplete'"
    )
    public void wheneverCancelComplete_UserInfoCheck(
        @Payload CancelComplete cancelComplete
    ) {
        CancelComplete event = cancelComplete;
        System.out.println(
            "\n\n##### listener UserInfoCheck : " + cancelComplete + "\n\n"
        );

        // Comments //
        //고객 포인트 현황. 구매하려는 웹툰 보유 현황 등 조회
        //

        // Sample Logic //
        History.userInfoCheck(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Joind'"
    )
    public void wheneverJoind_UserCreate(@Payload Joind joind) {
        Joind event = joind;
        System.out.println("\n\n##### listener UserCreate : " + joind + "\n\n");

        // Sample Logic //
        History.userCreate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Withdrawed'"
    )
    public void wheneverWithdrawed_UserDelete(@Payload Withdrawed withdrawed) {
        Withdrawed event = withdrawed;
        System.out.println(
            "\n\n##### listener UserDelete : " + withdrawed + "\n\n"
        );

        // Sample Logic //
        History.userDelete(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OpenChecked'"
    )
    public void wheneverOpenChecked_WebtoonOpenCheck(
        @Payload OpenChecked openChecked
    ) {
        OpenChecked event = openChecked;
        System.out.println(
            "\n\n##### listener WebtoonOpenCheck : " + openChecked + "\n\n"
        );

        // Comments //
        //해당 웹툰 오픈 가능 여부 체크

        // Sample Logic //
        History.webtoonOpenCheck(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

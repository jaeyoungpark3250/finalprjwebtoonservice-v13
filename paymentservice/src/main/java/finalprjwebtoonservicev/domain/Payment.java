package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.PaymentserviceApplication;
import finalprjwebtoonservicev.domain.PaymenteComplete;
import finalprjwebtoonservicev.domain.PaymenteFailed;
import finalprjwebtoonservicev.domain.RefundComplete;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer point;

    private String userId;

    private Integer price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PaymenteComplete paymenteComplete = new PaymenteComplete(this);
        paymenteComplete.publishAfterCommit();

        PaymenteFailed paymenteFailed = new PaymenteFailed(this);
        paymenteFailed.publishAfterCommit();

        RefundComplete refundComplete = new RefundComplete(this);
        refundComplete.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentserviceApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public void payment() {
        //implement business logic here:

        PaymenteComplete paymenteComplete = new PaymenteComplete(this);
        paymenteComplete.publishAfterCommit();
    }

    public void refund() {
        //implement business logic here:

        RefundComplete refundComplete = new RefundComplete(this);
        refundComplete.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root

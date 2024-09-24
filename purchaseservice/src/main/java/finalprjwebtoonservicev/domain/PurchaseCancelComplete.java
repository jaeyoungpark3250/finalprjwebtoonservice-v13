package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PurchaseCancelComplete extends AbstractEvent {

    private Long id;
    private Integer myPoint;
    private String userId;
    private String webtoonId;
    private String status;

    public PurchaseCancelComplete(Purchase aggregate) {
        super(aggregate);
    }

    public PurchaseCancelComplete() {
        super();
    }
}
//>>> DDD / Domain Event

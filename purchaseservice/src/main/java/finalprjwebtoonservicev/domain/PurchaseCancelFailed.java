package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PurchaseCancelFailed extends AbstractEvent {

    private Long id;
    private Integer myPoint;
    private String userId;
    private String webtoonId;
    private String status;

    public PurchaseCancelFailed(Purchase aggregate) {
        super(aggregate);
    }

    public PurchaseCancelFailed() {
        super();
    }
}
//>>> DDD / Domain Event

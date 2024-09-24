package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CheckRejected extends AbstractEvent {

    private Long id;
    private Integer point;
    private String userId;
    private String webtoonId;
    private String status;
    private Integer price;
    private Integer myPoint;

    public CheckRejected(History aggregate) {
        super(aggregate);
    }

    public CheckRejected() {
        super();
    }
}
//>>> DDD / Domain Event

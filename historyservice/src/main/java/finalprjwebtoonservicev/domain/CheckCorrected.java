package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CheckCorrected extends AbstractEvent {

    private Long id;
    private Integer point;
    private String userId;
    private String webtoonId;
    private String status;
    private Integer price;
    private Integer myPoint;

    public CheckCorrected(History aggregate) {
        super(aggregate);
    }

    public CheckCorrected() {
        super();
    }
}
//>>> DDD / Domain Event

package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OpenApproved extends AbstractEvent {

    private Long id;
    private String userId;
    private String webtoonId;
    private String status;

    public OpenApproved(History aggregate) {
        super(aggregate);
    }

    public OpenApproved() {
        super();
    }
}
//>>> DDD / Domain Event

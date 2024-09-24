package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DecreasedComplete extends AbstractEvent {

    private Long id;
    private Integer point;

    public DecreasedComplete(Pointer aggregate) {
        super(aggregate);
    }

    public DecreasedComplete() {
        super();
    }
}
//>>> DDD / Domain Event

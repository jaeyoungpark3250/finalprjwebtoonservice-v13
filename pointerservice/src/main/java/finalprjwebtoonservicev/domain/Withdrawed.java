package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Withdrawed extends AbstractEvent {

    private Long id;
    private Integer point;

    public Withdrawed(Pointer aggregate) {
        super(aggregate);
    }

    public Withdrawed() {
        super();
    }
}
//>>> DDD / Domain Event

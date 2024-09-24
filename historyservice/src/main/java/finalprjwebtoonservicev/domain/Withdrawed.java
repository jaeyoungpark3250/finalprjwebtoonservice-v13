package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Withdrawed extends AbstractEvent {

    private Long id;
    private Integer point;
}

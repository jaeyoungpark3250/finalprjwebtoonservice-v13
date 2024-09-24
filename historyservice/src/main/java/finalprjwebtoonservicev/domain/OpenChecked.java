package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import finalprjwebtoonservicev.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OpenChecked extends AbstractEvent {

    private Long id;
    private String userId;
    private String webtoonId;
    private String status;
}

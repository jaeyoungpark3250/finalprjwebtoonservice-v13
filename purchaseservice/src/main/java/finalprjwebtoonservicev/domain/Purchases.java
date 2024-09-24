package finalprjwebtoonservicev.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Purchases_table")
@Data
public class Purchases {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private String webtoonId;
    private String point;
    private String status;
    private Integer myPoint;
}

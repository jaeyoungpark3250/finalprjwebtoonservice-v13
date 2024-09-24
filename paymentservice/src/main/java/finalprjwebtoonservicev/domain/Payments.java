package finalprjwebtoonservicev.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Payments_table")
@Data
public class Payments {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer price;
    private String userId;
    private String status;
    private String myPoint;
}

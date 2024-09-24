package finalprjwebtoonservicev.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Webtoons_table")
@Data
public class Webtoons {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private String webtoonId;
    private String title;
    private Integer point;
    private String episode;
    private String status;
}

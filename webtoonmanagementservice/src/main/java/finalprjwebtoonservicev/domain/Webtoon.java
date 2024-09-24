package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.WebtoonmanagementserviceApplication;
import finalprjwebtoonservicev.domain.OpenChecked;
import finalprjwebtoonservicev.domain.Updateed;
import finalprjwebtoonservicev.domain.Uploaded;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Webtoon_table")
@Data
//<<< DDD / Aggregate Root
public class Webtoon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String webtoonId;

    private String title;

    private String author;

    private Integer point;

    private String episode;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Uploaded uploaded = new Uploaded(this);
        uploaded.publishAfterCommit();

        Updateed updateed = new Updateed(this);
        updateed.publishAfterCommit();

        OpenChecked openChecked = new OpenChecked(this);
        openChecked.publishAfterCommit();
    }

    public static WebtoonRepository repository() {
        WebtoonRepository webtoonRepository = WebtoonmanagementserviceApplication.applicationContext.getBean(
            WebtoonRepository.class
        );
        return webtoonRepository;
    }

    public void webtoonUpload() {
        //implement business logic here:

        Uploaded uploaded = new Uploaded(this);
        uploaded.publishAfterCommit();
    }

    public void webtoonUpdate() {
        //implement business logic here:

        Updateed updateed = new Updateed(this);
        updateed.publishAfterCommit();
    }

    public void webtoonOpen() {
        //implement business logic here:

        OpenChecked openChecked = new OpenChecked(this);
        openChecked.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void openApprove(OpenApproved openApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Webtoon webtoon = new Webtoon();
        repository().save(webtoon);

        */

        /** Example 2:  finding and process
        
        repository().findById(openApproved.get???()).ifPresent(webtoon->{
            
            webtoon // do something
            repository().save(webtoon);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void openReject(OpenRejected openRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        Webtoon webtoon = new Webtoon();
        repository().save(webtoon);

        */

        /** Example 2:  finding and process
        
        repository().findById(openRejected.get???()).ifPresent(webtoon->{
            
            webtoon // do something
            repository().save(webtoon);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

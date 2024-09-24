package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.HistoryserviceApplication;
import finalprjwebtoonservicev.domain.CheckCorrected;
import finalprjwebtoonservicev.domain.CheckRejected;
import finalprjwebtoonservicev.domain.HistoryCreated;
import finalprjwebtoonservicev.domain.HistoryUpdated;
import finalprjwebtoonservicev.domain.OpenApproved;
import finalprjwebtoonservicev.domain.OpenRejected;
import finalprjwebtoonservicev.domain.UserCreated;
import finalprjwebtoonservicev.domain.UserDeleted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "History_table")
@Data
//<<< DDD / Aggregate Root
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Integer point;

    private Integer price;

    private String webtoonId;

    private Integer myPoint;

    private String status;

    @PostPersist
    public void onPostPersist() {
        UserCreated userCreated = new UserCreated(this);
        userCreated.publishAfterCommit();

        UserDeleted userDeleted = new UserDeleted(this);
        userDeleted.publishAfterCommit();

        OpenApproved openApproved = new OpenApproved(this);
        openApproved.publishAfterCommit();

        OpenRejected openRejected = new OpenRejected(this);
        openRejected.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        HistoryCreated historyCreated = new HistoryCreated(this);
        historyCreated.publishAfterCommit();

        HistoryUpdated historyUpdated = new HistoryUpdated(this);
        historyUpdated.publishAfterCommit();

        CheckCorrected checkCorrected = new CheckCorrected(this);
        checkCorrected.publishAfterCommit();

        CheckRejected checkRejected = new CheckRejected(this);
        checkRejected.publishAfterCommit();
    }

    public static HistoryRepository repository() {
        HistoryRepository historyRepository = HistoryserviceApplication.applicationContext.getBean(
            HistoryRepository.class
        );
        return historyRepository;
    }

    //<<< Clean Arch / Port Method
    public static void paymentHistory(PaymenteFailed paymenteFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryCreated historyCreated = new HistoryCreated(history);
        historyCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymenteFailed.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryCreated historyCreated = new HistoryCreated(history);
            historyCreated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void paymentHistory(DecreasedComplete decreasedComplete) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryCreated historyCreated = new HistoryCreated(history);
        historyCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(decreasedComplete.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryCreated historyCreated = new HistoryCreated(history);
            historyCreated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void paymentHistory(Increased increased) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryCreated historyCreated = new HistoryCreated(history);
        historyCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(increased.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryCreated historyCreated = new HistoryCreated(history);
            historyCreated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void buyHistory(BuyFailed buyFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryUpdated historyUpdated = new HistoryUpdated(history);
        historyUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(buyFailed.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryUpdated historyUpdated = new HistoryUpdated(history);
            historyUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void buyHistory(
        PurchaseCancelComplete purchaseCancelComplete
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryUpdated historyUpdated = new HistoryUpdated(history);
        historyUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(purchaseCancelComplete.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryUpdated historyUpdated = new HistoryUpdated(history);
            historyUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void buyHistory(PurchaseCancelFailed purchaseCancelFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryUpdated historyUpdated = new HistoryUpdated(history);
        historyUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(purchaseCancelFailed.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryUpdated historyUpdated = new HistoryUpdated(history);
            historyUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void buyHistory(CancelFailed cancelFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        HistoryUpdated historyUpdated = new HistoryUpdated(history);
        historyUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cancelFailed.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            HistoryUpdated historyUpdated = new HistoryUpdated(history);
            historyUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void userInfoCheck(BuyComplete buyComplete) {
        //implement business logic here:

        System.out.println("============================================================userInfoCheck============================================================");
        //implement business logic here:
        repository().findById(buyComplete.getId()).ifPresent(history->{
           
            if(history.getMyPoint() >= buyComplete.getPoint()){

                history.setMyPoint(history.getMyPoint() - buyComplete.getPoint());
                history.setStatus("buy success");
                repository().save(history);

                CheckCorrected checkCorrected = new CheckCorrected(history);
                checkCorrected.publishAfterCommit();
            } else {

                history.setStatus("buy fail..");
                repository().save(history);

                CheckRejected checkRejected = new CheckRejected(history);
                checkRejected.publishAfterCommit();
            }          
         });
        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        CheckRejected checkRejected = new CheckRejected(history);
        checkRejected.publishAfterCommit();
        CheckCorrected checkCorrected = new CheckCorrected(history);
        checkCorrected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(buyComplete.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            CheckRejected checkRejected = new CheckRejected(history);
            checkRejected.publishAfterCommit();
            CheckCorrected checkCorrected = new CheckCorrected(history);
            checkCorrected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void userInfoCheck(CancelComplete cancelComplete) {
        //implement business logic here:
        System.out.println("============================================================userInfoCheck============================================================");
        //implement business logic here:
        repository().findById(cancelComplete.getUserId()).ifPresent(history->{
           
            if(history.getMyPoint() >= cancelComplete.getPoint()){

                history.setMyPoint(history.getMyPoint() - cancelComplete.getPoint());
                history.setStatus("buy success");
                repository().save(history);

                CheckCorrected checkCorrected = new CheckCorrected(history);
                checkCorrected.publishAfterCommit();
            } else {

                history.setStatus("buy fail..");
                repository().save(history);

                CheckRejected checkRejected = new CheckRejected(history);
                checkRejected.publishAfterCommit();
            }          
         });
        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        CheckRejected checkRejected = new CheckRejected(history);
        checkRejected.publishAfterCommit();
        CheckCorrected checkCorrected = new CheckCorrected(history);
        checkCorrected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cancelComplete.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            CheckRejected checkRejected = new CheckRejected(history);
            checkRejected.publishAfterCommit();
            CheckCorrected checkCorrected = new CheckCorrected(history);
            checkCorrected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void userCreate(Joind joind) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        UserCreated userCreated = new UserCreated(history);
        userCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(joind.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            UserCreated userCreated = new UserCreated(history);
            userCreated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void userDelete(Withdrawed withdrawed) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        UserDeleted userDeleted = new UserDeleted(history);
        userDeleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(withdrawed.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            UserDeleted userDeleted = new UserDeleted(history);
            userDeleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void webtoonOpenCheck(OpenChecked openChecked) {
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        OpenApproved openApproved = new OpenApproved(history);
        openApproved.publishAfterCommit();
        OpenRejected openRejected = new OpenRejected(history);
        openRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(openChecked.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);

            OpenApproved openApproved = new OpenApproved(history);
            openApproved.publishAfterCommit();
            OpenRejected openRejected = new OpenRejected(history);
            openRejected.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

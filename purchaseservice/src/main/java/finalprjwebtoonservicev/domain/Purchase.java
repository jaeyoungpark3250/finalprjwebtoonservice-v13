package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.PurchaseserviceApplication;
import finalprjwebtoonservicev.domain.BuyComplete;
import finalprjwebtoonservicev.domain.BuyFailed;
import finalprjwebtoonservicev.domain.CancelComplete;
import finalprjwebtoonservicev.domain.CancelFailed;
import finalprjwebtoonservicev.domain.PurchaseCancelComplete;
import finalprjwebtoonservicev.domain.PurchaseCancelFailed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Purchase_table")
@Data
//<<< DDD / Aggregate Root
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Integer point;

    private Integer myPoint;

    private String webtoonId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        BuyComplete buyComplete = new BuyComplete(this);
        buyComplete.publishAfterCommit();

        BuyFailed buyFailed = new BuyFailed(this);
        buyFailed.publishAfterCommit();

        PurchaseCancelComplete purchaseCancelComplete = new PurchaseCancelComplete(
            this
        );
        purchaseCancelComplete.publishAfterCommit();

        PurchaseCancelFailed purchaseCancelFailed = new PurchaseCancelFailed(
            this
        );
        purchaseCancelFailed.publishAfterCommit();

        CancelComplete cancelComplete = new CancelComplete(this);
        cancelComplete.publishAfterCommit();

        CancelFailed cancelFailed = new CancelFailed(this);
        cancelFailed.publishAfterCommit();
    }

    public static PurchaseRepository repository() {
        PurchaseRepository purchaseRepository = PurchaseserviceApplication.applicationContext.getBean(
            PurchaseRepository.class
        );
        return purchaseRepository;
    }

    public void buyWebtoon() {
        //implement business logic here:

        BuyComplete buyComplete = new BuyComplete(this);
        buyComplete.publishAfterCommit();
    }

    public void cancelWebtoon() {
        //implement business logic here:

        CancelComplete cancelComplete = new CancelComplete(this);
        cancelComplete.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void approvePurchaseCancel(CheckCorrected checkCorrected) {
        //implement business logic here:

        /** Example 1:  new item 
        Purchase purchase = new Purchase();
        repository().save(purchase);

        PurchaseCancelComplete purchaseCancelComplete = new PurchaseCancelComplete(purchase);
        purchaseCancelComplete.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(checkCorrected.get???()).ifPresent(purchase->{
            
            purchase // do something
            repository().save(purchase);

            PurchaseCancelComplete purchaseCancelComplete = new PurchaseCancelComplete(purchase);
            purchaseCancelComplete.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void rejectedPurchaseCancel(CheckRejected checkRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        Purchase purchase = new Purchase();
        repository().save(purchase);

        PurchaseCancelFailed purchaseCancelFailed = new PurchaseCancelFailed(purchase);
        purchaseCancelFailed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(checkRejected.get???()).ifPresent(purchase->{
            
            purchase // do something
            repository().save(purchase);

            PurchaseCancelFailed purchaseCancelFailed = new PurchaseCancelFailed(purchase);
            purchaseCancelFailed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

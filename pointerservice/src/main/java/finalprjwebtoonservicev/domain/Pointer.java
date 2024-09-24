package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.Joind;
import finalprjwebtoonservicev.domain.Withdrawed;
import finalprjwebtoonservicev.domain.Increased;
import finalprjwebtoonservicev.domain.DecreasedComplete;
import finalprjwebtoonservicev.PointerserviceApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Pointer_table")
@Data

//<<< DDD / Aggregate Root
public class Pointer  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private Integer point;

    @PostPersist
    public void onPostPersist(){


        Joind joind = new Joind(this);
        joind.publishAfterCommit();



        Withdrawed withdrawed = new Withdrawed(this);
        withdrawed.publishAfterCommit();



        Increased increased = new Increased(this);
        increased.publishAfterCommit();



        DecreasedComplete decreasedComplete = new DecreasedComplete(this);
        decreasedComplete.publishAfterCommit();

    
    }

    public static PointerRepository repository(){
        PointerRepository pointerRepository = PointerserviceApplication.applicationContext.getBean(PointerRepository.class);
        return pointerRepository;
    }



    public void join(){
        //implement business logic here:
        
        Joind joind = new Joind(this);
        joind.publishAfterCommit();
        
        
        finalprjwebtoonservicev.external.PointerQuery pointerQuery = new finalprjwebtoonservicev.external.PointerQuery();
        PointerApplication.applicationContext
            .getBean(finalprjwebtoonservicev.external.Service.class)
            .( pointerQuery);
    }
    public void withdraw(){
        //implement business logic here:
        
        Withdrawed withdrawed = new Withdrawed(this);
        withdrawed.publishAfterCommit();
        
        
    }

//<<< Clean Arch / Port Method
    public static void pointIncrease(PaymenteComplete paymenteComplete){
        
        //implement business logic here:

        /** Example 1:  new item 
        Pointer pointer = new Pointer();
        repository().save(pointer);

        Increased increased = new Increased(pointer);
        increased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymenteComplete.get???()).ifPresent(pointer->{
            
            pointer // do something
            repository().save(pointer);

            Increased increased = new Increased(pointer);
            increased.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void pointDecrease(RefundComplete refundComplete){
        
        //implement business logic here:

        /** Example 1:  new item 
        Pointer pointer = new Pointer();
        repository().save(pointer);

        DecreasedComplete decreasedComplete = new DecreasedComplete(pointer);
        decreasedComplete.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(refundComplete.get???()).ifPresent(pointer->{
            
            pointer // do something
            repository().save(pointer);

            DecreasedComplete decreasedComplete = new DecreasedComplete(pointer);
            decreasedComplete.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void pointDecrease(CheckCorrected checkCorrected){
        
        //implement business logic here:

        /** Example 1:  new item 
        Pointer pointer = new Pointer();
        repository().save(pointer);

        DecreasedComplete decreasedComplete = new DecreasedComplete(pointer);
        decreasedComplete.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(checkCorrected.get???()).ifPresent(pointer->{
            
            pointer // do something
            repository().save(pointer);

            DecreasedComplete decreasedComplete = new DecreasedComplete(pointer);
            decreasedComplete.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root

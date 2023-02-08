package food.delivery.domain;

import food.delivery.domain.Accepted;
import food.delivery.domain.Rejected;
import food.delivery.domain.Cooked;
import food.delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Cooking_table")
@Data

public class Cooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();

    }

    public static CookingRepository repository(){
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(CookingRepository.class);
        return cookingRepository;
    }



    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand){
    }

    public static void storeOrderData(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

        
    }


}

package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryItemAdded extends AbstractEvent {

    private Long id;

    public DeliveryItemAdded(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryItemAdded(){
        super();
    }
}

package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private String options;
}

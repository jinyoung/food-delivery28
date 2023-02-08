package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Accepted extends AbstractEvent {

    private Long id;
    private Long orderId;
}

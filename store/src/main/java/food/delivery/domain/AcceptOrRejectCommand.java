package food.delivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Data
public class AcceptOrRejectCommand {

        private Boolean accept;


}

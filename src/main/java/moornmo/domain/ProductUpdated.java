package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductUpdated extends AbstractEvent {

    private String productId;

    public ProductUpdated(Product aggregate) {
        super(aggregate);
    }

    public ProductUpdated() {
        super();
    }
}
//>>> DDD / Domain Event

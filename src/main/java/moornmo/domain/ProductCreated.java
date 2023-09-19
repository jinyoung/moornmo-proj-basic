package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductCreated extends AbstractEvent {

    private String productId;

    public ProductCreated(Product aggregate) {
        super(aggregate);
    }

    public ProductCreated() {
        super();
    }
}
//>>> DDD / Domain Event

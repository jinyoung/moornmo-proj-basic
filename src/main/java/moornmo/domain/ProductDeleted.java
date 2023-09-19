package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductDeleted extends AbstractEvent {

    public ProductDeleted(Product aggregate) {
        super(aggregate);
    }

    public ProductDeleted() {
        super();
    }
}
//>>> DDD / Domain Event

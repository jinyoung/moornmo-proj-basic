package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateProductCommand {

    private String productId;
    private String name;
    private String description;
    private Money price;
    private Address address;
}

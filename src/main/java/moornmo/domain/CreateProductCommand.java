package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateProductCommand {

    private String name;
    private String description;
    private Money price;
    private Address address;
}

package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteProductCommand {

    private String productId;
}

package moornmo.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;
import moornmo.BasicApplication;
import moornmo.domain.ProductCreated;
import moornmo.domain.ProductDeleted;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Money price;

    @PostPersist
    public void onPostPersist() {
        ProductCreated productCreated = new ProductCreated(this);
        productCreated.publishAfterCommit();

        ProductDeleted productDeleted = new ProductDeleted(this);
        productDeleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProductRepository repository() {
        ProductRepository productRepository = BasicApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateProduct(UpdateProductCommand updateProductCommand) {
        //implement business logic here:

        ProductUpdated productUpdated = new ProductUpdated(this);
        productUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

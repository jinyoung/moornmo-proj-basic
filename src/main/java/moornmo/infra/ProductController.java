package moornmo.infra;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import java.util.Optional;
import moornmo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/products")
@Transactional
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(
        value = "products/{id}//products/{productId}",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Product updateProduct(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateProductCommand updateProductCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /product/updateProduct  called #####");
        Optional<Product> optionalProduct = productRepository.findById(id);

        optionalProduct.orElseThrow(() -> new Exception("No Entity Found"));
        Product product = optionalProduct.get();
        product.updateProduct(updateProductCommand);

        productRepository.save(product);
        return product;
    }
}
//>>> Clean Arch / Inbound Adaptor

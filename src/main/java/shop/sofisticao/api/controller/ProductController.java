package shop.sofisticao.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.sofisticao.api.entity.Product;
import shop.sofisticao.api.repository.ProductRepository;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/api/products")
    public Product getProduct(){
        productRepository.save(new Product("nome", 5));
        return productRepository.findItemByName("nome");
    }

}

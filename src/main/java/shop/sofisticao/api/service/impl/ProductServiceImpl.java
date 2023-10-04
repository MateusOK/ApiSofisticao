package shop.sofisticao.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.dto.response.ProductResponseDto;
import shop.sofisticao.api.entity.Product;
import shop.sofisticao.api.repository.ProductRepository;
import shop.sofisticao.api.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto request) {
        var productResponse = productRepository.save(new Product(request));
        return new ProductResponseDto(productResponse);
    }

    @Override
    public List<ProductResponseDto> findByName(String name) {
        var response = productRepository.findByNameContaining(name);
        var products = new ArrayList<ProductResponseDto>();
        response.forEach(product -> products.add(new ProductResponseDto(product)));

        if (products.isEmpty()){
            throw new RuntimeException("no products found with this name");
        }
        return products;
    }

    @Override
    public List<ProductResponseDto> findAllProducts() {
        var response = productRepository.findAll();
        var products = new ArrayList<ProductResponseDto>();
        response.forEach(product -> products.add(new ProductResponseDto(product)));

        if (products.isEmpty()){
            throw new RuntimeException("no products found");
        }
        return products;
    }

    @Override
    public ProductResponseDto findProductById(String id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id: " + id));
        return new ProductResponseDto(product);
    }
}
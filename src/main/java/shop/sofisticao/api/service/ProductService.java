package shop.sofisticao.api.service;

import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto saveProduct(ProductRequestDto request);

    List<ProductResponseDto> findByName(String name);

    List<ProductResponseDto> findAllProducts();

    ProductResponseDto findProductById(String id);

    void deleteProductById(String id);

}

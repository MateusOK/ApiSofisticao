package shop.sofisticao.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.dto.response.ProductResponseDto;
import shop.sofisticao.api.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductRequestDto request, UriComponentsBuilder builder) {
        var response = productService.saveProduct(request);
        var uri = builder.path("/api/products/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        var response = productService.findAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable String id){
        var response = productService.findProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductResponseDto>> getProductByName(@PathVariable String name) {
        var response = productService.findByName(name);
        return ResponseEntity.ok(response);
    }
}
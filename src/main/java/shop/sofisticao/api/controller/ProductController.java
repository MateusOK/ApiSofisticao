package shop.sofisticao.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.dto.response.ProductResponseDto;
import shop.sofisticao.api.entity.Product;
import shop.sofisticao.api.service.FileUploadService;
import shop.sofisticao.api.service.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final FileUploadService fileUploadService;

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

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProductById(@PathVariable String id, @RequestBody ProductRequestDto request){
        Optional<ProductResponseDto> existingProductOptional = Optional.ofNullable(productService.findProductById(id));
        return existingProductOptional
                .map(existingProduct -> {
                    var response = productService.saveProduct(request);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/imagem")
    public ResponseEntity<String> uploadImage(
            @PathVariable String id,
            @RequestPart("imagem") MultipartFile imagem) {
        try {
            String imgUrl = fileUploadService.uploadFile(imagem);
            productService.saveImage(id, imgUrl);
            return ResponseEntity.ok("Imagem enviada com sucesso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
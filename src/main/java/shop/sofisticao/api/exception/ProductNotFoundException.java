package shop.sofisticao.api.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Product not found: " + id);
    }
}

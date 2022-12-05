package cl.rozo.awsprueba3.service;

import cl.rozo.awsprueba3.model.Product;
import cl.rozo.awsprueba3.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void insertProduct(Product product){
        productRepository.save(product);
    }
}

package ro.msg.learning.shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Model.DTO.ProductDTO;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Repositories.OrderRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.converter.ProductConverter;

import java.util.*;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDTO createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        ProductConverter productConverter = null;
        ProductDTO dto=productConverter.modelToDto(newProduct);
        return dto;
    }

    public void updateProduct(Integer id, Product product) {
        Product product1 = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "+ id));
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


    public Collection<ProductDTO> findAll() {
        Collection <Product> products = productRepository.findAll();
        ProductConverter productConverter = null;
        return productConverter.converterMapper(products);
    }

    public ProductDTO getProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "+ id));
        ProductConverter productConverter = null;
        return productConverter.modelToDto(product);
    }

}

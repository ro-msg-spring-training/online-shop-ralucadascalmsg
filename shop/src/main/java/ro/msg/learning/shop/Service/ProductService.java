package ro.msg.learning.shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Model.DTO.ProductDTO;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Repositories.OrderRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;

import java.util.*;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    //adaugarea produsului in bd si returnarea acestuia in format DTO
    public ProductDTO createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        ProductDTO dto = new ProductDTO();
        dto.setName(newProduct.getName());
        dto.setDescription(newProduct.getDescription());
        dto.setPrice(newProduct.getPrice());
        dto.setWeight(newProduct.getWeight());
        dto.setCategory_id(newProduct.getCategory().getId());
        dto.setSupplier_id(newProduct.getSupplier().getId());
        dto.setCategory(newProduct.getCategory().getName());
        dto.setSupplier(newProduct.getSupplier().getName());
        dto.setImageUrl(newProduct.getImageUrl());
        dto.setDescriptionCategory(newProduct.getCategory().getDescription());
        return dto;
    }
    //actualizarea unui produs(gasirea acestuia dupa id si setarea atributelor conform produsului nou)
    public void updateProduct(Integer id, Product product) {
        Product p = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "+ id));
        p.setPrice(product.getPrice());
        productRepository.save(p);
    }
    //stergerea unui produs din bd
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    //returnarea tuturor produselor din bd sub forma DTO
    public Collection<ProductDTO> getAllProducts() {
        Collection <Product> products = productRepository.findAll();
        Collection <ProductDTO> productsDTO=new ArrayList<ProductDTO>();
        ProductDTO dto = new ProductDTO();
        for (Product p:products)
        {
            dto.setName(p.getName());
            dto.setDescription(p.getDescription());
            dto.setPrice(p.getPrice());
            dto.setWeight(p.getWeight());
            dto.setCategory_id(p.getCategory().getId());
            dto.setSupplier_id(p.getSupplier().getId());
            dto.setCategory(p.getCategory().getName());
            dto.setSupplier(p.getSupplier().getName());
            dto.setImageUrl(p.getImageUrl());
            dto.setDescriptionCategory(p.getCategory().getDescription());
            productsDTO.add(dto);
        }
        return productsDTO;
    }
    //gasirea unui produs dupa id si returnarea acestuia sub forma DTO
    public ProductDTO getProduct(Integer id) {
        Product p = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "+ id));
        ProductDTO dto = new ProductDTO();
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setPrice(p.getPrice());
        dto.setWeight(p.getWeight());
        dto.setCategory_id(p.getCategory().getId());
        dto.setSupplier_id(p.getSupplier().getId());
        dto.setCategory(p.getCategory().getName());
        dto.setSupplier(p.getSupplier().getName());
        dto.setImageUrl(p.getImageUrl());
        dto.setDescriptionCategory(p.getCategory().getDescription());
        return dto;
    }

}

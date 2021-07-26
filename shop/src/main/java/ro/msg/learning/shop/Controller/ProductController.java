package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    //Get all products
    @RequestMapping(value = "/products", method = GET)
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    //Get product by id
    @RequestMapping(value = "/productById", method = GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.getProduct(Integer.parseInt(id)), HttpStatus.OK);
    }

   // Update product
    @RequestMapping(value = "/products/{id}", method = PUT)
    public ResponseEntity<Object>
        updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(Integer.parseInt(id), product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    //Delete product
    @RequestMapping(value = "/products/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(Integer.parseInt(id));
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    //Create product
    @RequestMapping(value = "/product", method = POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

}

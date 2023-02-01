package com.projectSecurity.security.demo;

import com.projectSecurity.security.model.Product;
import com.projectSecurity.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

  @GetMapping("/allProducts")
  @PreAuthorize("hasAuthority('USER')")
  public ResponseEntity<List<Product>> getAllProducts(){
    return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable int id){
    return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK);
  }

  @PostMapping("/saveProduct")
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<Product> save(@RequestBody Product product){
    return new ResponseEntity<>(productService.save(product), HttpStatus.ACCEPTED);
  }

}

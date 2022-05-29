package com.kelaskoding.controllers;

import com.kelaskoding.models.entities.Product;
import com.kelaskoding.models.repos.ProductRepo;
import com.kelaskoding.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@Valid @RequestBody Product product, Errors errors){

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()
                    ) {
                System.out.println(error.getDefaultMessage());
            }
            throw new RuntimeException("VAlID error gaes!");
        }
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }
    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productService.removeOne(id);
    }


}

package com.kookies.web.controller;

import com.kookies.persistence.entity.Product;
import com.kookies.service.IProductService;
import com.kookies.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @Operation(summary = "Get all products active and inactive")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<ProductDTO>> findAll(){
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/active")
    @Operation(summary = "Get all active products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Active products not found")
    })
    public ResponseEntity<List<ProductDTO>> findAllActive(){
        return ResponseEntity.of(this.productService.getByActive(true));
    }

    @GetMapping("/inactive")
    @Operation(summary = "Get all inactive products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Inactive products not found")
    })
    public ResponseEntity<List<ProductDTO>> findAllInactive(){
        return ResponseEntity.of(this.productService.getByActive(false));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<ProductDTO> getProduct(@Parameter(description = "Product id", required = true, example = "1") @PathVariable("id") Integer id){
        return ResponseEntity.of(this.productService.findById(id));
    }

    @GetMapping("/size/{sizeId}")
    @Operation(summary = "Get active products by size ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product with size ID not found")
    })
    public ResponseEntity<List<ProductDTO>> getProductBySize(@Parameter(description = "Size id", required = true, example = "2") @PathVariable("sizeId") Integer sizeId){
        return ResponseEntity.of(this.productService.getBySize(sizeId));
    }

    @PutMapping("/update")
    @Operation(summary = "Update product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "204", description = "Product not found")
    })
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO){
        if(this.productService.findById(productDTO.getProductId()).isPresent()){
            return ResponseEntity.ok(this.productService.update(productDTO));
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    @Operation(summary = "Create a Product")
    @ApiResponse(responseCode = "201", description = "Product created")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(this.productService.save(productDTO)) ;
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Delete product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "204", description = "Product not found")
    })
    public ResponseEntity<Void> deleteProduct(@Parameter(description = "Product id", required = true, example = "11") @PathVariable("productId") Integer productId){
        if(this.productService.findById(productId).isPresent()){
            this.productService.delete(productId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}

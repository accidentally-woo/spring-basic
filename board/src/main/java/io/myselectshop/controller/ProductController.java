package io.myselectshop.controller;

import io.myselectshop.dto.ProductMyPriceRequestDto;
import io.myselectshop.dto.ProductRequestDto;
import io.myselectshop.dto.ProductResponseDto;
import io.myselectshop.entity.Product;
import io.myselectshop.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, HttpServletRequest request) {
        return new ProductResponseDto(productService.createProduct(requestDto, request));
    }

    @GetMapping("/products")
    public Page<Product> getProducts(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam Boolean isAsc,
            HttpServletRequest request
    ) {
        return productService.getProducts(request, page - 1, size, sortBy, isAsc);
    }

    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMyPriceRequestDto requestDto, HttpServletRequest request) {
        return productService.updateProduct(id, requestDto, request);
    }

    @PostMapping("/products/{id}/folder")
    public Long addFolder(@PathVariable Long id, @RequestParam Long folderId, HttpServletRequest request) {
        Product product = productService.addFolder(id, folderId, request);
        return product.getId();
    }
}

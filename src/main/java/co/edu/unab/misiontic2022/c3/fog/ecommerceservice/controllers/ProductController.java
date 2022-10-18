package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.controllers;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IProductService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/products")
public class ProductController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId){
        List<ProductDto> products = new ArrayList<>();
        if (categoryId == null){
            products = productService.listAllProduct();
            if (products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else {
            products = productService.findByCategory(CategoryDto.builder().id(categoryId).build());
            if (products.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(products);
    }


}

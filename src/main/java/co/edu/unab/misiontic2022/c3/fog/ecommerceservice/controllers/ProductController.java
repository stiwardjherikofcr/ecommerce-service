package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.controllers;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request.ProductCreateRequestModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response.ProductDataResponseModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.ICategoryService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IProductService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.ProductDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/products")
@Tag(name = "Products", description = "Products API")
public class ProductController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "")
    public ResponseEntity<List<ProductDataResponseModel>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        List<ProductDto> products = new ArrayList<>();
        if (categoryId == null) {
            products = productService.listAllProduct();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            products = productService.findAllByCategory(CategoryDto.builder().idCategory(categoryId).build());
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        List<ProductDataResponseModel> productsResponse = new ArrayList<>();
        products.forEach(product -> {
            productsResponse.add(modelMapper.map(product, ProductDataResponseModel.class));
        });
        return ResponseEntity.ok(productsResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDataResponseModel> getProduct(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getProduct(id);
        if (productDto == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDataResponseModel productDataResponseModel = modelMapper.map(productDto, ProductDataResponseModel.class);
        return ResponseEntity.ok(productDataResponseModel);
    }

    @PostMapping(value = "")
    public ResponseEntity<ProductDataResponseModel> createProduct(@RequestBody ProductCreateRequestModel productCreateRequestModel) {
        CategoryDto categoryDto = categoryService.getCategoryById(productCreateRequestModel.getIdCategory());
        if (categoryDto == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDto productDto = modelMapper.map(productCreateRequestModel, ProductDto.class);
        productDto.setCategory(categoryDto);
        ProductDto productCreated = productService.createProduct(productDto);
        ProductDataResponseModel productDataResponseModel = modelMapper.map(productCreated, ProductDataResponseModel.class);
        return ResponseEntity.ok(productDataResponseModel);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDataResponseModel> updateProduct(@PathVariable("id") Long id, @RequestBody ProductCreateRequestModel productCreateRequestModel) {
        if (productService.getProduct(id) == null) {
            return ResponseEntity.notFound().build();
        }
        CategoryDto categoryDto = categoryService.getCategoryById(productCreateRequestModel.getIdCategory());
        if (categoryDto == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDto productDto = modelMapper.map(productCreateRequestModel, ProductDto.class);
        productDto.setIdProduct(id);
        productDto.setCategory(categoryDto);
        ProductDto productDtoUpdated = productService.updateProduct(productDto);
        ProductDataResponseModel productDataResponseModel = modelMapper.map(productDtoUpdated, ProductDataResponseModel.class);
        return ResponseEntity.ok(productDataResponseModel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}

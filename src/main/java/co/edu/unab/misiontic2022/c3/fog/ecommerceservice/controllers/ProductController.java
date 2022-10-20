package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.controllers;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response.ProductDataResponseModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IProductService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IProductService productService;

    @GetMapping(value = "")
   public ResponseEntity<List<ProductDataResponseModel>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId){
        List<ProductDto> products = new ArrayList<>();
        if(categoryId == null){
            products = productService.listAllProduct();
            if(products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }/*else{
            products = productService.findByCategory(new CategoryDto().setIdCategory(categoryId));
        }*/
        List<ProductDataResponseModel> productsResponse = new ArrayList<>();
        products.forEach(product -> {
            productsResponse.add(modelMapper.map(product, ProductDataResponseModel.class));
        });
        return ResponseEntity.ok(productsResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDataResponseModel> getProduct(@PathVariable("id") Long id){
        ProductDto productDto = productService.getProduct(id);
        if (productDto == null){
            return ResponseEntity.notFound().build();
        }
        ProductDataResponseModel productDataResponseModel = modelMapper.map(productDto, ProductDataResponseModel.class);
        return ResponseEntity.ok(productDataResponseModel);
    }

    @PostMapping(value = "")
    public ResponseEntity<ProductDataResponseModel> createProduct(@RequestBody ProductDataResponseModel productDataResponseModel){
        ProductDto productDto = modelMapper.map(productDataResponseModel, ProductDto.class);
        ProductDto productDtoCreated = productService.createProduct(productDto);
        ProductDataResponseModel productDataResponseModelCreated = modelMapper.map(productDtoCreated, ProductDataResponseModel.class);
        return ResponseEntity.ok(productDataResponseModelCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDataResponseModel> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDataResponseModel productDataResponseModel){
        ProductDto productDto = modelMapper.map(productDataResponseModel, ProductDto.class);
        ProductDto productDtoUpdated = productService.updateProduct(productDto);
        ProductDataResponseModel productDataResponseModelUpdated = modelMapper.map(productDtoUpdated, ProductDataResponseModel.class);
        return ResponseEntity.ok(productDataResponseModelUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}

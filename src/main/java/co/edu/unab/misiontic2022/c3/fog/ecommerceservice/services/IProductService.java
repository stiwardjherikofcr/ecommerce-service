package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.ProductDto;

import java.util.List;

public interface IProductService {

    public List<ProductDto> listAllProduct();

    public ProductDto getProduct(Long id);

    public ProductDto createProduct(ProductDto product);

    public ProductDto updateProduct(ProductDto product);

    public ProductDto deleteProduct(Long id);

    public List<ProductDto> findAllByCategory(CategoryDto category);

}

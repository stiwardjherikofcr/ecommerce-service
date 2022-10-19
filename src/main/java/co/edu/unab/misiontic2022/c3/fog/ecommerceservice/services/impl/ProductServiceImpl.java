package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.ProductEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.IProductRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IProductService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<ProductDto> listAllProduct() {
        List<ProductEntity> productsEntity = productRepository.findAll();
        List<ProductDto> productsDto = new ArrayList<>();
        for (ProductEntity productEntity : productsEntity) {
            productsDto.add(modelMapper.map(productEntity, ProductDto.class));
        }
        return productsDto;
    }

    @Override
    public ProductDto getProduct(Long id) {
        return null;
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        return null;
    }

    @Override
    public ProductDto deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> findByCategory(CategoryDto category) {
        return null;
    }

}

package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.ProductEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    //List<ProductDto> findByCategory(CategoryDto category);

}

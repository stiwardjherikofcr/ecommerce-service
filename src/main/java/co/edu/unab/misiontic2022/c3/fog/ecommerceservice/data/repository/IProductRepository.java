package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.CategoryEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.ProductEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategory(CategoryEntity category);

}

package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

}

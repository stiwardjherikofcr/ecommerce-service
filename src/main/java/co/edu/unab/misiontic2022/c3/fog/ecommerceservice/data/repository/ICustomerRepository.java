package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    public CustomerEntity findByEmail(String email);
    public CustomerEntity findByUsername(String username);

}

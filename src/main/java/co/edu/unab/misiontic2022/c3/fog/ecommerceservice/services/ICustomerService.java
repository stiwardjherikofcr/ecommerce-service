package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CustomerDto;

import java.util.List;

public interface ICustomerService {

    public List<CustomerDto> listAllCustomers();
    public CustomerDto getCustomerById(Long id);
    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto updateCustomer(CustomerDto customerDto);
    public void deleteCustomer(Long id);

}

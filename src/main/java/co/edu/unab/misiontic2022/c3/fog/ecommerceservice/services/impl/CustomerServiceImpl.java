package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.ICustomerRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.ICustomerService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<CustomerDto> listAllCustomers() {
        return null;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return null;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
    }

}

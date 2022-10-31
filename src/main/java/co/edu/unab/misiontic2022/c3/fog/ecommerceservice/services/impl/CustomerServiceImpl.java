package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.CustomerEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.ICustomerRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.exceptions.ResourceNotFoundException;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.ICustomerService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public CustomerDto signIn(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findByUsername(customerDto.getUsername());
        if (customerEntity == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        if (!bCryptPasswordEncoder.matches(customerDto.getPassword(), customerEntity.getPassword())) {
            throw new ResourceNotFoundException("Password incorrect");
        }
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public CustomerDto signUp(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        customerEntity.setPassword(bCryptPasswordEncoder.encode(customerEntity.getPassword()));
        CustomerEntity customerEntityRegistered = customerRepository.save(customerEntity);
        return modelMapper.map(customerEntityRegistered, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> listAllCustomers() {
        List<CustomerEntity> customersEntity = customerRepository.findAll();
        List<CustomerDto> customersDto = new ArrayList<>();
        for (CustomerEntity customerEntity : customersEntity) {
            customersDto.add(modelMapper.map(customerEntity, CustomerDto.class));
        }
        return customersDto;
    }

    @Override
    public CustomerDto getCustomerById(Long id) throws ResourceNotFoundException {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        customerEntity.setPassword(bCryptPasswordEncoder.encode(customerDto.getPassword()));
        customerEntity = customerRepository.save(customerEntity);
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) throws ResourceNotFoundException {
        if (customerRepository.existsById(customerDto.getIdCustomer())) {
            CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
            customerEntity = customerRepository.save(customerEntity);
            return modelMapper.map(customerEntity, CustomerDto.class);
        }
        throw new ResourceNotFoundException("Customer not found");
    }

    @Override
    public void deleteCustomer(Long id) throws ResourceNotFoundException {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
        customerRepository.delete(customerEntity);
    }

}

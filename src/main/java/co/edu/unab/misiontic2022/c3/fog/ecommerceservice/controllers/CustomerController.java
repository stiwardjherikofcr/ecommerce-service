package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.controllers;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request.CustomerSigninRequestModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request.CustomerSignupRequestModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response.CustomerDataResponseModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.ICustomerService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IRoleService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CustomerDto;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.RoleDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customers")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRoleService roleService;

    @PostMapping("/auth/signin")
    public ResponseEntity<CustomerDataResponseModel> login(@RequestBody CustomerSigninRequestModel customerSigninRequestModel) {
        CustomerDto customerDto = modelMapper.map(customerSigninRequestModel, CustomerDto.class);
        CustomerDto customerDtoLogged = customerService.signIn(customerDto);
        CustomerDataResponseModel customerDataResponseModelLogged = modelMapper.map(customerDtoLogged, CustomerDataResponseModel.class);
        return ResponseEntity.ok(customerDataResponseModelLogged);
    }

    @PostMapping(value = "/auth/signup")
    public ResponseEntity<CustomerDataResponseModel> register(@RequestBody CustomerSignupRequestModel customerSignupRequestModel) {
        RoleDto roleDto = roleService.getRoleById(2L);
        CustomerDto customerDto = modelMapper.map(customerSignupRequestModel, CustomerDto.class);
        customerDto.setRole(roleDto);
        CustomerDto customerDtoRegistered = customerService.signUp(customerDto);
        CustomerDataResponseModel customerDataResponseModelRegistered = modelMapper.map(customerDtoRegistered, CustomerDataResponseModel.class);
        return ResponseEntity.ok(customerDataResponseModelRegistered);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CustomerDataResponseModel>> listCustomer() {
        List<CustomerDto> customers = customerService.listAllCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CustomerDataResponseModel> customersResponse = new ArrayList<>();
        customers.forEach(customer -> {
            customersResponse.add(modelMapper.map(customer, CustomerDataResponseModel.class));
        });
        return ResponseEntity.ok(customersResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDataResponseModel> getCustomer(@PathVariable("id") Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        if (customerDto == null) {
            return ResponseEntity.notFound().build();
        }
        CustomerDataResponseModel customerDataResponseModel = modelMapper.map(customerDto, CustomerDataResponseModel.class);
        return ResponseEntity.ok(customerDataResponseModel);
    }

    @PostMapping(value = "")
    public ResponseEntity<CustomerDataResponseModel> createCustomer(@RequestBody CustomerDataResponseModel customerDataResponseModel) {
        CustomerDto customerDto = modelMapper.map(customerDataResponseModel, CustomerDto.class);
        CustomerDto customerDtoCreated = customerService.createCustomer(customerDto);
        CustomerDataResponseModel customerDataResponseModelCreated = modelMapper.map(customerDtoCreated, CustomerDataResponseModel.class);
        return ResponseEntity.ok(customerDataResponseModelCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerDataResponseModel> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDataResponseModel customerDataResponseModel) {
        CustomerDto customerDto = modelMapper.map(customerDataResponseModel, CustomerDto.class);
        CustomerDto customerDtoUpdated = customerService.updateCustomer(customerDto);
        CustomerDataResponseModel customerDataResponseModelUpdated = modelMapper.map(customerDtoUpdated, CustomerDataResponseModel.class);
        return ResponseEntity.ok(customerDataResponseModelUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}

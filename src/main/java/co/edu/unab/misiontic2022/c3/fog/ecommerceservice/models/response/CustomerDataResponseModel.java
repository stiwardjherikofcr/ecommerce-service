package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response;

import lombok.Data;

@Data
public class CustomerDataResponseModel {

    private String idCustomer;
    private String fullName;
    private String email;
    private String username;
    private RoleDataResponseModel role;

}

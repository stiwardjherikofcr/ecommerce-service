package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request;

import lombok.Data;

@Data
public class CustomerSignupRequestModel {

    private String fullName;
    private String email;
    private String username;
    private String password;

}

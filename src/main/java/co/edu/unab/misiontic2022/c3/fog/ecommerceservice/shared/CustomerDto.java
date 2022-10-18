package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private Long idCustomer;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String passwordEncrypted;

}

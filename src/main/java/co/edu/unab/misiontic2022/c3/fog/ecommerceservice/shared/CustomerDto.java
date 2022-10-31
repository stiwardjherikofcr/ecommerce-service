package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idCustomer;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private RoleDto role;

}

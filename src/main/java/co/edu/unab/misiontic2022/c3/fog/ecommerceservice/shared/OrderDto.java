package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idOrder;
    private CustomerDto customer;
    private Date createAt;

}

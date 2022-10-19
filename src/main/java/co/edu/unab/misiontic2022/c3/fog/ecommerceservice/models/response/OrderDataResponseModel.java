package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDataResponseModel {

    private Long idOrder;
    private Integer idCustomer;
    private Date createAt;

}

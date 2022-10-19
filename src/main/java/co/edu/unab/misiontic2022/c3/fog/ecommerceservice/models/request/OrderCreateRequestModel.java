package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreateRequestModel {

    private Integer idCustomer;
    private List<OrderDetailCreateRequestModel> orderDetails;

}

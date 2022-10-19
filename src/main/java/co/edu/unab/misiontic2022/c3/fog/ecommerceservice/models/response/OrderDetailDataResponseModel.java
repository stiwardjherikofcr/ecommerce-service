package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response;

import lombok.Data;

@Data
public class OrderDetailDataResponseModel {

    private Long idOrderDetail;
    private Integer quantity;
    private Double price;
    private Double total;
    private ProductDataResponseModel product;

}

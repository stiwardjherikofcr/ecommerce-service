package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request;

import lombok.Data;

@Data
public class OrderDetailCreateRequestModel {

    private Long idOrder;
    private Long idProduct;
    private Integer quantity;
    private Double price;
    private Double total;

}

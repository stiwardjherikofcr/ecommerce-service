package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDataResponseModel {

    private Long idProduct;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer stock;
    private Boolean active;
    private CategoryDataResponseModel category;
    private Date createAt;

}

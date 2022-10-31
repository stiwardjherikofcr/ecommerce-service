package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.request;

import lombok.Data;

@Data
public class ProductCreateRequestModel {

    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer stock;
    private Boolean active;
    private Long idCategory;

}

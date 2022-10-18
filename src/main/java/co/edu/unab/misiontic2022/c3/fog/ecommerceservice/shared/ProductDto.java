package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer stock;
    private String active;
    private CategoryDto category;
    private Date createAt;

}

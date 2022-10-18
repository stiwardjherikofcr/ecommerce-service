package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;

}

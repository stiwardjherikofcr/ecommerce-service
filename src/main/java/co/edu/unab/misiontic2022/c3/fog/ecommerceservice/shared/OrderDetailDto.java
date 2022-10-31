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
public class OrderDetailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idOrderDetail;
    private OrderDto order;
    private ProductDto product;
    private int quantity;
    private double price;
    private double total;

}

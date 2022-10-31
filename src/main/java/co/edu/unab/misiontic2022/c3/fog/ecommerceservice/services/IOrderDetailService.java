package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.OrderDetailDto;

import java.util.List;

public interface IOrderDetailService {

    public List<OrderDetailDto> listAllOrderDetail();
    public OrderDetailDto getOrderDetailById(Long id);
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetail);
    public OrderDetailDto updateOrderDetail(OrderDetailDto orderDetail);
    public OrderDetailDto deleteOrderDetail(Long id);

}

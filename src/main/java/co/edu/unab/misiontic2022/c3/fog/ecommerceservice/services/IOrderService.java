package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.OrderDto;

import java.util.List;

public interface IOrderService {

    public List<OrderDto> listAllOrder();
    public OrderDto getOrderById(Long id);
    public OrderDto createOrder(OrderDto order);
    public OrderDto updateOrder(OrderDto order);
    public OrderDto deleteOrder(Long id);
}

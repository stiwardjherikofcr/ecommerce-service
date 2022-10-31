package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.OrderEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.IOrderRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IOrderService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IOrderRepository orderRepository;

    @Override
    public List<OrderDto> listAllOrder() {
        List<OrderEntity> ordersEntity = orderRepository.findAll();
        List<OrderDto> ordersDto = new ArrayList<>();
        for (OrderEntity orderEntity : ordersEntity) {
            ordersDto.add(modelMapper.map(orderEntity, OrderDto.class));
        }
        return ordersDto;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id).map(orderEntity -> modelMapper.map(orderEntity, OrderDto.class)).orElse(null);
    }

    @Override
    public OrderDto createOrder(OrderDto order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity = orderRepository.save(orderEntity);
        return modelMapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(OrderDto order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity = orderRepository.save(orderEntity);
        return modelMapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderDto deleteOrder(Long id) {
        return orderRepository.findById(id).map(orderEntity -> {
            orderRepository.delete(orderEntity);
            return modelMapper.map(orderEntity, OrderDto.class);
        }).orElse(null);
    }

}

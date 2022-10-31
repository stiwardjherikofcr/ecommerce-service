package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.OrderDetailEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.IOrderDetailRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IOrderDetailService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.OrderDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDto> listAllOrderDetail() {
        List<OrderDetailEntity> orderDetailsEntity = orderDetailRepository.findAll();
        List<OrderDetailDto> orderDetailsDto = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : orderDetailsEntity) {
            orderDetailsDto.add(modelMapper.map(orderDetailEntity, OrderDetailDto.class));
        }
        return orderDetailsDto;
    }

    @Override
    public OrderDetailDto getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).map(orderDetailEntity -> modelMapper.map(orderDetailEntity, OrderDetailDto.class)).orElse(null);
    }

    @Override
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetail) {
        OrderDetailEntity orderDetailEntity = modelMapper.map(orderDetail, OrderDetailEntity.class);
        orderDetailEntity = orderDetailRepository.save(orderDetailEntity);
        return modelMapper.map(orderDetailEntity, OrderDetailDto.class);
    }

    @Override
    public OrderDetailDto updateOrderDetail(OrderDetailDto orderDetail) {
        OrderDetailEntity orderDetailEntity = modelMapper.map(orderDetail, OrderDetailEntity.class);
        orderDetailEntity = orderDetailRepository.save(orderDetailEntity);
        return modelMapper.map(orderDetailEntity, OrderDetailDto.class);
    }

    @Override
    public OrderDetailDto deleteOrderDetail(Long id) {
        return orderDetailRepository.findById(id).map(orderDetailEntity -> {
            orderDetailRepository.delete(orderDetailEntity);
            return modelMapper.map(orderDetailEntity, OrderDetailDto.class);
        }).orElse(null);
    }

}

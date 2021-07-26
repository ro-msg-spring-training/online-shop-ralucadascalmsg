package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.dto.OrderRequestDTO;
import ro.msg.learning.shop.model.Order;

public class OrderConverter {
    public Order dtoToModel(OrderRequestDTO orderRequestDTO)
    {
        Order order=Order.builder()
                .createdAt(orderRequestDTO.getCreatedAt())
                .addressStreetAddress(orderRequestDTO.getAddressStreetAddress())
                .addressCountry(orderRequestDTO.getAddressCountry())
                .addressCity(orderRequestDTO.getAddressCity())
                .addressCounty(orderRequestDTO.getAddressCounty())
                .build();
        return order;
    }
}

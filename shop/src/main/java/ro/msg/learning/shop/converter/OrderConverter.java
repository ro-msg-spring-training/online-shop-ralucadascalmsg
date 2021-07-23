package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.Model.DTO.OrderRequestDTO;
import ro.msg.learning.shop.Model.DTO.OrderResponseDTO;
import ro.msg.learning.shop.Model.Entities.Order;
import ro.msg.learning.shop.Model.Entities.Product;

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

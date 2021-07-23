package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.Model.DTO.OrderRequestDTO;
import ro.msg.learning.shop.Model.DTO.OrderResponseDTO;
import ro.msg.learning.shop.Model.Entities.Location;
import ro.msg.learning.shop.Model.Entities.Order;
import ro.msg.learning.shop.Model.Entities.Product;

public class LocationConverter {

    public Location dtotoModel(OrderResponseDTO orderResponseDTO) {
        Location location = Location
                .builder()
                .name(orderResponseDTO.getNameLocation())
                .build();
        return location;
    }
}

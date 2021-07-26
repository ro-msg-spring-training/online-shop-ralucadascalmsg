package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.dto.OrderResponseDTO;
import ro.msg.learning.shop.model.Location;

public class LocationConverter {

    public Location dtotoModel(OrderResponseDTO orderResponseDTO) {
        Location location = Location
                .builder()
                .name(orderResponseDTO.getNameLocation())
                .build();
        return location;
    }
}

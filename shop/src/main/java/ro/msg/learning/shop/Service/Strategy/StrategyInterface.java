package ro.msg.learning.shop.Service.Strategy;

import ro.msg.learning.shop.Model.DTO.OrderResponseDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;

import java.util.Collection;

public interface StrategyInterface {
    public Collection<OrderResponseDTO> OrderLocation(Collection<OrderedProductDTO> orderedProducts);
}

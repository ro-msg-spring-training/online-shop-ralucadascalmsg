package ro.msg.learning.shop.service.strategy;

import ro.msg.learning.shop.dto.OrderResponseDTO;
import ro.msg.learning.shop.dto.OrderedProductDTO;

import java.util.Collection;

public interface StrategyInterface {
    public Collection<OrderResponseDTO> OrderLocation(Collection<OrderedProductDTO> orderedProducts);
}

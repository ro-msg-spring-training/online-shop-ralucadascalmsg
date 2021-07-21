package ro.msg.learning.shop.Service.Strategy;

import ro.msg.learning.shop.Model.DTO.GoodOrderDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;

import java.util.Collection;

public interface StrategyInterface {
    public Collection<GoodOrderDTO> OrderLocation(Collection<OrderedProductDTO> orderedProducts);
}

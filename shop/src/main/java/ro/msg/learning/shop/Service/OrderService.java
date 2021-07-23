package ro.msg.learning.shop.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Model.DTO.OrderResponseDTO;
import ro.msg.learning.shop.Model.DTO.OrderRequestDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;
import ro.msg.learning.shop.Model.Entities.*;
import ro.msg.learning.shop.Repositories.OrderDetailRepository;
import ro.msg.learning.shop.Repositories.OrderRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Service.Strategy.StrategyInterface;
import ro.msg.learning.shop.converter.LocationConverter;
import ro.msg.learning.shop.converter.OrderConverter;
import ro.msg.learning.shop.converter.ProductConverter;

import java.util.Collection;
import java.util.spi.LocaleNameProvider;

@Service
@AllArgsConstructor
public class OrderService {
  OrderDetailRepository orderDetailRepository;
  OrderRepository orderRepository;
  StrategyInterface strategyInterface;
  StockRepository stockRepository;
  ProductRepository productRepository;

    public Order createOrder(OrderRequestDTO orderRequestDTO) {
       Collection<OrderResponseDTO> orderedList = strategyInterface.OrderLocation(orderRequestDTO.getOrderedProducts());
       ProductConverter productConverter = null;
       LocationConverter locationConverter = null;
       for (OrderResponseDTO orderedP: orderedList)
       {
           Product product=productConverter.dtoToModel(orderedP);
           Location location=locationConverter.dtotoModel(orderedP);
           Stock stock=stockRepository.findByProductAndLocation(product,location).orElseThrow(() -> new RuntimeException("Product not found "));
           int newStock=stock.getQuantity()-orderedP.getQuantity();
           stock.setQuantity(newStock);
           stockRepository.save(stock);
       }

        OrderConverter orderConverter = null;
        Order order=orderConverter.dtoToModel(orderRequestDTO);
        orderRepository.save(order);
        Collection <OrderedProductDTO> orderedProducts = orderRequestDTO.getOrderedProducts();
        for (OrderedProductDTO product:orderedProducts)
        {
            OrderDetail orderDetail=OrderDetail.builder()
                    .order(order)
                    .quantity(product.getQuantity())
                    .product(productRepository.getById(product.getId()))
                    .build();
            orderDetailRepository.save(orderDetail);
        }
       return order;

    }
}

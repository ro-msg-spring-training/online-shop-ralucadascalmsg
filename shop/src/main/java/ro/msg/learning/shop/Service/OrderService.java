package ro.msg.learning.shop.Service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Model.DTO.GoodOrderDTO;
import ro.msg.learning.shop.Model.DTO.OrderDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;
import ro.msg.learning.shop.Model.Entities.*;
import ro.msg.learning.shop.Repositories.OrderDetailRepository;
import ro.msg.learning.shop.Repositories.OrderRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Service.Strategy.MostAbundant;
import ro.msg.learning.shop.Service.Strategy.SingleLocation;
import ro.msg.learning.shop.Service.Strategy.StrategyInterface;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class OrderService {
  @Autowired
  OrderDetailRepository orderDetailRepository;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  StrategyInterface strategyInterface;
  @Autowired
  StockRepository stockRepository;
  @Autowired
  ProductRepository productRepository;
    public Stock findByLocProd(String loc, String prod)
    {
        Collection <Stock> stocks = stockRepository.findAll();
        for (Stock s:stocks)
        {
            if (s.getProduct().getName()==prod && s.getLocation().getName()==loc)
            {
                return s;
            }
        }
      return null;
     }

    public Order createOrder(OrderDTO orderDTO) {
       Collection<GoodOrderDTO> orderedList = strategyInterface.OrderLocation(orderDTO.getOrderedProducts());
       for (GoodOrderDTO orderedP: orderedList)
       {
           Stock s= findByLocProd(orderedP.getNameLocation(),orderedP.getNameLocation());
           int newStock=s.getQuantity()-orderedP.getQuantity();
           s.setQuantity(newStock);
           stockRepository.save(s);
       }

        Order o= new Order();
        o.setCreatedAt(orderDTO.getCreatedAt());
        o.setAddressCity(orderDTO.getAddressCity());
        o.setAddressCountry(orderDTO.getAddressCountry());
        o.setAddressCounty(orderDTO.getAddressCounty());
        o.setCustomer(null);
        o.setAddressStreetAddress(orderDTO.getAddressStreetAddress());
        o.setShippedForm(null);
        orderRepository.save(o);
        OrderDetail od= new OrderDetail();
        od.setOrder(o);
        Collection <OrderedProductDTO> or = orderDTO.getOrderedProducts();
        for (OrderedProductDTO prod:or)
        {
            od.setQuantity(prod.getQuantity());
            od.setProduct(productRepository.getById(prod.getId()));
            orderDetailRepository.save(od);
        }
       return o;

    }
}

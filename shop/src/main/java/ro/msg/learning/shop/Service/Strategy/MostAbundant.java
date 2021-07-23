package ro.msg.learning.shop.Service.Strategy;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.Model.DTO.OrderResponseDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Model.Entities.Stock;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Repositories.StockRepository;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
public class MostAbundant implements StrategyInterface {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProductRepository productRepository;

    public Collection<OrderResponseDTO> OrderLocation (Collection<OrderedProductDTO> orderedProducts) {
      Collection <Stock> stocks = stockRepository.findAll();
      Collection <Product> products = productRepository.findAll();
      Collection <OrderResponseDTO> goods= new ArrayList<OrderResponseDTO>();
      Product goodProduct= new Product();
      Stock goodStock=new Stock();
      int goodQuantity = 0;
      
      // Voi incerca cu metodele predefinite
      for (OrderedProductDTO p: orderedProducts)
      {
          for (Product pr:products)
          {
              if(pr.getId()==p.getId())
              {
                  goodProduct=pr;
              }
          }
          int max=0;
          for(Stock s: stocks)
          {
            if (p.getId()==s.getProduct().getId() && p.getQuantity()<=s.getQuantity())
            {
                if (max<s.getQuantity())
                {
                   max=s.getQuantity();
                   goodStock=s;
                   goodQuantity=p.getQuantity();
                }
            }
          }
          OrderResponseDTO dto = new OrderResponseDTO();
          dto.setNameProduct(goodProduct.getName());
          dto.setQuantity(goodQuantity);
          dto.setNameLocation(goodStock.getLocation().getName());
          goods.add(dto);
      }

      if ( goods.size() != orderedProducts.size())
      {
          throw new RuntimeException("Insufficient stock");
      }
      return goods;
    }

}

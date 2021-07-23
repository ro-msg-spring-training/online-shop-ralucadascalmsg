package ro.msg.learning.shop.Service.Strategy;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.Model.DTO.OrderResponseDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;
import ro.msg.learning.shop.Model.Entities.Location;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Model.Entities.Stock;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Repositories.StockRepository;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
public class SingleLocation implements StrategyInterface {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    LocationRepository locationRepository;

    public Collection<OrderResponseDTO> OrderLocation (Collection<OrderedProductDTO> orderedProducts) {
        Collection<Stock> stocks = stockRepository.findAll();
        Collection<Stock> stocksAux = new ArrayList<Stock>();
        Collection<Product> products = productRepository.findAll();
        Collection<Location> locations = locationRepository.findAll();
        Collection<OrderResponseDTO> goods = new ArrayList<OrderResponseDTO>();
        Product goodProduct = new Product();

        for (Location l: locations)
        {
            stocksAux.removeAll(stocksAux);
            int f=0;
            for (Stock s : stocks)
            {
                if (s.getLocation().getName()==l.getName())
                {
                    stocksAux.add(s);
                }
            }
                for (OrderedProductDTO p : orderedProducts) {
                    for (Stock s:stocksAux) {
                     if (p.getId() != s.getProduct().getId() || p.getQuantity() > s.getQuantity()) {
                        f++;
                    }
                }
            }

            if (f == orderedProducts.size()) {
                for (OrderedProductDTO p : orderedProducts) {
                    for (Product pr : products) {
                        if (pr.getId() == p.getId()) {
                            goodProduct = pr;
                        }
                    }
                    OrderResponseDTO dto = new OrderResponseDTO();
                    dto.setNameProduct(goodProduct.getName());
                    dto.setQuantity(p.getQuantity());
                    dto.setNameLocation(l.getName());
                    goods.add(dto);
                }
            }
        }

        if (goods.isEmpty())
        {
            throw new RuntimeException("Insufficient stock");
        }
        return goods;
    }

}

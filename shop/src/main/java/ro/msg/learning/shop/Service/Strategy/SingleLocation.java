package ro.msg.learning.shop.Service.Strategy;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.Model.DTO.GoodOrderDTO;
import ro.msg.learning.shop.Model.DTO.OrderedProductDTO;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Model.Entities.Stock;
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

    public Collection<GoodOrderDTO> OrderLocation (Collection<OrderedProductDTO> orderedProducts) {
        Collection<Stock> stocks = stockRepository.findAll();
        Collection<Product> products = productRepository.findAll();
        Collection<GoodOrderDTO> goods = new ArrayList<GoodOrderDTO>();
        Product goodProduct = new Product();

        for (Stock s : stocks) {
            boolean suf = true;
            for (OrderedProductDTO p : orderedProducts) {
                if (p.getId() != s.getProduct().getId() || p.getQuantity() > s.getQuantity()) {
                    suf = false;
                }
            }
            if (suf == true) {
                for (OrderedProductDTO p : orderedProducts) {
                    for (Product pr : products) {
                        if (pr.getId() == p.getId()) {
                            goodProduct = pr;
                        }
                    }
                    GoodOrderDTO dto = new GoodOrderDTO();
                    dto.setNameProduct(goodProduct.getName());
                    dto.setPrice(goodProduct.getPrice());
                    dto.setQuantity(p.getQuantity());
                    dto.setNameLocation(s.getLocation().getName());
                    goods.add(dto);
                }
            }
        }
        if ( goods.isEmpty())
        {
            throw new RuntimeException("Insufficient stock");
        }
        return goods;
    }

}

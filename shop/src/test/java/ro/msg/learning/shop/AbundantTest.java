package ro.msg.learning.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.dto.OrderResponseDTO;
import ro.msg.learning.shop.dto.OrderedProductDTO;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.service.strategy.MostAbundant;

import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AbundantTest {
    @Mock
    StockRepository stockRepository;
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    private MostAbundant mostAbundantStrategy;

    private Product p1,p2;
    private Location l1,l2;
    private Stock s11,s12,s21,s22;

    @BeforeEach
    void initial(){
        p1=Product.builder()
                .id(1)
                .name("p1")
                .build();
        p2=Product.builder()
                .id(2)
                .name("p2")
                .build();

        l1=Location.builder()
                .id(1)
                .name("nume1")
                .build();
        l2=Location.builder()
                .id(2)
                .name("nume2")
                .build();

        s11=Stock.builder().id(1)
                .product(p1)
                .location(l1)
                .quantity(10)
                .build();
        s12=Stock.builder()
                .id(2).product(p1)
                .location(l2)
                .quantity(8)
                .build();
        s21=Stock.builder()
                .id(3)
                .product(p2)
                .location(l1)
                .quantity(5)
                .build();
        s22=Stock.builder()
                .id(4)
                .product(p2)
                .location(l2)
                .quantity(20)
                .build();

        Mockito.when(stockRepository.findAll()).thenReturn(
                List.of(s11, s12, s21, s22));
        Mockito.when(productRepository.findAll()).thenReturn(
                List.of(p1, p2));
    }

    @Test
    void outOfStock() {
        s11.setQuantity(0);
        s12.setQuantity(0);
        s21.setQuantity(0);
        s22.setQuantity(0);
        Collection<OrderedProductDTO> orderDetails = List.of(
                OrderedProductDTO.builder()
                        .id(1)
                        .quantity(10)
                        .build(),
                OrderedProductDTO.builder()
                        .id(2)
                        .quantity(3)
                        .build());

        Assertions.assertThrows(
                RuntimeException.class,
                () -> mostAbundantStrategy.OrderLocation(orderDetails)
        );
    }

    @Test
    void inStock() {
        s11.setQuantity(78);
        s12.setQuantity(123);
        s21.setQuantity(85);
        s22.setQuantity(65);
        Collection<OrderedProductDTO> orderDetails = List.of(
                OrderedProductDTO.builder()
                        .id(1)
                        .quantity(8)
                        .build(),
                OrderedProductDTO.builder()
                        .id(2)
                        .quantity(3)
                        .build());

        Assertions.assertEquals(
                List.of(
                        OrderResponseDTO.builder()
                                .nameProduct(p1.getName())
                                .nameLocation(l2.getName())
                                .quantity(8)
                                .build(),
                        OrderResponseDTO.builder()
                                .nameProduct(p2.getName())
                                .nameLocation(l1.getName())
                                .quantity(3)
                                .build()),
                mostAbundantStrategy.OrderLocation(orderDetails));

    }
}

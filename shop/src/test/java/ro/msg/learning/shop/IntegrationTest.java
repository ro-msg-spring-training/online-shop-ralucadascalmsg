package ro.msg.learning.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.Repositories.OrderRepository;
import ro.msg.learning.shop.Service.OrderService;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
public class IntegrationTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @Test
    public void testOrderCreate() throws Exception {
    }
}

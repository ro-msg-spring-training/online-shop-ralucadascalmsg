package ro.msg.learning.shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.Model.Entities.Customer;
import ro.msg.learning.shop.Repositories.CustomerRepository;

public class UserDetailService {
    @Autowired
    CustomerRepository customerRepository;
}

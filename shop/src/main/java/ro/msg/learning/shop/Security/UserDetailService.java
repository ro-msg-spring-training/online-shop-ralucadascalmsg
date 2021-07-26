package ro.msg.learning.shop.security;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.repositories.CustomerRepository;

import java.util.Collection;

@Service
public class UserDetailService  {
  private CustomerRepository customerRepository;

  public Collection<Customer> getAllCustomers() {
    Collection <Customer> customers = customerRepository.findAll();
    return customers;
  }
}

package ro.msg.learning.shop.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Model.DTO.ProductDTO;
import ro.msg.learning.shop.Model.Entities.Customer;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Repositories.CustomerRepository;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailService  {
  private CustomerRepository customerRepository;

  public Collection<Customer> getAllCustomers() {
    Collection <Customer> customers = customerRepository.findAll();
    return customers;
  }
}

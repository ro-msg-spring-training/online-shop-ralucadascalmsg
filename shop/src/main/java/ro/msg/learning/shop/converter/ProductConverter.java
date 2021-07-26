package ro.msg.learning.shop.converter;


import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.OrderResponseDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;

import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor
public class ProductConverter {

  public Product dtoToModel(OrderResponseDTO orderResponseDTO){
        Product product =Product
                .builder()
                .name(orderResponseDTO.getNameProduct())
                .build();
        return product;
    }

  public ProductDTO modelToDto(Product product)
  {
      ProductDTO dto=ProductDTO.builder()
              .name(product.getName())
              .description(product.getDescription())
              .price(product.getPrice())
              .weight(product.getWeight())
              .category_id(product.getCategory().getId())
              .supplier_id(product.getSupplier().getId())
              .category(product.getCategory().getName())
              .supplier(product.getSupplier().getName())
              .imageUrl(product.getImageUrl())
              .descriptionCategory(product.getCategory().getDescription())
              .build();
      return dto;
  }

  public Collection<ProductDTO> converterMapper(Collection<Product> products)
  {
      return products.stream().map(
              (p)-> modelToDto(p)).collect(Collectors.toList());
   }

}

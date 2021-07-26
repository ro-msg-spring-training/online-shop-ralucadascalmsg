package ro.msg.learning.shop.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.service.strategy.MostAbundant;
import ro.msg.learning.shop.service.strategy.SingleLocation;
import ro.msg.learning.shop.service.strategy.StrategyInterface;

@Configuration
public class StrategySelection {

    @Bean
    public StrategyInterface SelectedStrategy(){
        SingleLocation singleLocation=new SingleLocation();
        MostAbundant mostAbundant=new MostAbundant();
          return singleLocation;
     //   return mostAbundant;
    }
}

package ro.msg.learning.shop.Service;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.Service.Strategy.MostAbundant;
import ro.msg.learning.shop.Service.Strategy.SingleLocation;
import ro.msg.learning.shop.Service.Strategy.StrategyInterface;

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

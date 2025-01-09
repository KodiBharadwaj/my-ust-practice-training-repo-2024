package com.shoppingcart.app.configuration;

import com.shoppingcart.app.repository.ShoppingCartRepository;
import com.shoppingcart.app.repository.ShoppingCartRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.shoppingcart.app")
public class productConfig {
}

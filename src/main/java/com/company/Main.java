package com.company;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

// https://github.com/maxanarki2/SpringShellTest

@SpringBootApplication(
//		exclude={DataSourceAutoConfiguration.class}
)
@PropertySource("classpath:local.properties")
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    public static void main(String[] args) {
        log.info("main: ----------------------------");
//        try {
            SpringApplication.run(Main.class, args);
//        } catch (IllegalStateException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
        log.info("main: ===========================!");
    }
}

//    List all products, which have been ordered at least once, with total ordered
//                     quantity sorted descending by the quantity
//select product_id, p.name, sum(quantity) as qq
//                            from order_items
//                            join product p on p.id = order_items.product_id
//                            group by product_id
//                            order by qq DESC;



//    | Order ID | Products total Price | Product Name | Products Quantity in orderEntry
//            | Order Created Date [YYYY-MM-DD HH:MM ] | by order Id
//select order_id, DATE_FORMAT(o.created_at, "%Y-%m-%d %H:%i"), count(product_id), sum(p.price*oi.quantity), sum(quantity)
//                                    from order_items oi
//                                    join product p on p.id = oi.product_id
//                                    join order1 o on o.id = oi.order_id
//                                    group by order_id
//                                    order by order_id;


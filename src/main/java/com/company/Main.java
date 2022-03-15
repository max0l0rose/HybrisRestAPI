package com.company;

import com.company.model.Order1;
import com.company.model.OrderItems;
import com.company.model.ProdStatus;
import com.company.model.Product;
import com.company.repo.OrdersRepo;
import com.company.repo.ProdRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

// https://github.com/maxanarki2/SpringShellTest

@SpringBootApplication(
//		exclude={DataSourceAutoConfiguration.class}
)
@PropertySource("classpath:local.properties")
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


//    @Autowired
//    private EntityManager entityManager;
//
//    @PersistenceUnit
//    EntityManagerFactory entityManFactory;


//
//	@Bean
//	@Transactional(
//			//propagation = Propagation.REQUIRED,
//			//isolation = Isolation.READ_UNCOMMITTED
//	)
//	public boolean demo1(//ProdRepo prodRepo,
//	                     OrdersRepo ordersRepo
//			//, EntityManager entityManager
//	) {
//		//return (args) ->
//		//{
//		log.info("demo1: ");
//
//		//ordersService.getOrdersRepo().flush();
//
//		Product prod1 = new Product("ProdA", 100, ProdStatus.IN_STOCK);
//		Product prod2 = new Product("ProdB", 200, ProdStatus.IN_STOCK);
//
//		Order1 order = new Order1(ProdStatus.IN_STOCK);
//		//ordersRepo.save(order);
//		Order1 order2 = new Order1(ProdStatus.IN_STOCK);
//		//ordersRepo.save(order2);
//
//		order.addProduct(prod1, 10);
//		order.addProduct(prod1, 11);
//
//		order.addProduct(prod2, 20);
//		order.addProduct(prod2, 22);
//		order.addProduct(new Product("ProdC", 30, ProdStatus.RUNNING_LOW), 33);
//		ordersRepo.save(order);
//		order2.addProduct(prod2, 50);
//		ordersRepo.save(order2);
////		OrderItems orderItems = new OrderItems(prod1, order, 10);
////		entityManager.persist(orderItems);
////		OrderItems orderItems2 = new OrderItems(prod2, order, 20);
////		entityManager.persist(orderItems2);
//
//		ordersRepo.save(new Order1());
//		//ordersService.getOrdersRepo().flush();
//
////		OrderItems orderItems21 = new OrderItems(prod2, order2, 50);
////		entityManager.persist(orderItems21);
//
//		log.info("demo1: Ok");
//		return true;
//	}
//
//
//	//CommandLineRunner
//	@Bean
//	@Transactional
//	public boolean demo2(ProdRepo prodRepo
//	                     //OrdersService ordersService
//			, EntityManager entityManager
//	) {
//		//return (args) ->
//		//{
//		log.info("demo2: ");
//
////        select o, ps.size, SUM(ps.quantity), SUM (p.price)
////        from Order o
////        join o.products1 ps
////        join Product p on p.id = ps.product_id
////        group by o.id
//
//		//prodRepo.deleteById(1L);
//
//		log.info("demo2: Ok");
//		//};
//		return  true;
//	}



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


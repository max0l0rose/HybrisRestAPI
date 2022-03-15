package com.company.controller;

import com.company.model.Order1;
import com.company.model.ProdStatus;
import com.company.model.Product;
import com.company.repo.OrderItemsRepo;
import com.company.repo.OrdersRepo;
import com.company.repo.ProdRepo;
import com.company.services.OrdersService;
import com.company.services.ProductService;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
//@RequestMapping("/orders")
public class OrdersController {
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private OrdersRepo ordersRepo;

//	@Autowired
//	OrdersService ordersService;
//
//	@Autowired
//	OrderItemsRepo orderItemsRepo;
//
//	@Autowired
//	private ProdRepo prodRepo;
//
//	@Autowired
//	private ProductService productService;

//	@Autowired
//	ProductsController productsController;

//	interface MyEntry extends Map.Entry<Long, Integer> {
//	}


	//@RestResource(rel = "qqq-contains", path="qqq-contains")
	@GetMapping(value = "/qqq")
	public ResponseEntity<Page<Order1>> qqq(Pageable pageable) {
		Page<Order1> page = ordersRepo.findAll(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@GetMapping(value = "/first")
	public ResponseEntity<Order1> first() {
		ordersRepo.findById(0L).ifPresent(c -> {
			ResponseEntity.status(HttpStatus.OK).body(c);
			return;
		});
	}

	//	Map<Long, Integer> extractIdsAndQuantity(String idsAndQuantity)
//	{
//		Pattern sIdsAndQuantityArrPattern = Pattern.compile("(\\d+)[-\\s]*(\\d+)*"); // example: "1-10 2-20 3 30, 4-40 fghfgh 5 ----  50"
//		Matcher matcher = sIdsAndQuantityArrPattern.matcher(idsAndQuantity);
//
//		//ist<Product> productList = new ArrayList<>();
//
//		Order1 order = new Order1(ProdStatus.IN_STOCK);
//		ordersRepo.save(order);
//
//
//		Map<Long, Integer> map = new HashMap<>();
//
//		while(matcher.find()) //for(String sIdAndQ : sIdsAndQuantity)
//		{
//			String sId = matcher.group(1);
//			String sQ = matcher.group(2);
//			long productId = Long.valueOf(sId);
//			int quantity = Integer.valueOf(sQ);
//			map.put(productId, quantity);
//		}
//
//		return map;
//	}


//	@ShellMethod(key = {"addProdsToOrder", "addptoo", "apto"}, value = "Add existing products to existing order.")
//	@Transactional
//	public String commandAddProdsToExistingOrder(
//			long oId,
////			@Size(min = 5, max = 40)
//			@ShellOption(defaultValue = "") //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String idsAndQuantity
////			@ShellOption()
////					String text2
//	) {
//		Order1 order = ordersRepo.findById(oId).get();
//
//		Map<Long, Integer> map = extractIdsAndQuantity(idsAndQuantity);
//
//		//Map.Entry<Long, Integer> entry
//		StringBuilder render = new StringBuilder();
//		map.forEach((productId, quantity) -> {
//			Product product = prodRepo.findById(productId).get();//.orElseThrow( () -> new IllegalArgumentException() );
//			order.addProduct(product, quantity);
//			render.append("productId=" + productId + ", quantity=" + quantity + "; ");
//		});
//
//		Model model = new ExtendedModelMap();
//		//Helper.getPage(model, session, ordersService, 0, "id", "");
//
//		model.addAttribute("caption", "Adding a new order " + order.getId());
//		model.addAttribute("body", render.toString());
//
//		String renderResult = IView.render(model);
//
////		Iterable<Product> products = prodRepo.findAll();
////		model.addAttribute("list", order.getOrderItems());
//
//		//order = null;
//		ordersService.detach(order);
//		return renderResult + productsController.commandProductsByOrderId(order.getId());
//	}



//	@ShellMethod(key = {"addOrder", "addo", "ao"}, value = "Add an order with array of product ids...")
//	@Transactional
//	public String commandAddOrder(
////			@Size(min = 5, max = 40)
//			@ShellOption(defaultValue = "") //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String idsAndQuantity
////			@ShellOption()
////					String text2
//	) {
//		Pattern sIdsAndQuantityArrPattern = Pattern.compile("(\\d+)[-\\s]*(\\d+)*"); // example: "1-10 2-20 3 30, 4-40 fghfgh 5 ----  50"
//		Matcher matcher = sIdsAndQuantityArrPattern.matcher(idsAndQuantity);
//
//		//ist<Product> productList = new ArrayList<>();
//
//		Order1 order = new Order1(ProdStatus.IN_STOCK);
//		ordersRepo.save(order);
//
//
//		String render = "";
//		while(matcher.find()) //for(String sIdAndQ : sIdsAndQuantity)
//		{
//			String sId = matcher.group(1);
//			String sQ = matcher.group(2);
//			render += "productId=";
//			long productId = Long.valueOf(sId);
//			render += productId + ", " + "quantity=";
//			int quantity = Integer.valueOf(sQ);
//			render += quantity + "; ";
////			OrderItems orderItems = new OrderItems(productId, order.getId(), quantity);
////			orderItemsRepo.save(orderItems);
//
//			Product product = prodRepo.findById(productId).get();//.orElseThrow( () -> new IllegalArgumentException() );
//			order.addProduct(product, quantity);
//		}
//		//ender += System.lineSeparator();
//
//		Model model = new ExtendedModelMap();
//		//Helper.getPage(model, session, ordersService, 0, "id", "");
//
//		model.addAttribute("caption", "Adding a new order " + order.getId());
//		model.addAttribute("body", render);
//
//		String renderResult = IView.render(model);
//
////		Iterable<Product> products = prodRepo.findAll();
////		model.addAttribute("list", order.getOrderItems());
//
//		return renderResult + productsController.commandProductsByOrderId(order.getId());
//	}




//	@ShellMethod(key = {"Orders", "os"}, value = "Show all orders with the sum of the prices of all " +
//			                                             "relevant products and their quantity.")
//	public String commandOrders(
////			@Size(min = 5, max = 40)
////			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
////					String text,
////			@ShellOption()
////					String text2
//	) {
//		Model model = new ExtendedModelMap();
//		//Helper.getPage(model, session, ordersService, 0, "id", "");
//
//		model.addAttribute("caption", "Orders:");
//
//		List<OrdersFindAllView> items = ordersRepo.getAllOrdersView();
//		model.addAttribute("list", items);
//
//		return OrdersFindAllView.render(model);
//	}

}

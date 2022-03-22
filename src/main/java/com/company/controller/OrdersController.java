package com.company.controller;

import com.company.dto.addProdsToOrderDto;
import com.company.model.Order1;
import com.company.model.Product;
import com.company.repo.OrdersRepo;
import com.company.repo.ProductsRepo;
import com.company.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersController extends BaseController<Order1, OrdersRepo> {
	//private final Map<String,Object> session = new HashMap<>();

//	@Autowired
//	private OrdersRepo ordersRepo;


	public OrdersController(OrdersRepo ordersRepo, ProductsRepo productsRepo) {
		super(ordersRepo);
		this.productsRepo = productsRepo;
	}

	final ProductsRepo productsRepo;

//	interface MyEntry extends Map.Entry<Long, Integer> {
//	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<OrderProj2> firstorder(@PathVariable long id) {
//		Optional<OrderProj2> optional = ordersRepo.findById(id, OrderProj2.class);
//		if (optional.isPresent())
//			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	}
//
//
//	//@RestResource(rel = "qqq-contains", path="qqq-contains")
//	@GetMapping(value = "/page")
//	public ResponseEntity<Page<?>> page(Pageable pageable) {
//		Page<?> page = ordersRepo.findAllProjectedBy(pageable, OrderProj2.class);
//		return ResponseEntity.status(HttpStatus.OK).body(page);
//	}
//


	//@Transactional
	@PostMapping(value = "/addProdToOrder/{oid}")
	@JsonView(value = View.UserView.Internal.class)
	public Order1 addProdToOrder(
			@PathVariable long oid, @RequestParam long pid, @RequestParam int quantity
	) {
		Order1 order = getByIdInt(oid);
		Product product = productsRepo.getById(pid);
		order.addProduct(product, quantity);
		return repo.save(order);
	}


	//@Transactional
	@PostMapping(value = "/addProdsToOrder/{oid}")
	@JsonView(value = View.UserView.Internal.class)
	public Order1 addProdsToOrder(
			@PathVariable long oid, @RequestBody addProdsToOrderDto prods
	) {
		Order1 order = getByIdInt(oid);
		long[] prodIds = prods.getProdIds();
		int[] quantities = prods.getProdQuants();
		for (int i = prodIds.length-1; i>=0; i--) {
			Product product = productsRepo.getById(prodIds[i]);
			order.addProduct(product, quantities[i]);
		}
		return repo.save(order);
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



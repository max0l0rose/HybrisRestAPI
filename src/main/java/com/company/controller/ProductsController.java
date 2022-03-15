//package com.company.controller;
//
//import com.company.model.ProdStatus;
//import com.company.model.Product;
//import com.company.repo.ProdRepo;
//import com.company.view.ProductsByOrderView;
//import com.company.view.ProductsFindAllView;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellOption;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.ExtendedModelMap;
//import org.springframework.ui.Model;
//
//@ShellComponent()
//public class ProductsController
//		//extends SecuredCommand
//{
//	//private final Map<String,Object> session = new HashMap<>();
//
////	@Autowired
////	private ProductService productService;
//
//	//@Autowired
//	private ProdRepo prodRepo;
//
//	public ProductsController(ProdRepo pRepo) {
//		prodRepo = pRepo;
//	}
//
//
//
//	@ShellMethod(key = {"addProduct", "addp", "ap"}, value = "Add/Create product..")
//	public String commandAddProduct(
//			//@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//			String name,
//			@ShellOption(defaultValue = "0")
//			int price,
//			@ShellOption(defaultValue = "IN_STOCK")
//			String status
//	)
//	{
//		ProdStatus prodStatus;
//		try {
//			prodStatus = ProdStatus.valueOf(status);
//		} catch (IllegalArgumentException ex) {
//			int iStatus = Integer.valueOf(status);
//			prodStatus = ProdStatus.fromId(iStatus);
//		}
//
//		Model model = new ExtendedModelMap();
//
//		model.addAttribute("caption", "Add a Product:");
//
//		Product product = new Product(name, price, prodStatus);
//
//		model.addAttribute("body",
//				//name + ", proce = " + price + ", status" + status.toString()
//				product.toString()
//		);
//
//		prodRepo.save(product);
//
//		return ProductsFindAllView.render(model);
//	}
//
//
//    //TODO
//	@ShellMethod(key = {"productsByOrderId", "prodsByOId", "pbo"}, value = "Show products by order id.")
//	@Transactional
//	public String commandProductsByOrderId(
//			//@Size(min = 5, max = 40)
//			@ShellOption(defaultValue = "0") //arity = 3, defaultValue = "deffffff",  help = "Possi"
//			long oid
//	)
//	{
//		if (oid == 0)
//			return commandProducts();
//
//		Model model = new ExtendedModelMap();
//
//		model.addAttribute("caption", "Products of Order: " + oid);
//
//		Iterable<ProductsByOrderView> products = prodRepo.findProductsByOrderId(oid);
//		model.addAttribute("list", products);
//
//		return ProductsByOrderView.render(model);
//	}
//
//
//
//	@ShellMethod(key = {"products", "prods", "ps", "pl"}, value = "Show all products.")
//	public String commandProducts () {
////		List<User> ulist = new ArrayList<User>() {{
////				add(new User("User1", new Department("Dep1"), Role.USER));
////				add(new User("User2", new Department("Dep1"), Role.USER));
////				add(new User("UserAdmin", new Department("Dep2"), Role.ADMIN));
////		}};
////
////		Object[][] uarr = ulist.stream()
////				.map(u -> u.toStringsArray() )
////				.toArray(size -> new Object[size][]);
////
////		//StringsArray sa = u;os
////		//sampleData[1] = u.toStringsArray();
//
//		Model model = new ExtendedModelMap();
//		//Helper.getPage(model, session, userService, 0, "id", "");
//
//		model.addAttribute("caption", "Products:");
//
//		Iterable<Product> products = prodRepo.findAll();
//		model.addAttribute("list", products);
//
//		return ProductsFindAllView.render(model);
//	}
//
//}

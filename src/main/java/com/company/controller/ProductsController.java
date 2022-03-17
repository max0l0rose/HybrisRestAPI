package com.company.controller;

import com.company.dto.ProdDto1;
import com.company.dto.ProdProj1;
import com.company.model.Product;
import com.company.repo.ProductsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@ShellComponent()
@RestController
@RequestMapping("/products")
public class ProductsController
		//extends SecuredCommand
{
	//private final Map<String,Object> session = new HashMap<>();

//	@Autowired
//	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

	//@Autowired
	private ProductsRepo productsRepo;

	public ProductsController(ProductsRepo pRepo) {
		productsRepo = pRepo;
	}



	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdDto1> byid(@PathVariable long id) {
		Optional<ProdDto1> optional = productsRepo.findById(id, ProdDto1.class);
		if (optional.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}


	@PostMapping()
	public ResponseEntity<ProdDto1> save(@RequestBody Product product) {
		Product pa = productsRepo.save(product);
		ProdDto1 p2 = modelMapper.map(pa, ProdDto1.class);
		return ResponseEntity.status(HttpStatus.OK).body(p2);
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}


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
//		ProductsRepo.save(product);
//
//		return ProductsFindAllView.render(model);
//	}


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
//		Iterable<ProductsByOrderView> products = ProductsRepo.findProductsByOrderId(oid);
//		model.addAttribute("list", products);
//
//		return ProductsByOrderView.render(model);
//	}



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
//		Iterable<Product> products = ProductsRepo.findAll();
//		model.addAttribute("list", products);
//
//		return ProductsFindAllView.render(model);
//	}

}

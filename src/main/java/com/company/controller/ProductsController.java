package com.company.controller;

import com.company.dto.ProductNamePriceDto;
import com.company.dto.ProductsByOrderView;
import com.company.dto.TestView;
import com.company.model.Product;
import com.company.repo.ProductsRepo;
import com.company.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//@ShellComponent()
@RestController
@RequestMapping("/products")
@Validated
public class ProductsController
		//extends SecuredCommand
{
//	@Autowired
//	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

	//@Autowired
	private ProductsRepo productsRepo;

	public ProductsController(ProductsRepo pRepo) {
		productsRepo = pRepo;
	}



	@GetMapping(value = "/{id}/dto")
	public ResponseEntity<ProductNamePriceDto> getByIdDto(@PathVariable long id) {
		Optional<ProductNamePriceDto> optional = productsRepo.findById(id,
												ProductNamePriceDto.class); // it is better for SQL
		if (optional.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}


	@GetMapping(value = "/{id}")
	@JsonView(value = View.UserView.External.class)
	public ResponseEntity<Product> getById(@PathVariable long id) {
		Optional<Product> optional = productsRepo.findById(id); // gets full object
		if (optional.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping(value = "/{id}/int")
	@JsonView(value = View.UserView.Internal.class)
	public ResponseEntity<Product> getByIdInt(@PathVariable long id) {
		Optional<Product> optional = productsRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}


	// cool. select after insert doesnt happen!
	@PostMapping()
	@JsonView(value = View.UserView.Post.class)
	public ResponseEntity<Product> save(
			final @Valid @RequestBody @JsonView(value = View.UserView.Post.class) Product prod,
			BindingResult result
	) {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<Product>> violations = validator.validate(prod);

		Product pa = null;
		//try {
			pa = productsRepo.save(prod);
			return ResponseEntity.status(HttpStatus.OK).body(pa);
		//} catch (DataIntegrityViolationException e) {
		//	e.printStackTrace();
		//}

//		Provider<ProductNamePriceDto> provider = p -> new ProductNamePriceDto(null, 0);
//		TypeMap<Product, ProductNamePriceDto> propertyMapper = modelMapper.createTypeMap(Product.class, ProductNamePriceDto.class);
//		propertyMapper.setProvider(provider);
//		ProductNamePriceDto p2 = modelMapper.map(pa, ProductNamePriceDto.class);

		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}


//	// w/o this - 500
//	@ExceptionHandler(ConstraintViolationException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
//		return new ResponseEntity<>("Nnnot valid: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//	}


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

//	@Transactional
	@GetMapping(value = "/ProductsByOrder/{oid}")
//	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<ProductsByOrderView> productsByOrderId(@PathVariable long oid) {
//		if (oid == 0)
//			return commandProducts();
		List<ProductsByOrderView> products = productsRepo.findProductsByOrderId(oid);
		return products;
	}


//	@GetMapping(value = "/test")
//	public ResponseEntity<List<TestView>> test() {
//		List<TestView> l = productsRepo.test();
//		return ResponseEntity.status(HttpStatus.OK).body(l);
//	}


	@GetMapping()
	@JsonView(value = View.UserView.External.class)
	public List<Product> products(Pageable pageable) {
		Page<Product> products = productsRepo.findAll(pageable);
		return products.getContent();
	}

}

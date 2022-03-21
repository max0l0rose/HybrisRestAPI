package com.company.controller;

import com.company.dto.ProductNamePriceDto;
import com.company.dto.ProductsByOrderView;
import com.company.dto.TestView;
import com.company.model.Product;
import com.company.repo.ProductsRepo;
import com.company.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

//@ShellComponent()
@RestController
@RequestMapping("/products")
@Validated
public class ProductsController extends BaseController<Product, ProductsRepo>
		//extends SecuredCommand
{
//	@Autowired
//	private ProductService productService;

//	@Autowired
//	private ModelMapper modelMapper;

	public ProductsController(ProductsRepo productsRepo) {
		super(productsRepo);
	}


//	@GetMapping(value = "/{id}/dto")
//	public ResponseEntity<ProductNamePriceDto> getByIdDto(@PathVariable long id) {
//		Optional<ProductNamePriceDto> optional = productsRepo.findById(id,
//												ProductNamePriceDto.class); // it is better for SQL
//		if (optional.isPresent())
//			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	}


//	@Transactional
	@GetMapping(value = "/ProductsByOrder/{oid}")
//	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<ProductsByOrderView> productsByOrderId(@PathVariable long oid, Pageable pageable) {
//		if (oid == 0)
//			return commandProducts();
		List<ProductsByOrderView> products = repo.findProductsByOrderId(oid, pageable);
		return products;
	}


//	@GetMapping(value = "/test")
//	public ResponseEntity<List<TestView>> test() {
//		List<TestView> l = productsRepo.test();
//		return ResponseEntity.status(HttpStatus.OK).body(l);
//	}


}

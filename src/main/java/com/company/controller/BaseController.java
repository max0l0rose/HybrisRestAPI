package com.company.controller;

import com.company.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Validated
@RequiredArgsConstructor
public class BaseController<T, Repo extends JpaRepository<T, Long>>
		//extends SecuredCommand
{
//	@Autowired
//	private ModelMapper modelMapper;

	//@Autowired
	protected Repo repo;

//	public BaseController(Repo pRepo) {
//		repo = pRepo;
//	}

	@GetMapping(value = "/{id}/int")
	@JsonView(value = View.UserView.Internal.class)
	public T getByIdInt(@PathVariable long id) {
		T o = repo.findById(id).orElseThrow(() -> new NoSuchElementException());
		//if (optional.isPresent())
		return o;
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}


	@GetMapping(value = "/{id}")
	@JsonView(value = View.UserView.External.class)
	public T getByIdIntExt(@PathVariable long id) {
		T o = repo.findById(id).orElseThrow(() -> new NoSuchElementException());
		return o;
	}


	// cool. select after insert doesnt happen!
	@PostMapping()
	@JsonView(value = View.UserView.Post.class)
	public T save(
			final @Valid @RequestBody @JsonView(value = View.UserView.Post.class) T o
			//,BindingResult result
	) {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<Product>> violations = validator.validate(prod);

		T pa = null;
		//try {
			pa = repo.save(o);
			return pa;
		//} catch (DataIntegrityViolationException e) {
		//	e.printStackTrace();
		//}

//		Provider<ProductNamePriceDto> provider = p -> new ProductNamePriceDto(null, 0);
//		TypeMap<Product, ProductNamePriceDto> propertyMapper = modelMapper.createTypeMap(Product.class, ProductNamePriceDto.class);
//		propertyMapper.setProvider(provider);
//		ProductNamePriceDto p2 = modelMapper.map(pa, ProductNamePriceDto.class);

		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}


	@GetMapping()
	@JsonView(value = View.UserView.External.class)
	public List<T> findAll(Pageable pageable) {
		Page<T> page = repo.findAll(pageable);
		return page.getContent();
	}

}

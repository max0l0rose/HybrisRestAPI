package com.company.repo;

import com.company.dto.ProductsByOrderView;
import com.company.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

//@Lazy
//@RepositoryRestResource(
//		excerptProjection = ProdProj1.class
//)
public interface ProductsRepo extends //Repository<User, Long>
									//CrudRepository<Product, Long>
									JpaRepository<Product, Long>
{
	//Product findByName(String name);

	//List<Product> findByOrderItems_OrderId(long oId);

	<T> Optional<T> findById(long id, Class<T> tClass);
	<T> Page<T> findAllProjectedBy(Pageable pageable, Class<T> tClass);

	//@Override
	//<T> T save(T entity, Class<T> tClass);

	@Query("select p as product, oi.quantity as quantity from Product p join p.orderItems oi where oi.order.id = ?1")
	List<ProductsByOrderView> findProductsByOrderId(long oId);

	//User findById(long id);

//	@Query("select u from #{#entityName} u where u.lastname = ?1")
//	List<User> findByLastname(String lastname);


//	@Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",
//			countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
//			nativeQuery = true)
//	Page<User> findByLastname(String lastname, Pageable pageable);


//	@Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//	User findByLastnameOrFirstname(@Param("lastname") String lastname,
//	                               @Param("firstname") String firstname);


//	@Modifying
//	@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
//	int setFixedFirstnameFor(String firstname, String lastname);
}


//@MappedSuperclass
//public abstract class AbstractMappedType {
//  …
//	String attribute
//}
//
//@Entity
//public class ConcreteType extends AbstractMappedType { … }
//
//@NoRepositoryBean
//public interface MappedTypeRepository<T extends AbstractMappedType>
//		extends Repository<T, Long> {
//
//	@Query("select t from #{#entityName} t where t.attribute = ?1")
//	List<T> findAllByAttribute(String attribute);
//}
//
//public interface ConcreteRepository
//		extends MappedTypeRepository<ConcreteType> { … }
//


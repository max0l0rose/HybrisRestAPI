package com.company.repo;

import com.company.dto.OrderProj1;
import com.company.dto.OrderProj2;
import com.company.dto.OrdersFindAllView;
import com.company.model.Order1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
//import org.springframework.data.repository.PagingAndSortingRepository;


//@RepositoryRestResource(collectionResourceRel = "orders", path = "orders"//, exported = false
////		, excerptProjection = OrderProj1.class
//)
public interface OrdersRepo extends JpaRepository<Order1, Long> {
	//List<OrdersView> findById(String uname);
	<T> Optional<T> findById(long id, Class<T> tClass);

	<T> Page<T> findAllProjectedBy(Pageable pageable, Class<T> tClass);

	@Query("select o as order, size(o.orderItems) as prodsCount, SUM (p.price) as prodsTotalPrice, " +
			                            "SUM (oi.quantity) as prodsTotalQuantity " +
			       "from Order1 o " +
			       "left join o.orderItems oi " +
			       "left join oi.product p " +
			       "group by o.id")
	List<OrdersFindAllView> getAllOrdersView();
}



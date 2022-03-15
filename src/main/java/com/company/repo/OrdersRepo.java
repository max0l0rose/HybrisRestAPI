package com.company.repo;

import com.company.dto.OrdersFindAllView;
import com.company.model.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
//import org.springframework.data.repository.PagingAndSortingRepository;


@RepositoryRestResource(collectionResourceRel = "orders", path = "orders"//, exported = false
//		, excerptProjection = OrderProj1.class
)
public interface OrdersRepo extends
					JpaRepository<Order1, Long>
					//PagingAndSortingRepository<Order, Long>
{
	//List<OrdersView> findById(String uname);
	//Department findById(long id);

	@Query("select o as order, size(o.orderItems) as prodsCount, SUM (p.price) as prodsTotalPrice, " +
			                            "SUM (oi.quantity) as prodsTotalQuantity " +
			       "from Order1 o " +
			       "left join o.orderItems oi " +
			       "left join oi.product p " +
			       "group by o.id")
	List<OrdersFindAllView> getAllOrdersView();
}



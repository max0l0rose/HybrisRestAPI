package com.company.repo;

import com.company.model.OrderItems;
import com.company.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orderitems", path = "orderitems")
public interface OrderItemsRepo extends JpaRepository<OrderItems, Product> {
}


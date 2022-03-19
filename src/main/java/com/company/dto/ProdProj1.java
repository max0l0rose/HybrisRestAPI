package com.company.dto;

import com.company.model.OrderItems;
import lombok.Data;

import java.util.Set;
//import org.springframework.data.rest.core.config.Projection;

//@Projection(name = "prodProj1", types = { Product.class })
public interface ProdProj1 {
	String getName();
	String getCreated();
	Set<OrderItemsProj> getOrderItems();
}


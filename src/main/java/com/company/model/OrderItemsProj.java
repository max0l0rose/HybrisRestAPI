package com.company.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "orderItemsProj", types = { OrderItems.class })
public interface OrderItemsProj {
	@Value("#{target.product.id} eee")
	String getProductId();

	@Value("#{target.order.id} ttt")
	String getOrderId();

	String getQuantity();
}


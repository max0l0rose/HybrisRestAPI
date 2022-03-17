package com.company.dto;

import com.company.model.Order1;
import com.company.model.OrderItems;
import com.company.utils.MySet;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

//@Projection(name = "orderProj2", types = { Order1.class })
public interface OrderProj2 {
	String getId();
	String getStatus();
	Set<OrderItemsProj> getOrderItems();
}


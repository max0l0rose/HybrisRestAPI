package com.company.dto;

import com.company.model.Order1;

public interface OrdersFindAllView
{
	Order1 getOrder();
	int getProdsCount();
	Integer getProdsTotalPrice();
	Integer getProdsTotalQuantity();
}

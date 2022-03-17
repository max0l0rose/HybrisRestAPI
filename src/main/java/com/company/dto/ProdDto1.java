package com.company.dto;

import com.company.model.OrderItems;
import com.company.model.Product;
import com.company.utils.MySet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
//import org.springframework.data.rest.core.config.Projection;

//@Projection(name = "prodProj1", types = { Product.class })
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class ProdDto1 {
	//void setName(String name);
	String name;
	//Set<OrderItems> orderItems;
}


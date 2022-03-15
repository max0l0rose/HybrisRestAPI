package com.company.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "prodProj1", types = { Product.class })
public interface ProdProj1 {
	String getName();
}


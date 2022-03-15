package com.company.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "orderProj1", types = { Order1.class })
public interface OrderProj1 {
	@Value("#{target.status} qqq")
	String getStatus();
}


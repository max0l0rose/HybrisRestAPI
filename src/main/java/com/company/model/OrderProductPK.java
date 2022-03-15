package com.company.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

//@Getter
//@Setter
public class OrderProductPK implements Serializable {
//	@Access(AccessType.FIELD)
//	@Column(name = "order_id"
//			//		, insertable = false, updatable = false
//	)
//	@Id
	private long order;

//	public Order1 getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order1 orderId) {
//		this.order = orderId;
//	}

//
//	@Column(name = "product_id"
//			//		, insertable = false, updatable = false
//	)
//	@Id
	private long product;

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product productId) {
//		this.product = productId;
//	}



//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		OrderProductPK that = (OrderProductPK) o;
//		return product == that.product && order == that.order;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(product, order);
//	}
}

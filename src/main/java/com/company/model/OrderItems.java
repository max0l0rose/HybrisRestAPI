package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//@TableGenerator(name="DepTableGen",
//		table = "sequences",
//		pkColumnName="SEQ_NAME", // Specify the name of the column of the primary key
//		valueColumnName="SEQ_NUMBER", // Specify the name of the column that stores the last value generated
//		pkColumnValue="LICENSE_ID" // Specify the primary key column value that would be considered as a primary key generator
////		,allocationSize=1
//)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "sequenceGen", sequenceName = "seqDepart", allocationSize = 1)
@Table
@IdClass(OrderProductPK.class)
public class OrderItems
		//implements Serializable
		//extends BaseEntity
{
	//public final static String[][] headers = {{"Id", "user_id", "Status", "Created", "Modified" },};
//
////	@Column(name = "product_id"
//////			, insertable = false, updatable = false
////	)
//	private long productId;
//
////	@Column(name = "order_id"
//////			, insertable = false, updatable = false
////	)
//	@Id
//	private long orderId;


	//@Access(AccessType.PROPERTY)
	@ManyToOne
	//@JoinColumn(name = "product", referencedColumnName = "id", nullable = false)
	@Id
	private Product product;

	//@Access(AccessType.PROPERTY)
	@ManyToOne
	//@JoinColumn(name = "order1", referencedColumnName = "id", nullable = false)
	@Id
	private Order1 order;


	//@Basic
	//@Column(nullable = true)
	private int quantity;


	//	@ManyToMany(//mappedBy = "orders"
//			//fetch = FetchType.LAZY
//	)
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
//	private List<Product> products;



//	@Override
//	public String toString() {
//		return "Order{"
//				       + id +
//				       ", user_id=" + order_id +
//				       ", status=" + status +
//				       ", created=" + created +
//				       ", modified=" + modified +
//				       '}';
//	}


//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
////		String cname = getClass().getName(); // norm
////		String oname = o.getClass().getName();
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		OrderItems that = (OrderItems) o;
//
//		//if (quantity != that.quantity) return false;
//		if (!product.equals(that.product))
//			return false;
//		return order.equals(that.order);
//	}
//
//
//
//	@Override
//	public int hashCode() {
//		int result = (int)product.id;
//		result = 31 * result + (int)order.id;
//		//result = 31 * result + quantity;
//		return result;
//	}
}



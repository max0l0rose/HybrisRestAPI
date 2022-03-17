//package com.company.services;
//
//import com.company.model.Order1;
//import com.company.repo.OrdersRepo;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//@Getter
//public class OrdersService implements MyService<Order1>{
//
//	@Autowired
//	private OrdersRepo ordersRepo;
//
//	@PersistenceContext
//	EntityManager entityManager;
//
////	@Autowired
////	private GeneralSequenceNumberRepo genSeqNumRepo;
//
//	public void detach(Order1 o) {
//		entityManager.detach(o);
//	}
//
//
//	public Iterable<Order1> getAll() {
//		return ordersRepo.findAll();
//	}
//
//
//	public Optional<Order1> show(long id) {
//		return ordersRepo.findById(id);
//	}
//
//
//
////	public Optional<Department> findByName(String name) {
////		return depsRepo.findByDepName(name);
////	}
//
//
////	public Order1 save(Order1 order) {
////		//GeneralSequenceNumber number = getNextUserId();
////		List<GeneralSequenceNumber> seqList = genSeqNumRepo.findAll();
////		//GeneralSequenceNumber number = seqList.size()>0 ? (GeneralSequenceNumber)seqList.get(0) : new GeneralSequenceNumber();//findFirstByOrderByVal();
////		GeneralSequenceNumber number = seqList.stream().findFirst().orElseGet(() -> {
////			GeneralSequenceNumber num = new GeneralSequenceNumber();
////			genSeqNumRepo.save(num);
////			return num;
////		});//findFirstByOrderByVal();
////
////		order.setUserId(number.getUId());
////
////		genSeqNumRepo.deleteAll();
////		genSeqNumRepo.flush();
////
////		GeneralSequenceNumber number2 = new GeneralSequenceNumber();
////		//number2.setUId(number.getUId() + 1);
////		genSeqNumRepo.save(number2);
////
////
//////		//GeneralSequenceNumber number3 = genSeqNumRepo.findFirstByOrderByVal(); // getNextUserId();
//////		//boolean contains2 = entityManager.contains(number);
////
////		return ordersRepo.save(order);
////	}
//
//
//	public Order1 save(Order1 order) {
////		genSeqNumRepo.deleteAll();
////		GeneralSequenceNumber number = new GeneralSequenceNumber();
////		GeneralSequenceNumber numberAttached = genSeqNumRepo.save(number); // !!!!! numberAttached
////		//genSeqNumRepo.flush();
////		order.setUserId(numberAttached.getUId());
//
//		//order.setUser(order);
//
//		return ordersRepo.save(order);
//	}
//
//
//	public void delete(long id) {
//		ordersRepo.deleteById(id);
//	}
//
//
////	public Iterable<OrdersViewModel> getView() {
////		return ordersRepo.getAllOrdersView();
////	}
//
//}

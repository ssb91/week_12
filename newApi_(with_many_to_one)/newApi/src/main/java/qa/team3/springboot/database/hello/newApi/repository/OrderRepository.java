package qa.team3.springboot.database.hello.newApi.repository;


//import javax.persistence.criteria.Order;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import qa.team3.springboot.database.hello.newApi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
Page<Order> findByPersonId(Long personId, Pageable pageable);
		
}
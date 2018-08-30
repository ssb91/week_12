package qa.team3.springboot.database.hello.newApi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import qa.team3.springboot.database.hello.newApi.repository.*;
import qa.team3.springboot.database.hello.newApi.model.*;
import qa.team3.springboot.database.hello.newApi.exception.ResourceNotFoundException;

@RestController
public class OrderController {

@Autowired	
private OrderRepository orderRepository;

@Autowired	
private NewApiRepository newApiRepository;

@GetMapping("/person/{personId}/orders")	
public Page<Order> getAllOrdersByPersonId(@PathVariable (value = "person_id") Long personId, Pageable pageable) {	
	return orderRepository.findByPersonId(personId, pageable);	
}

@PostMapping("/person/{personId}/orders")
public Order createComment(@PathVariable (value = "personId") Long personId,
		@Valid @RequestBody Order order) {
	
	return newApiRepository.findById(personId).map(NewApiDataModel -> {
		order.setPerson(NewApiDataModel);
		return orderRepository.save(order);		
	}).orElseThrow(() -> new ResourceNotFoundException("Person", "id", order));
	
}

@PutMapping("/person/{personId}/orders/{orderId}")
public Order updateOrder(@PathVariable (value = "personId") Long personId,
		@PathVariable (value = "orderId") Long orderId,
		@Valid @RequestBody Order orderRequest) {
	if (!newApiRepository.existsById(personId)) {
		throw new ResourceNotFoundException("Person", "id", orderRequest);
		
	}

	return orderRepository.findById(orderId).map(order -> {
		
		order.setTitle(orderRequest.getTitle());
		return orderRepository.save(order);
		
	}).orElseThrow(() -> new ResourceNotFoundException("OrderId", "id", orderRequest));
}


@DeleteMapping("/person/{personId}/orders/{orderId}")
public ResponseEntity<?> deleteComment(@PathVariable (value = "personId") Long personId,
		@PathVariable (value="orderId") Long orderId) {
	
	if(!newApiRepository.existsById(personId)) {
		
		throw new ResourceNotFoundException("Person", "id", personId);
			
	}
	
	return orderRepository.findById(orderId).map(order -> {
		
		orderRepository.delete(order);
		return ResponseEntity.ok().build();
		
	}).orElseThrow(() -> new ResourceNotFoundException("Order Id", orderId.toString(), null));
	
}
		

}
package com.bookstore.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Order;
import com.bookstore.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/", produces="application/json")
	public List<Order> getAll(){
		return orderRepository.findAll();
	}

	@PostMapping("/")
	/* JSON example
	 * {
    "day": "2018-01-01",
    "books": [
        {
            "id": 1
            }
            ]
       }
	 */
	public Order create(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@RequestMapping("/id/{id}")
	public Order get(@PathVariable(value = "id") Integer id) {
		return orderRepository.getOne(id);
	}
	
	@GetMapping("/currentmonth")
	public List<Order> getCurrentMonth(){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMM");
		return orderRepository.findAll().stream()               
                .filter(o -> fmt.format(o.getDay()).equals(fmt.format(new Date())))     
                .collect(Collectors.toList());
	}

	@GetMapping("/currentyear")
	public List<Order> getCurrentYear(){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
		return orderRepository.findAll().stream()     
                .filter(o -> fmt.format(o.getDay()).equals(fmt.format(new Date())))     
                .collect(Collectors.toList());
	}
	@GetMapping("/countyear/{year}")
	public Integer getCountByYear(@PathVariable(value = "year") String year){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
		return orderRepository.findAll().stream()                
                .filter(o -> fmt.format(o.getDay()).equals(fmt.format(new Date())))     
                .collect(Collectors.toList()).size();
	}
}

package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.entity.KidBook;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.KidBookRepository;

@RestController
@RequestMapping("/kid")
public class KidBookController {
	@Autowired
	private KidBookRepository bookRepository;

	
	@RequestMapping("/")
	//@ResponseBody
	public ResponseEntity<List<KidBook>> getAll(){
		return ResponseEntity.ok().body(bookRepository.findAll());
	}

	@PostMapping("/")
	public KidBook create(@RequestBody KidBook book) {
		 bookRepository.save(book);
		 return book;
	}
	
	@RequestMapping("/id/{id}")
	public KidBook get(@PathVariable(value = "id") int id) {
		return bookRepository.getOne(id);
	}
	
	@PutMapping("/")
	public KidBook update(@RequestBody KidBook book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<KidBook> delete(@PathVariable(value = "id") int id) {
		bookRepository.deleteById(id);
		return ResponseEntity.ok().body(null);
	}
}

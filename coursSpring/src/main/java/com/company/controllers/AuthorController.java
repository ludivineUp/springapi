package com.company.controllers;

import com.company.entities.Author;
import com.company.repositories.AuthorRespository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRespository authorRespository;

    // get all
    @RequestMapping(value = "", produces = "application/json")
    public List<Author> getAll(){
        return authorRespository.findAll();
    }

    // get one by id
    @RequestMapping(value = "/{id}", produces = "application/json")
    public Author getById(@PathVariable(value = "id") Integer id){
        return authorRespository.getOne(id);
    }

    // add one
    @PostMapping("/")
    /* JSON example
	    { "lastname" : "body","firstname" : "no"}
	 */
    public Author create(@RequestBody Author author){
        return authorRespository.save(author);
    }

    // update
    @PutMapping("/")
    /* JSON example
	    { "id": 1, "lastname" : "body","firstname" : "no"}
	 */
    public Author update(@RequestBody Author author){
        return authorRespository.save(author);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> delete(@PathVariable(value = "id") int id){
       authorRespository.deleteById(id);
       return ResponseEntity.ok().body(null);
    }
}

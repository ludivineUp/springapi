package com.company.repositories;

import com.company.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRespository extends JpaRepository<Author, Integer> {
}

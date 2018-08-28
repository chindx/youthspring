package com.chindx.youth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chindx.youth.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}

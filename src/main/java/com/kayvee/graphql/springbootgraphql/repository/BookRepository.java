package com.kayvee.graphql.springbootgraphql.repository;

import com.kayvee.graphql.springbootgraphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository  extends JpaRepository<Book, String> {
}

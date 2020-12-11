package com.kayvee.graphql.springbootgraphql.service.datafetcher;

import com.kayvee.graphql.springbootgraphql.model.Book;
import com.kayvee.graphql.springbootgraphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> get(DataFetchingEnvironment environment) {
        log.info("Inside all books data fetcher");
        List<Book> allBooks = bookRepository.findAll();
        log.info("Books list {}", allBooks);
        return allBooks;
    }
}

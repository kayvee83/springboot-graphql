package com.kayvee.graphql.springbootgraphql.service.datafetcher;

import com.google.common.base.Optional;
import com.kayvee.graphql.springbootgraphql.model.Book;
import com.kayvee.graphql.springbootgraphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookDataFetcher implements DataFetcher<Book> {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment environment) {
        String isbn = environment.getArgument("id");
        return bookRepository.getOne(isbn);
    }
}

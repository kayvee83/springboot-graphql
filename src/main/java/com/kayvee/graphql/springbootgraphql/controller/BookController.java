package com.kayvee.graphql.springbootgraphql.controller;

import com.kayvee.graphql.springbootgraphql.repository.BookRepository;
import com.kayvee.graphql.springbootgraphql.service.BookGraphQLService;
import graphql.ExecutionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    private BookGraphQLService bookGraphQLService;

    @Autowired
    BookRepository bookRepository;


    @PostMapping
    public ResponseEntity getAllBooks(@RequestBody String query){
        log.info("Query passed {}", query);
        ExecutionResult executionResult = bookGraphQLService.getGraphQL().execute(query);
        return new ResponseEntity(executionResult, HttpStatus.OK);
    }


}

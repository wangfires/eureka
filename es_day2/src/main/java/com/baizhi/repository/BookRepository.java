package com.baizhi.repository;

import com.baizhi.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,String> {
}

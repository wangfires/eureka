package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Document(indexName = "dangdang",type ="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    @Field(type= FieldType.Text,analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Date)
    private Date createDate;
    @Field(type = FieldType.Keyword)
    private String author;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;
}

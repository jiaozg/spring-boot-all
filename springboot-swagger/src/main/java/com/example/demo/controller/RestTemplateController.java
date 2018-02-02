package com.example.demo.controller;

import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaozhiguang on 2018/1/8.
 */
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/gethello")
    public String getHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/hello", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }

    @RequestMapping("/sayhello")
    public String sayHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/sayHello?name={1}", String.class, "张三");
        return responseEntity.getBody();
    }
    @RequestMapping("/sayhello2")
    public String sayHello2() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "王五");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/sayHello?name={name}", String.class, map);
        return responseEntity.getBody();
    }

    @RequestMapping("/sayhello3")
    public String sayHello3() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8081/sayHello?name={name}").build().expand("王五").encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }


    @RequestMapping("/book1")
    public Book book1() {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("http://localhost:8081/books/getbook1", Book.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/book2")
    public Book book2() {
        Book book = restTemplate.getForObject("http://localhost:8081/books/getbook1", Book.class);
        return book;
    }

    @RequestMapping("/book3")
    public Book book3() {
        Book book = new Book();
        book.setId(111);
        book.setName("红楼梦");
        book.setPrice(11.11);
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity("http://localhost:8081/books", book, Book.class);
        return responseEntity.getBody();
    }


    @RequestMapping("/put")
    public void put() {
        Book book = new Book();
        book.setId(111);
        book.setPrice(22.22);
        book.setName("红楼梦");
        restTemplate.put("http://localhost:8081/books/{1}", book, 111);
    }

    @RequestMapping("/delete")
    public void delete() {
        restTemplate.delete("http://localhost:8081/books/{1}", 111);
    }

}

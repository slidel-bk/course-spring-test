package com.course.test.repo.dao;

import com.course.test.model.Autor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface AutorDao {

    List<Autor> lstAutores();
}

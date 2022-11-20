package com.course.test.repo.daoImpl;

import com.course.test.model.Autor;
import com.course.test.repo.dao.AutorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class AutorDaoImpl implements AutorDao {

    private RestTemplate restTemplate;

    private final String URL_ROOT = "http://localhost:8092/autores/";

    @Autowired
    public AutorDaoImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Autor> lstWsAutores() {
        ResponseEntity<Autor[]> responseEntity = restTemplate.getForEntity(URL_ROOT+"autores", Autor[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}

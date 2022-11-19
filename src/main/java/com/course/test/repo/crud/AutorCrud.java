package com.course.test.repo.crud;

import com.course.test.model.Autor;
import com.course.test.repo.dao.AutorDao;
import org.springframework.data.repository.CrudRepository;

public interface AutorCrud extends CrudRepository<Autor, Integer>, AutorDao {
}

package com.course.test.service;

import com.course.test.model.Autor;
import com.course.test.repo.crud.AutorCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    public AutorCrud autorCrud;

    @Autowired
    public AutorService(AutorCrud autorCrud) {
        this.autorCrud = autorCrud;
    }

    public List<Autor> lstTodos() {
        return (List<Autor>) autorCrud.findAll();
    }

    public Optional<Autor> obtenerPorID(Integer id) {
        return autorCrud.findById(id);
    }

    public void guardar(Autor autor) {
        autorCrud.save(autor);
    }

    public void eliminar(Integer id) {
        autorCrud.deleteById(id);
    }


}

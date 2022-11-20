package com.course.test.controller;

import com.course.test.model.Autor;
import com.course.test.service.AutorService;
import com.sun.faces.action.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AutorController {

    private AutorService  autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Autor>> todos() {
        return new ResponseEntity<>(autorService.lstTodos(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity obtenerPorId(@PathVariable Integer id) {
        return autorService.obtenerPorID(id).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/guardar")
    public ResponseEntity guardar(@RequestBody Autor autor) {
        autorService.guardar(autor);
        return autor.getId() != null ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        autorService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

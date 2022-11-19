package com.course.test.controller;

import com.course.test.model.Autor;
import com.course.test.service.AutorService;
import com.sun.faces.action.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorService  autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Autor>> todos() {
        return new ResponseEntity<>(autorService.lstTodos(), HttpStatus.OK);
    }
}

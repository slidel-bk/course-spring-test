package com.course.test.view;

import com.course.test.model.Autor;
import com.course.test.service.AutorService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Scope(value = "session")
@Component
@Data
public class AutorBackBean implements Serializable {

    private String variable = "Hola mundo";
    private AutorService autorService;
    private Autor autor = new Autor();
    private List<Autor> lstAutores;

    @Autowired
    public AutorBackBean(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostConstruct
    public void init() {
        autor.setEstado(true);
        obtenerAutoresWS();
    }

    public void obtenerAutoresWS() {
        try {
            lstAutores = autorService.wsLstAutores().stream().sorted(Comparator.comparingInt(Autor::getId).reversed()).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public void guardar() {
        try {
            autorService.guardar(autor);
            if (autor.getId() != null) {
                obtenerAutoresWS();
                System.out.println("Guardado");
            }
            limpiar();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void limpiar() {
        autor = new Autor();
        autor.setEstado(true);
    }
}

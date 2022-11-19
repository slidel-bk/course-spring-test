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

@Scope(value = "session")
@Component
@Data
public class AutorBackBean implements Serializable {

    private String variable = "Hola mundo";
    private AutorService autorService;
    private Autor autor = new Autor();

    @Autowired
    public AutorBackBean(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostConstruct
    public void init() {
        autor.setEstado(true);
    }

    public void guardar() {
        try {
            autorService.guardar(autor);
            if (autor.getId() != null) {
                System.out.println("Guardado");
                displayMessage();
                //addMessage(FacesMessage.SEVERITY_INFO, "Información", "Guardado correctamente");
            }
            limpiar();
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_WARN, "Excepción", e.getMessage());
        }
    }

    public void limpiar() {
        autor = new Autor();
    }

    public void displayMessage(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("Login Successfuly", "Welcome: "));
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
}

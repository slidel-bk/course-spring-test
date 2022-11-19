package com.course.test.view;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Scope(value = "session")
@Component
@Data
public class AutorBackBean implements Serializable {

    private String variable = "Hola mundo";

    @PostConstruct
    public void init () {
        System.out.println("........");
    }
}

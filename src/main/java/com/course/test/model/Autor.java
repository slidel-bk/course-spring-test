package com.course.test.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "authors")
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "au_id")
    private Integer id;
    @Column(name = "au_fname")
    private String nombre;
    @Column(name = "au_lname")
    private String apellido;
    @Column(name = "phone")
    private String telefono;
    @Column(name = "address")
    private String direccion;
    @Column(name = "city")
    private String ciudad;
    @Column(name = "state")
    private String departamento;
    @Column(name = "zip")
    private String codigoPostal;
    @Column(name = "contract")
    private Boolean estado;
}

package com.example.contactos.contacto.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String telefono;

    @Column
    private String empresa;

    public Contacto() {}

    public Contacto(String nombre, String email, String telefono, String empresa) {
        this.nombre   = nombre;
        this.email    = email;
        this.telefono = telefono;
        this.empresa  = empresa;
    }

    public Long getId()                { return id; }
    public String getNombre()          { return nombre; }
    public void setNombre(String n)    { this.nombre = n; }
    public String getEmail()           { return email; }
    public void setEmail(String e)     { this.email = e; }
    public String getTelefono()        { return telefono; }
    public void setTelefono(String t)  { this.telefono = t; }
    public String getEmpresa()         { return empresa; }
    public void setEmpresa(String emp) { this.empresa = emp; }
}
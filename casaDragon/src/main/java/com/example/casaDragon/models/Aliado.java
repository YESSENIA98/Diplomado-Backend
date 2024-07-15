package com.example.casaDragon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "tabla_aliado")

public class Aliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres_aliado", nullable = true, length = 50)
    private String nombres; //validar letras y espacios y maximo 50 caracteres

    @Column(name= "ubicacion_aliado")
    private String ubicacion; //maximo 70 caracteres

    @Column(name = "aporte_aliado")
    private Integer aporte; //solo numeros positivos

    @ManyToOne
    @JoinColumn(name = "fk_jinete", referencedColumnName = "id")
    @JsonBackReference
    Jinete jinete;

    public Aliado() {
    }

    public Aliado(Integer id, String nombres, String ubicacion, Integer aporte) {
        this.id = id;
        this.nombres = nombres;
        this.ubicacion = ubicacion;
        this.aporte = aporte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getAporte() {
        return aporte;
    }

    public void setAporte(Integer aporte) {
        this.aporte = aporte;
    }
}

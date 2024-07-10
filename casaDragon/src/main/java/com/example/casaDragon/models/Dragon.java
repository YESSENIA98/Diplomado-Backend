package com.example.casaDragon.models;


import jakarta.persistence.*;

//anotaciones
@Entity
@Table(name = "tabla_dragon")

public class Dragon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //se pone falso si el campo es requerido sino, no pones nullable
    //length es el varchar
    @Column(name = "nombres_dragon", nullable = true, length = 50)
    private String nombres;

    @Column(name = "edad_dragon" )
    private Integer edad;

    @Column(name = "altura_dragon")
    private Double altura;

    @Column(name = "numero_victorias_dragon")
    private Integer numeroVictorias;

    //relacion con el objeto completo
    @OneToMany
    Jinete jinete;


    //inicializar constructor vacio
    public Dragon() {
    }

//constuctor
    public Dragon(Integer id, String nombres, Integer edad, Double altura, Integer numeroVictorias) {
        this.id = id;
        this.nombres = nombres;
        this.edad = edad;
        this.altura = altura;
        this.numeroVictorias = numeroVictorias;
    }

//Getters - Setters
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(Integer numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }


}

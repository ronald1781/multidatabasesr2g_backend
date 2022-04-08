package com.r2g.model.bdmq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbuser")
public class User {
    @Id
    private Integer id;
    @Column(name = "nombres")
    private String nombre;

    public User() {
    }

    public User(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nombre=" + nombre + "]";
    }

}

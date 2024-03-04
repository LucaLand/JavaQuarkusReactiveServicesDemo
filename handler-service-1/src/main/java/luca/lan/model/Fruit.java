package luca.lan.model;

import jakarta.persistence.*;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Cacheable
public class Fruit extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String name;

    public void setName(String name) {
        this.name = name;
    }
    
}

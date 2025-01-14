package com.morrs.firstrestapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "scanners")
public class Scanner {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;


    @OneToMany(mappedBy = "scanner", fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<ScannersData> data;

    @Override
    public String toString() {
        return "Scanner{" +
                "name='" + name + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ScannersData> getData() {
        return data;
    }

    public void setData(List<ScannersData> data) {
        this.data = data;
    }
}

package com.morrs.firstrestapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "scanners")
public class Scanner {
    @Id
    private String name;

    @OneToMany(mappedBy = "scanner")
    private List<ScannersData> data;

    @Override
    public String toString() {
        return "Scanner{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

package com.morrs.firstrestapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "scanners")
@Data
public class Scanner {
    @Id
    private String name;
}

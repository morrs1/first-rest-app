package com.morrs.firstrestapp.repos;

import com.morrs.firstrestapp.models.Scanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScannersRepo extends JpaRepository<Scanner, UUID> {

    boolean existsByName(String name);
}

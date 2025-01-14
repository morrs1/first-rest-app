package com.morrs.firstrestapp.repos;

import com.morrs.firstrestapp.models.ScannersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScannersDataRepo extends JpaRepository<ScannersData, Integer> {
}

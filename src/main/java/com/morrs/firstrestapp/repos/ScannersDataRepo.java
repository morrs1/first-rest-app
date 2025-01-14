package com.morrs.firstrestapp.repos;

import com.morrs.firstrestapp.models.ScannersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScannersDataRepo extends JpaRepository<ScannersData, Integer> {
    boolean existsByScannerName(String scannerName);

    @Query(value = "SELECT COUNT(*) FROM scanners_data WHERE raining = TRUE", nativeQuery = true)
    int countRaining();

}

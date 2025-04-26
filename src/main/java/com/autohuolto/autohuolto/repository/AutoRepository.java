package com.autohuolto.autohuolto.repository;

import com.autohuolto.autohuolto.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
    // Add this method to find Auto by rekisterinumero
    Optional<Auto> findByRekisterinumero(String rekisterinumero);
}
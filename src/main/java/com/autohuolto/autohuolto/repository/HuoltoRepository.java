package com.autohuolto.autohuolto.repository;

import com.autohuolto.autohuolto.model.Huolto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuoltoRepository extends JpaRepository<Huolto, Long> {

    List<Huolto> findByAuto_Id(Long autoId);

    // Hakee huollon nimen perusteella
    List<Huolto> findByKuvausContaining(String nimi);
}
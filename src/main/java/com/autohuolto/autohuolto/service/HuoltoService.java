package com.autohuolto.autohuolto.service;

import com.autohuolto.autohuolto.model.Huolto;
import com.autohuolto.autohuolto.repository.HuoltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuoltoService {

    private final HuoltoRepository huoltoRepository;

    @Autowired
    public HuoltoService(HuoltoRepository huoltoRepository) {
        this.huoltoRepository = huoltoRepository;
    }

    // Hakee kaikki huollot
    public List<Huolto> findAll() {
        return huoltoRepository.findAll();
    }
    public List<Huolto> findByAutoId(Long autoId) {
        return huoltoRepository.findByAuto_Id(autoId);
    }

    // Tallentaa huollon tietokantaan
    public Huolto save(Huolto huolto) {
        return huoltoRepository.save(huolto);
    }

    // Hakee huollon ID:n perusteella
    public Optional<Huolto> findById(Long id) {
        return huoltoRepository.findById(id);
    }

    // Poistaa huollon tietokannasta
    public void deleteById(Long id) {
        huoltoRepository.deleteById(id);
    }

    public void delete(Long id) {
        if (huoltoRepository.existsById(id)) {
            huoltoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Huolto ID: " + id + " ei löytynyt.");
        }
    }
}
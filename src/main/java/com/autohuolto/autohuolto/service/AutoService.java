package com.autohuolto.autohuolto.service;

import com.autohuolto.autohuolto.model.Auto;
import com.autohuolto.autohuolto.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    private final AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    // Hakee kaikki autot
    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    // Tallentaa auton tietokantaan
    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    // Hakee auton rekisterinumeron perusteella
    public Optional<Auto> findByRekisterinumero(String rekisterinumero) {
        return autoRepository.findByRekisterinumero(rekisterinumero);
    }

    // Poistaa auton tietokannasta
    public void deleteById(Long id) {
        autoRepository.deleteById(id);
    }

    public void delete(Long id) {
        autoRepository.deleteById(id);
    }
}
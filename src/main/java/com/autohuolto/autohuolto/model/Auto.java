package com.autohuolto.autohuolto.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rekisterinumero;  // Field for the registration number

    @Column(name = "merkki", nullable = false)
    private String merkki;

    @Column(name = "malli", nullable = false)
    private String malli;

    @Column(name = "vuosi", nullable = false)
    private int vuosi;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Huolto> huollot;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRekisterinumero() {
        return rekisterinumero;
    }

    public void setRekisterinumero(String rekisterinumero) {
        this.rekisterinumero = rekisterinumero;
    }

    public String getMerkki() {
        return merkki;
    }

    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }

    public String getMalli() {
        return malli;
    }

    public void setMalli(String malli) {
        this.malli = malli;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    public List<Huolto> getHuollot() {
        return huollot;
    }

    public void setHuollot(List<Huolto> huollot) {
        this.huollot = huollot;
    }

    @Override
    public String toString() {
        return merkki + " " + malli + " (" + vuosi + ")";
    }
}

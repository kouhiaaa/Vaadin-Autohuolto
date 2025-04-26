package com.autohuolto.autohuolto.model;
import org.springframework.web.bind.annotation.RestController;
import com.vaadin.flow.component.datepicker.DatePicker;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "huolto")
public class Huolto {
    private LocalDate paivamaara;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id", nullable = false)
    private Auto auto;

    @Column(name = "huoltopaiva", nullable = false)
    private LocalDate huoltopaiva;

    @Column(name = "kuvaus", length = 500)
    private String kuvaus;

    @Column(name = "hinta")
    private Double hinta;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public LocalDate getHuoltopaiva() {
        return huoltopaiva;
    }

    public void setHuoltopaiva(LocalDate huoltopaiva) {
        this.huoltopaiva = huoltopaiva;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public Double getHinta() {
        return hinta;
    }

    public void setHinta(Double hinta) {
        this.hinta = hinta;
    }
    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }

    // Getter metodi
    public LocalDate getPaivamaara() {
        return paivamaara;
    }
    // ToString, equals, hashCode, etc.
}
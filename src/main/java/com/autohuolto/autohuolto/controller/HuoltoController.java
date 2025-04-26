package com.autohuolto.autohuolto.controller;
import com.autohuolto.autohuolto.service.HuoltoService;
import com.autohuolto.autohuolto.model.Huolto;
import com.autohuolto.autohuolto.model.Auto;
import jakarta.persistence.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/huolto")
public class HuoltoController {
    @Autowired private HuoltoService huoltoService;

    @GetMapping public List<Huolto> getAll() { return huoltoService.findAll(); }
    @GetMapping("/auto/{id}") public List<Huolto> getByAuto(@PathVariable Long id) {
        return huoltoService.findByAutoId(id);
    }
    @PostMapping public Huolto save(@RequestBody Huolto h) { return huoltoService.save(h); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { huoltoService.deleteById(id)
    ; }
}
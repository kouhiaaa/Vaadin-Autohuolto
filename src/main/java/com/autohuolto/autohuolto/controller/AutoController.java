package com.autohuolto.autohuolto.controller;
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

import com.autohuolto.autohuolto.model.Auto;
import com.autohuolto.autohuolto.service.AutoService;
@RestController
@RequestMapping("/api/auto")
public class AutoController {
    @Autowired private AutoService autoService;

    @GetMapping public List<Auto> getAll() { return autoService.findAll(); }
    @PostMapping public Auto save(@RequestBody Auto auto) { return autoService.save(auto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { autoService.deleteById(id)
    ; }
}
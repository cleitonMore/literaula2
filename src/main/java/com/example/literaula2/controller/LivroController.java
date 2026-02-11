package com.example.literaula2.controller;

import com.example.literaula2.model.Livro;
import com.example.literaula2.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping("/gutendex")
    public List<Livro> buscar(@RequestParam String titulo) {
        return service.buscarNaGutendex(titulo);
    }
}


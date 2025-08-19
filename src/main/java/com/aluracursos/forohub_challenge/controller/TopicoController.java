package com.aluracursos.forohub_challenge.controller;

import com.aluracursos.forohub_challenge.topico.DatosListaTopico;
import com.aluracursos.forohub_challenge.topico.DatosRegistroTopico;
import com.aluracursos.forohub_challenge.topico.Topico;
import com.aluracursos.forohub_challenge.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        //System.out.println(datos);
        repository.save(new Topico(datos));
    }


    @GetMapping
    public List<DatosListaTopico> listarTopico() {
        return repository.findAll().stream().map(DatosListaTopico::new).toList();
    }
}

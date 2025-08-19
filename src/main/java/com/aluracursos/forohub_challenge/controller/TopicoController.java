package com.aluracursos.forohub_challenge.controller;

import com.aluracursos.forohub_challenge.topico.DatosRegistroTopico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    public void registrarTopico(@RequestBody DatosRegistroTopico datos) {
        System.out.println(datos);
    }
}

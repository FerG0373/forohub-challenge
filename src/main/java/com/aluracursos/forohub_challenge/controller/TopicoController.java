package com.aluracursos.forohub_challenge.controller;

import com.aluracursos.forohub_challenge.topico.DatosListaTopico;
import com.aluracursos.forohub_challenge.topico.DatosRegistroTopico;
import com.aluracursos.forohub_challenge.topico.Topico;
import com.aluracursos.forohub_challenge.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // POST
    @Transactional
    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        //System.out.println(datos);
        repository.save(new Topico(datos));
    }

    // GET
    @GetMapping
    public Page<DatosListaTopico> listarTopico(@PageableDefault(size=10, sort={"fechaCreacion"}) Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListaTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaTopico> detallarTopico(@PathVariable Long id) {
        // Buscar el tópico por ID en el repositorio
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado con ID: " + id));

        // Mapear la entidad al DTO de listado
        DatosListaTopico datosDetalle = new DatosListaTopico(topico);

        // Devolver el DTO con el estado HTTP 200 OK
        return ResponseEntity.ok(datosDetalle);
    }
}

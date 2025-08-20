package com.aluracursos.forohub_challenge.controller;

import com.aluracursos.forohub_challenge.topico.*;
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
        return repository.findAllByActivoTrue(paginacion).map(DatosListaTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaTopico> detallarTopico(@PathVariable Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado con ID: " + id));
        // Mapear la entidad al DTO de listado
        DatosListaTopico datosDetalle = new DatosListaTopico(topico);

        return ResponseEntity.ok(datosDetalle);
    }

    // PUT
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<DatosListaTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico datos) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado con ID: " + id));

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(datos.autor());
        topico.setCurso(datos.curso());

        return ResponseEntity.ok(new DatosListaTopico(topico));
    }

    // DELETE LÓGICO
    @Transactional
    @DeleteMapping("/{id}")
    public void eliminarLogicoTopico(@PathVariable Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado con ID: " + id));
        topico.eliminarLogico();
    }
}



    // DELETE
//    @Transactional
//    @DeleteMapping("/{id}")
//    public void eliminarTopico(@PathVariable Long id) {
//        if (!repository.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado con ID: " + id);
//        }
//        repository.deleteById(id);
//    }


//    // PUT HECHO POR EL PROFESOR
//    @Transactional
//    @PutMapping
//    public void actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datos) {
//        var topico = repository.getReferenceById(datos.id());
//        topico.actualizarInformaciones(datos);
//    }


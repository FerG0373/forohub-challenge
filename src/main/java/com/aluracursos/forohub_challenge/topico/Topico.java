package com.aluracursos.forohub_challenge.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estadoTopico = EstadoTopico.NO_RESPONDIDO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
        if(datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if(datos.autor() != null) {
            this.autor = datos.autor();
        }
        if(datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}

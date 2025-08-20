package com.aluracursos.forohub_challenge.topico;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datos) {
        this.id = null;
        this.activo = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estadoTopico = EstadoTopico.NO_RESPONDIDO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void eliminarLogico() {
        this.activo = false;
    }
}




//    // FORMA HECHA POR EL PROFESOR
//    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
//        if(datos.titulo() != null) {
//            this.titulo = datos.titulo();
//        }
//        if(datos.mensaje() != null) {
//            this.mensaje = datos.mensaje();
//        }
//        if(datos.autor() != null) {
//            this.autor = datos.autor();
//        }
//        if(datos.curso() != null) {
//            this.curso = datos.curso();
//        }
//    }


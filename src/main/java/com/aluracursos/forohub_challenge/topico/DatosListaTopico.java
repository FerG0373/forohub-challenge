package com.aluracursos.forohub_challenge.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        EstadoTopico estadoTopico,
        String autor,
        String curso
) {

    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstadoTopico(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}

package com.aluracursos.forohub_challenge.topico;


import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        NotNull id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
}

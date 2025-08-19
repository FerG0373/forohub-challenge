package com.aluracursos.forohub_challenge.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizacionTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
}

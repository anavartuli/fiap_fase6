package br.com.fiap.semaforos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ControladoraCadastroDto(
        Long cdControladora,

        @PastOrPresent(message = "A data do Evento é obrigatória!")
        LocalDate dtMomentoEvento,

        @NotNull(message = "Numero do fluxo!")
        Long fxFluxo,

        @NotNull(message = "Codigo do semáforo é obrigatório!")
        Long tSemSemaforoCdSemaforo,

        @NotNull(message = "Código do sensor é obrigatório!")
        Long tSemSensorCdSensor,

        @NotNull(message = "Código do dispositivo é obrigatório!")
        Long tSemDispIdCdDisp
) {
}

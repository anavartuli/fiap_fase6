package br.com.fiap.semaforos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SemaforoCadastroDto(
        Long cdSemaforo,

        @NotBlank(message = "Logradouro do semaforo é obrigatório!")
        String lgLogradouro,

        @NotNull(message = "Numero do semaforo é obrigatório!")
        Long lgNumero,

        @NotBlank(message = "Cidade do semaforo é obrigatória!")
        String lgCidade,

        @NotBlank(message = "Estado do semaforo é obrigatório!")
        String lgEstado,

        @NotNull(message = "Tempo Verde do semaforo é obrigatório!")
        Long tmTempoVerde,

        @NotNull(message = "Tempo Amarelo do semaforo é obrigatório!")
        Long tmTempoAmarelo,

        @NotNull(message = "Tempo Vermelho do semaforo é obrigatório!")
        Long tmTempoVeremelho

) {
}

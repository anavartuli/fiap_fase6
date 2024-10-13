package br.com.fiap.semaforos.dto;

import br.com.fiap.semaforos.model.Semaforo;

import java.time.LocalDate;

public record SemaforoExibicaoDto(
        Long cdSemaforo,
        String lgLogradouro,
        Long lgNumero,
        String lgCidade,
        String lgEstado,
        Long tmTempoVerde,
        Long tmTempoAmarelo,
        Long tmTempoVeremelho,
        String dsUltimaAcao,
        LocalDate dtUltimaAcao,
        Long tmUltimaAcao
) {
    public SemaforoExibicaoDto(Semaforo semaforo) {
        this(
                semaforo.getCdSemaforo(),
                semaforo.getLgLogradouro(),
                semaforo.getLgNumero(),
                semaforo.getLgCidade(),
                semaforo.getLgEstado(),
                semaforo.getTmTempoVerde(),
                semaforo.getTmTempoAmarelo(),
                semaforo.getTmTempoVeremelho(),
                semaforo.getDsUltimaAcao(),
                semaforo.getDtUltimaAcao(),
                semaforo.getTmUltimaAcao()
        );

    }

}

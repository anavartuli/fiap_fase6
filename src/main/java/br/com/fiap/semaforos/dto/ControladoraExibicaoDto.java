package br.com.fiap.semaforos.dto;

import br.com.fiap.semaforos.model.Controladora;

import java.time.LocalDate;

public record ControladoraExibicaoDto(
        Long cdControladora,
        LocalDate dtMomentoEvento,
        Long fxFluxo,
        Long tSemSemaforoCdSemaforo,
        Long tSemSensorCdSensor,
        Long tSemDispIdCdDisp
) {

    public ControladoraExibicaoDto(Controladora controladora) {
        this(
                controladora.getCdControladora(),
                controladora.getDtMomentoEvento(),
                controladora.getFxFluxo(),
                controladora.gettSemSemaforoCdSemaforo(),
                controladora.getTSemSensorCdSensor(),
                controladora.gettSemDispIdCdDisp()
        );
    }
}

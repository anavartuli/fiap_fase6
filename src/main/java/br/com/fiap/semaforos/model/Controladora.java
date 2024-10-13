package br.com.fiap.semaforos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_sem_controladora")
public class Controladora {

    public Controladora() {

    }

    public Controladora(Long cdControladora, LocalDate dtMomentoEvento, Long fxFluxo, Long tSemSemaforoCdSemaforo, Long TSemSensorCdSensor, Long tSemDispIdCdDisp) {
        this.cdControladora = cdControladora;
        this.dtMomentoEvento = dtMomentoEvento;
        this.fxFluxo = fxFluxo;
        this.tSemSemaforoCdSemaforo = tSemSemaforoCdSemaforo;
        this.TSemSensorCdSensor = TSemSensorCdSensor;
        this.tSemDispIdCdDisp = tSemDispIdCdDisp;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_CD_CONTROLADORA"
    )
    @SequenceGenerator(
            name = "SQ_CD_CONTROLADORA",
            sequenceName = "SQ_CD_CONTROLADORA",
            allocationSize = 1
    )
    @Column(name = "cd_controladora")
    private Long cdControladora;
    @Column(name = "dt_momento_evento")
    private LocalDate dtMomentoEvento;
    @Column(name = "fx_fluxo")
    private Long fxFluxo;
    @Column(name = "t_sem_semaforo_cd_semaforo")
    private Long tSemSemaforoCdSemaforo;
    @Column(name = "t_sem_sensor_cd_sensor")
    private Long TSemSensorCdSensor;
    @Column(name = "t_sem_disp_id_cd_disp")
    private Long tSemDispIdCdDisp;

    public Long getCdControladora() {
        return cdControladora;
    }

    public void setCdControladora(Long cdControladora) {
        this.cdControladora = cdControladora;
    }

    public LocalDate getDtMomentoEvento() {
        return dtMomentoEvento;
    }

    public void setDtMomentoEvento(LocalDate dtMomentoEvento) {
        this.dtMomentoEvento = dtMomentoEvento;
    }

    public Long getFxFluxo() {
        return fxFluxo;
    }

    public void setFxFluxo(Long fxFluxo) {
        this.fxFluxo = fxFluxo;
    }

    public Long gettSemSemaforoCdSemaforo() {
        return tSemSemaforoCdSemaforo;
    }

    public void settSemSemaforoCdSemaforo(Long tSemSemaforoCdSemaforo) {
        this.tSemSemaforoCdSemaforo = tSemSemaforoCdSemaforo;
    }

    public Long getTSemSensorCdSensor() {
        return TSemSensorCdSensor;
    }

    public void setTSemSensorCdSensor(Long TSemSensorCdSensor) {
        this.TSemSensorCdSensor = TSemSensorCdSensor;
    }

    public Long gettSemDispIdCdDisp() {
        return tSemDispIdCdDisp;
    }

    public void settSemDispIdCdDisp(Long tSemDispIdCdDisp) {
        this.tSemDispIdCdDisp = tSemDispIdCdDisp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Controladora that = (Controladora) o;
        return Objects.equals(cdControladora, that.cdControladora) && Objects.equals(dtMomentoEvento, that.dtMomentoEvento) && Objects.equals(fxFluxo, that.fxFluxo) && Objects.equals(tSemSemaforoCdSemaforo, that.tSemSemaforoCdSemaforo) && Objects.equals(TSemSensorCdSensor, that.TSemSensorCdSensor) && Objects.equals(tSemDispIdCdDisp, that.tSemDispIdCdDisp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdControladora, dtMomentoEvento, fxFluxo, tSemSemaforoCdSemaforo, TSemSensorCdSensor, tSemDispIdCdDisp);
    }
}

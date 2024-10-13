package br.com.fiap.semaforos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_sem_semaforo")
public class Semaforo {

    public Semaforo() {

    }

    public Semaforo(Long cdSemaforo, String lgLogradouro, Long lgNumero, String lgCidade, String lgEstado, Long tmTempoVerde, Long tmTempoAmarelo, Long tmTempoVeremelho, String dsUltimaAcao, LocalDate dtUltimaAcao, Long tmUltimaAcao) {
        this.cdSemaforo = cdSemaforo;
        this.lgLogradouro = lgLogradouro;
        this.lgNumero = lgNumero;
        this.lgCidade = lgCidade;
        this.lgEstado = lgEstado;
        this.tmTempoVerde = tmTempoVerde;
        this.tmTempoAmarelo = tmTempoAmarelo;
        this.tmTempoVeremelho = tmTempoVeremelho;
        this.dsUltimaAcao = dsUltimaAcao;
        this.dtUltimaAcao = dtUltimaAcao;
        this.tmUltimaAcao = tmUltimaAcao;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_CD_SEMAFORO"
    )
    @SequenceGenerator(
            name = "SQ_CD_SEMAFORO",
            sequenceName = "SQ_CD_SEMAFORO",
            allocationSize = 1
    )
    @Column(name = "cd_semaforo")
    private Long cdSemaforo;
    @Column(name = "lg_logradouro")
    private String lgLogradouro;
    @Column(name = "lg_numero")
    private Long lgNumero;
    @Column(name = "lg_cidade")
    private String lgCidade;
    @Column(name = "lg_estado")
    private String lgEstado;
    @Column(name = "tm_tempo_verde")
    private Long tmTempoVerde;
    @Column(name = "tm_tempo_amarelo")
    private Long tmTempoAmarelo;
    @Column(name = "tm_tempo_vermelho")
    private Long tmTempoVeremelho;
    @Column(name = "ds_ultima_acao")
    private String dsUltimaAcao;
    @Column(name = "dt_ultima_acao")
    private LocalDate dtUltimaAcao;
    @Column(name = "tm_ultima_acao")
    private Long tmUltimaAcao;

    public Long getCdSemaforo() {
        return cdSemaforo;
    }

    public void setCdSemaforo(Long cdSemaforo) {
        this.cdSemaforo = cdSemaforo;
    }

    public String getLgLogradouro() {
        return lgLogradouro;
    }

    public void setLgLogradouro(String lgLogradouro) {
        this.lgLogradouro = lgLogradouro;
    }

    public Long getLgNumero() {
        return lgNumero;
    }

    public void setLgNumero(Long lgNumero) {
        this.lgNumero = lgNumero;
    }

    public String getLgCidade() {
        return lgCidade;
    }

    public void setLgCidade(String lgCidade) {
        this.lgCidade = lgCidade;
    }

    public String getLgEstado() {
        return lgEstado;
    }

    public void setLgEstado(String lgEstado) {
        this.lgEstado = lgEstado;
    }

    public Long getTmTempoVerde() {
        return tmTempoVerde;
    }

    public void setTmTempoVerde(Long tmTempoVerde) {
        this.tmTempoVerde = tmTempoVerde;
    }

    public Long getTmTempoAmarelo() {
        return tmTempoAmarelo;
    }

    public void setTmTempoAmarelo(Long tmTempoAmarelo) {
        this.tmTempoAmarelo = tmTempoAmarelo;
    }

    public Long getTmTempoVeremelho() {
        return tmTempoVeremelho;
    }

    public void setTmTempoVeremelho(Long tmTempoVeremelho) {
        this.tmTempoVeremelho = tmTempoVeremelho;
    }

    public String getDsUltimaAcao() {
        return dsUltimaAcao;
    }

    public void setDsUltimaAcao(String dsUltimaAcao) {
        this.dsUltimaAcao = dsUltimaAcao;
    }

    public LocalDate getDtUltimaAcao() {
        return dtUltimaAcao;
    }

    public void setDtUltimaAcao(LocalDate dtUltimaAcao) {
        this.dtUltimaAcao = dtUltimaAcao;
    }

    public Long getTmUltimaAcao() {
        return tmUltimaAcao;
    }

    public void setTmUltimaAcao(Long tmUltimaAcao) {
        this.tmUltimaAcao = tmUltimaAcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semaforo semaforo = (Semaforo) o;
        return Objects.equals(cdSemaforo, semaforo.cdSemaforo)
                && Objects.equals(lgLogradouro, semaforo.lgLogradouro)
                && Objects.equals(lgNumero, semaforo.lgNumero)
                && Objects.equals(lgCidade, semaforo.lgCidade)
                && Objects.equals(lgEstado, semaforo.lgEstado)
                && Objects.equals(tmTempoVerde, semaforo.tmTempoVerde)
                && Objects.equals(tmTempoAmarelo, semaforo.tmTempoAmarelo)
                && Objects.equals(tmTempoVeremelho, semaforo.tmTempoVeremelho)
                && Objects.equals(dsUltimaAcao, semaforo.dsUltimaAcao)
                && Objects.equals(dtUltimaAcao, semaforo.dtUltimaAcao)
                && Objects.equals(tmUltimaAcao, semaforo.tmUltimaAcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                cdSemaforo,
                lgLogradouro,
                lgNumero,
                lgCidade,
                lgEstado,
                tmTempoVerde,
                tmTempoAmarelo,
                tmTempoVeremelho,
                dsUltimaAcao,
                dtUltimaAcao,
                tmUltimaAcao);
    }
}
